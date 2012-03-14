#!/usr/bin/env ruby

###################################################

# Hadoop Configuration
HADOOP_HOME="/Users/ktran/hadoop-1.0.1"
HADOOP_VERSION="1.0.1"
JAVA_HOME="/usr/libexec/java_home"

# Pascal to Java File Configuration
JFLAGS = "-g"
JAVAC ="javac -classpath .:../build/java_cup_v10k"
CUP = "java -classpath .:../build/java_cup_v10k java_cup.Main <"
JFLEX = "../build/jflex-1.4.3/bin/jflex"
JAVA = "java -classpath .:../build/java_cup_v10k"
CUP_FILE = "pascal-tokens.cup"
JFLEX_FILE = "pascal.jflex"
JAVAC_FILES = " PascalLexer.java PascalLexerTest.java sym.java"
JAVA_EXECUTABLE = "PascalLexerTest lexer-test.p"

###################################################

#Parsing Hog Into Java

def java_cup_command
    system("#{CUP} #{CUP_FILE}")
end

def jflex_command
    system("#{JFLEX} #{JFLEX_FILE}")
end

def javac_command
    system("#{JAVAC} #{JAVAC_FILES}")
end

def java_lexer_command
    system("#{JAVA} #{JAVA_EXECUTABLE}")
end

java_cup_command
jflex_command
javac_command
java_lexer_command

PACK_RE = /^package ([^;]+)/
JOB_RE = /class\s+([^\s(]+).*extends\s+.*Job/
EXTENSION_RE = /(.*)\.java$/

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

COMPILE_CMD = "javac -classpath .:/Users/ktran/hadoop-1.0.1/hadoop-core-1.0.1.jar:/Users/ktran/hadoop-1.0.1/lib/commons-cli-1.2.jar WordCount.java"
system("#{COMPILE_CMD} ")
system("jar cvf wordcount.jar *.class  ")
system("/Users/ktran/hadoop-1.0.1/bin/hadoop jar wordcount.jar WordCount input output")