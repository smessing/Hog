# Makefile for Hog Compilation
# Programming Languages and Translator
# Version 1.0
# Kurry Tran
# 04 May 2012
#
#

##################################################################
##################################################################

# Set Up Compiler Directories
# TODO Fill In Directories
JFLAGS = -g -classpath
CLASSES_OUTPUT_DIRECTORY = tmp/classes
CLASSES_DIRECTORY = tmp
TMPDIR="/tmp"
BUILDDIR=
INPUT_HOG_SOURCE=WordCount.hog
INPUT_JAVA_SOURCE =WordCount.java
JAVAC =javac
HADOOP_HOME=/Users/ktran/hadoop-1.0.1/bin
HADOOP_VERSION=1.0.1
JOBNAME=WordCount
JAVA_HOME=
CLASSPATH = -classpath ../hadoop-core-1.0.1.jar
JAR=jar
JARFLAGS=-cf
HADOOP=../bin/hadoop
FS=dfs
PUTINTODFS=-put
INPUTDATA=input/drugs.txt
OUTPUTDATA=
DFSINPUTDIRECTORY=/users/ktran/input/
# These exports are for security exception
# when running hadoop on Mac OS X
export HADOOP_OPTS:= -Djava.security.krb5.realm=OX.AC.UK -Djava.security.krb5.kdc=kdc0.ox.ac.uk:kdc1.ox.ac.uk
CLASSFILES=*.class
CAT=-cat
RMR=-rmr
JOBJAR=wordcount.jar
JOBNAME=WordCount
default: buildandrun

buildandrun:
	$(JAVAC) $(CLASSPATH) $(INPUT_JAVA_SOURCE)
	$(JAR) $(JARFLAGS) $(JOBJAR) $(CLASSFILES) 
	$(HADOOP) $(FS) $(PUTINTODFS) $(INPUTDATA) $(DFSINPUTDIRECTORY)
	$(HADOOP) $(JAR) $(JOBJAR) $(JOBNAME) /users/ktran/input output 
	$(HADOOP) $(FS) $(CAT) /user/ktran/output/part-00000
clean:
	$(HADOOP) $(FS) $(RMR) /users/ktran/input
	$(HADOOP) $(FS) $(RMR) /user/ktran/output	
	$(RM) *~