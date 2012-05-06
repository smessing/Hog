# Makefile for Hog Compilation
# Programming Languages and Translator
# Version 1.0
# Kurry Tran
# 04 May 2012
#
#
##################################################################
##################################################################

## Hadoop stuff:

## Program-specific stuff:


# Set Up Compiler Directories
# TODO Fill In Directories
JFLAGS = -g -classpath
HOGCOMPILER=compiler/Hog.jar

# Input Hog Source Name
INPUT_HOG_SOURCE=WordCount.hog
SOURCENAME=WordCount

# DO NOT CHANGE
INPUT_JAVA_SOURCE=Hog.java

# Java Compiler
JAVAC =javac

# Hadoop Home
HADOOP_HOME=/Users/ktran/hadoop-1.0.1/
HADOOP_VERSION=1.0.1
JOBNAME=Hog
CLASSPATH = -classpath $(HADOOP_HOME)hadoop-core-$(HADOOP_VERSION).jar
JAR=jar
JARFLAGS=-cf
HADOOP=$(HADOOP_HOME)bin/hadoop
FS=dfs
PUTINTODFS=-put
INPUTDATA=input/big.txt input/input.txt input/words.txt

# HDFS Input/Output Directories
DFSINPUTDIRECTORY=/users/ktran/input/
DFSOUTPUTDIRECTORY=/users/ktran/output


CLASSFILES=*.class
CAT=-cat
RMR=-rmr
JOBJAR=hog.jar
JOBNAME=Hog
USERNAME=ktran
MKDIR=-mkdir

default: buildandrun

makedir:
	$(HADOOP) $(FS) $(MKDIR) $(DFSINPUTDIRECTORY)

buildandrun:
	#$(JAVAC) $(CLASSPATH) $(INPUT_JAVA_SOURCE)
	#$(JAR) $(JARFLAGS) $(JOBJAR) $(CLASSFILES) 
	#$(HADOOP) $(FS) $(PUTINTODFS) $(INPUTDATA) $(DFSINPUTDIRECTORY)
	$(HADOOP) $(JAR) $(JOBJAR) $(JOBNAME) $(DFSINPUTDIRECTORY) $(DFSOUTPUTDIRECTORY)
	$(HADOOP) $(FS) $(CAT) $(DFSOUTPUTDIRECTORY)/part-00000 > $(SOURCENAME).txt

compile:
	java -jar $(HOGCOMPILER) --local $(INPUT_HOG_SOURCE)

clean:
	$(RM) *~  *#
	$(HADOOP) $(FS) $(RMR) $(DFSINPUTDIRECTORY)
	$(HADOOP) $(FS) $(RMR) $(DFSOUTPUTDIRECTORY)	
