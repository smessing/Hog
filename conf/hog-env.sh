# Set Hog-specific environment variables here.

# The only required environment variable is JAVA_HOME. All other are
# optional. When running a distributed configuration it is best to set
# JAVA_HOME in this file, so that it is correctly defined on remote nodes.

# The java implementation to use. Required.
export JAVA_HOME=/usr/bin/java

# The hadoop implementation to use. Required.
export HADOOP_HOME=/Users/ktran/hadoop-1.0.1

echo "This is the JAVA_HOME:${JAVA_HOME}"

echo "This is the HADOOP_HOME:${HADOOP_HOME}"