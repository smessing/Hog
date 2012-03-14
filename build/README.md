Installing JFlex

Unix with tar archive:

1. Download the tar archive

   - curl -O http://jflex.de/jflex-1.4.3.tar.gz

2. Decompress the archive into a directory of your choice with GNU tar,
for example /usr/share:

    - sudo tar -C /usr/share -xvzf jflex-1.4.3.tar.gz

3. Make a symbolic link from somewhere in your binary path to bin/jflex,
for example:
    
    - sudo ln -s /usr/share/jflex/bin/jflex /usr/bin/jflex


Installing JavaCUP

Unix with tar archive:

1. Download the tar archive
     
    - curl -O http://www2.cs.tum.edu/projects/cup/java_cup_v10k.tar.gz

2. Decompress the archive into a directory of your choice with GNU tar,
for example /usr/local:

    - sudo tar -C /usr/share -xvzf java_cup_v10k.tar.gz
  
Steps to use JavaCup

1. Write a javaCup specification (cup file)
   - Defines the grammar and actions in a file (say, calc.cup)

2. Run javaCup to generate a parser
   - java java_cup.Main calc.cup
   - Notice the package prefix java_cup before Main;
   - Will generate parser.java and sym.java (default)

3. Write your program that uses the parser
   - For example, UseParser.java

4. Compile and run your program


