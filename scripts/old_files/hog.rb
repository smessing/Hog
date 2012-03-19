#!/usr/bin/env ruby
require 'fileutils'
require 'thread'

#Usage : hog.rb [--hdfs|--local|--print] job <job args>
# --hdfs: if job ends in ".hog" or ".java" and the file exists, link it against JARFILE (below) and then run it on HOST.
#        else, it is assumed to be a full classname to an item in the JARFILE, which is run on HOST
# --local: run locally according to the rules above
# --print: print the command YOU SHOULD ENTER on the remote node. Useful for screen sessions.

#######################################################

#Get the absolute path of the original (non-symlink) file.
ORIGINAL_FILE=File.symlink?(__FILE__) ? File.readlink(__FILE__) : __FILE__
SCIENCE_ROOT=File.expand_path(File.dirname(ORIGINAL_FILE)+"/../")
JARFILE=SCIENCE_ROOT + "/target/scalding-assembly-#{SCALDING_VERSION}.jar" #what jar has all the depencies for this job
puts JARFILE
HOST="my.remote.host" #where the job is rsynced to and run
TMPDIR="/tmp"
BUILDDIR=TMPDIR+"/script-build"
LOCALMEM="3g" #how much memory for java to use when running in local mode
#replace COMPILE_CMD="scalac" if you want to run with your systems default scala compiler
SBT_HOME="#{ENV['HOME']}/.sbt"
COMPILE_CMD="java -cp #{SBT_HOME}/boot/scala-2.8.1/lib/scala-library.jar:#{SBT_HOME}/boot/scala-2.8.1/lib/scala-compiler.jar -Dscala.home=#{SBT_HOME}/boot/scala-2.8.1/lib/ scala.tools.nsc.Main"





#######################################################


if ARGV.size < 1
  $stderr.puts("ERROR: insufficient args.")
  #Make sure to print out up to Configuration above:
  system("head -n 19 #{__FILE__} | tail -n+4")
  exit(1)
end

MODE = case ARGV[0]
  when "--hdfs"
    ARGV.shift
  when "--local"
    ARGV.shift
  when "--print"
    ARGV.shift
  else
    #default:
    "--hdfs"
end

JOBFILE=ARGV.shift

def file_type
    JOBFILE =~ /\.java$/
    $1
end

def is_file?
    !file_type.nil?
end

PACK_RE = /^package ([^;]+)/
JOB_RE = /class\s+([^\s(]+).*extends\s+.*Job/
EXTENSION_RE = /(.*)\.(scala|java)$/

#Get the name of the job from the file.
#the rule is: last class in the file, or the one that matches the filename
def get_job_name(file)
  package = ""
  job = nil
  default = nil
  if file =~ EXTENSION_RE
    default = $1
    File.readlines(file).each { |s|
      if s =~ PACK_RE
        package = $1.chop + "."
      elsif s =~ JOB_RE
        unless job and default and (job.downcase == default.downcase)
          #use either the last class, or the one with the same name as the file
          job = $1
        end
      end
    }
    raise "Could not find job name" unless job
    "#{package}#{job}"
  else
    file
  end
end

JARPATH=File.expand_path(JARFILE)
JARBASE=File.basename(JARFILE)
JOBPATH=File.expand_path(JOBFILE)
JOB=get_job_name(JOBFILE)
JOBJAR=JOB+".jar"
JOBJARPATH=TMPDIR+"/"+JOBJAR

def is_local?
  (MODE =~ /^--local/) != nil
end

def needs_rebuild?
  !File.exists?(JOBJARPATH) || File.stat(JOBJARPATH).mtime < File.stat(JOBPATH).mtime
end

def build_job_jar
  $stderr.puts("compiling " + JOBFILE)
  FileUtils.mkdir_p(BUILDDIR)
  unless system("#{COMPILE_CMD} -classpath #{JARPATH} -d #{BUILDDIR} #{JOBFILE}")
    FileUtils.rm_f(rsync_stat_file(JOBJARPATH))
    FileUtils.rm_rf(BUILDDIR)
    exit(1)
  end

  FileUtils.rm_f(JOBJARPATH)
  system("jar cf #{JOBJARPATH} -C #{BUILDDIR} .")
  FileUtils.rm_rf(BUILDDIR)
end

def hadoop_command
  "HADOOP_CLASSPATH=/usr/share/java/hadoop-lzo-0.4.14.jar:#{JARBASE}:job-jars/#{JOBJAR} " +
    "hadoop jar #{JARBASE} -libjars job-jars/#{JOBJAR} -Dmapred.reduce.tasks=#{REDUCERS} #{JOB} --hdfs " +
    ARGV.join(" ")
end

def jar_mode_command
  "hadoop jar #{JARBASE} -Dmapred.reduce.tasks=#{REDUCERS} #{JOB} --hdfs " + ARGV.join(" ")
end