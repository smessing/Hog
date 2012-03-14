#!/usr/bin/env ruby

###################################################
HADOOP_HOME="/Users/ktran/hadoop-1.0.1"
HADOOP_VERSION="1.0.1"
JAVA_HOME="/usr/libexec/java_home"







###################################################
# /Users/ktran/hadoop-1.0.1/bin/hadoop jar wordcount.jar WordCount input output
#
#
COMPILE_CMD = "javac -classpath .:/Users/ktran/hadoop-1.0.1/hadoop-core-1.0.1.jar:/Users/ktran/hadoop-1.0.1/lib/commons-cli-1.2.jar WordCount.java"
system("#{COMPILE_CMD} ")
system("jar cvf wordcount.jar *.class  ")