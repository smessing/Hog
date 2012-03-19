#!/usr/bin/env ruby

###################################################
HADOOP_HOME="/Users/ktran/hadoop-1.0.1/bin"
HADOOP_VERSION="1.0.1"







###################################################
system("mkdir wordcount_classes")
COMPILE_CMD = "javac -classpath ${HADOOP_HOME}/hadoop-${HADOOP_VERSION}-core.jar -d wordcount_classes WordCount.java"
system("#{COMPILE_CMD} ")
system("jar -cvf wordcount.jar -C wordcount_classes/")