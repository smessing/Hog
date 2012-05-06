#!/bin/bash

# Usage
# ./Hog.sh source.hog



if java -jar compiler/Hog.jar --local "$@";
then
    echo "Hog Compiler Was a Sucess!"
else
    echo "Hog Compiler Failed With Errors"
    exit 1
fi

if javac -classpath compiler/hadoop-core-1.0.1.jar "Hog.java";
then
    echo "Java Compiler Successfully Compiled Hog Source"
else
    echo "Java Compiler Failed When Linking Hadoop Jar"
    exit 1
fi

if jar -cf Hog.jar *.class;
then
    echo "All Compilation Steps Successful"
    echo "Upload Hog.jar to Amazon EC2"
else
    echo "Java Archive Counld Not Be Made Check For Errors in Java Source"
    exit 1
fi
