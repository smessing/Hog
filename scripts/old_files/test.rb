#!/usr/bin/env ruby

###################################################
HADOOP_HOME="/Users/ktran/hadoop-1.0.1"
HADOOP_VERSION="1.0.1"
JAVA_HOME="/usr/libexec/java_home"
JFLAGS = "-g"
JAVAC ="javac -classpath .:../build/java_cup_v10k"
CUP = "java -classpath .:../build/java_cup_v10k java_cup.Main <"
JFLEX = "../build/jflex-1.4.3/bin/jflex"
JAVA = "java -classpath .:../build/java_cup_v10k"






###################################################



#Parsing Hog Into Java
#
#
#
#
#

# /Users/ktran/hadoop-1.0.1/bin/hadoop jar wordcount.jar WordCount input output
#
#


COMPILE_CMD = "javac -classpath .:/Users/ktran/hadoop-1.0.1/hadoop-core-1.0.1.jar:/Users/ktran/hadoop-1.0.1/lib/commons-cli-1.2.jar WordCount.java"
system("#{COMPILE_CMD} ")
system("jar cvf wordcount.jar *.class  ")