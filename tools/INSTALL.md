Installing JFlex

Unix with tar archive:

1. Download the tar archive

   curl -O http://jflex.de/jflex-1.4.3.tar.gz

2. Decompress the archive into a directory of your choice with GNU tar,
for example /usr/local:

    sudo tar -C /usr/local -xvzf jflex-1.4.3.tar.gz

3. Make a symbolic link from somewhere in your binary path to bin/jflex,
for example:
    
    sudo ln -s /usr/local/jflex/bin/jflex /usr/bin/jflex

