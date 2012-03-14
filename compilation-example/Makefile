JFLAGS = -g
JC = javac -classpath .:../build/java_cup_v10k
CUP = java -classpath .:../build/java_cup_v10k java_cup.Main <
JFLEX = ../build/jflex-1.4.3/bin/jflex
JAVA = java -classpath .:../build/java_cup_v10k
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	PascalLexer.java \
	PascalLexerTest.java \
	sym.java \

default: classes

classes: 
	$(CUP) pascal-tokens.cup
	$(JFLEX) pascal.jflex
	$(JC) PascalLexer.java PascalLexerTest.java sym.java
	$(JAVA) PascalLexerTest lexer-test.p

clean:
	rm -f *.class *~