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
HOGCOMPILER=compiler/Hog.jar
INPUT_HOG_SOURCE=WordCount.hog
SOURCENAME=WordCount
INPUT_JAVA_SOURCE=Hog.java
JAVAC =javac
HADOOP_HOME=/usr/local/Cellar/hadoop/0.20.2/libexec
HADOOP_VERSION=1.0.1
JOBNAME=Hog
CLASSPATH = -classpath $(HADOOP_HOME)hadoop-core-1.0.1.jar
JAR=jar
JARFLAGS=-cf
HADOOP=$(HADOOP_HOME)bin/hadoop
FS=dfs
PUTINTODFS=-put
INPUTDATA=input/big.txt input/input.txt input/words.txt
DFSINPUTDIRECTORY=/users/sam/input/
DFSOUTPUTDIRECTORY=/users/sam/output

CLASSFILES=*.class
CAT=-cat
RMR=-rmr
JOBJAR=hog.jar
JOBNAME=Hog
default: buildandrun
USERNAME=ktran
MKDIR=-mkdir

makedir:
	$(HADOOP) $(FS) $(MKDIR) $(DFSINPUTDIRECTORY)
	
buildandrun:
	$(JAVAC) $(CLASSPATH) $(INPUT_JAVA_SOURCE)
	$(JAR) $(JARFLAGS) $(JOBJAR) $(CLASSFILES) 
	$(HADOOP) $(FS) $(PUTINTODFS) $(INPUTDATA) $(DFSINPUTDIRECTORY)
	$(HADOOP) $(JAR) $(JOBJAR) $(JOBNAME) $(DFSINPUTDIRECTORY) $(DFSOUTPUTDIRECTORY)
	$(HADOOP) $(FS) $(CAT) $(DFSOUTPUTDIRECTORY)/part-00000 > $(SOURCENAME).txt

compile:
	java -jar $(HOGCOMPILER) --local $(INPUT_HOG_SOURCE)

clean:
	$(RM) *~  *#
	$(HADOOP) $(FS) $(RMR) $(DFSINPUTDIRECTORY)
	$(HADOOP) $(FS) $(RMR) $(DFSOUTPUTDIRECTORY)	
	
