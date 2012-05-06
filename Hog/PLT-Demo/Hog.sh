#!/bin/bash

# Usage
# ./Hog.sh source.hog

java -jar compiler/Hog.jar --local "$@"

javac -classpath compiler/hadoop-core-1.0.1.jar "Hog.java"

echo "Compile Success"
echo "Upload Hog.jar to Amazon EC2"