# What we discussed:
* `Compile.sh`: We'll use some sort of a bash script to run individual Hog programs. In this script users can specify information about where Java, Hadoop and other things exist / how they are configured.
* Limit input to plaintext files
* `tokenize`: built-in function, similiar to `String.split()` in Java.
* `iter` object : generic iterator object
* Type signature declarations for `@Map` and `@Reduce`
* Valid identifier names follow Java's conventions.
* All reserved words in Hog are lowercase
* `print` function allows printing to standard out
* `@Main` block: runs first, users specify when to run map reduce with the built-in function `mapreduce()`

## Limit 

# For next time:
Next meeting is Monday, March 19th, at 4pm.
## All
* Read over the LRM, and generate comments to discuss on Monday's meeting

## Ben
* Write built-in functions for `list` in LRM
* Write system-level built-in functions in LRM
	* `mapreduce`
	* `tokenize`
	* `emit`
	* `print`
* Work on tutorial

## Jason
* Write built-in functions for `set` in LRM

## Kurry
* Write built-in functions for `map` in LRM
* Create Eclipse project, add to git repo
* Include initial build configuration (`ant`), such that it properly links to both `JFlex` and `Cup`.
* Set up Amazone Hadoop cluster with 4 nodes, e-mail out a shell account.

## Sam
* Write built-in functions for `iter` and `multiset` in LRM
* Translate LRM into LaTeX, add to git repo

##Paul
* Begin language tutorial
* Add CFG to LRM
* Create github.com account.
* Expand on grammar for type declarations and variable initialization.


