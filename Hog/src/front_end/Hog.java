/**
 * 
 */
package front_end;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Logger;

/**
 * The Hog compiler.
 * 
 * Usage:<br/><br/>
 * 
 * <code>hog [--hdfs|--local] source [arg1, arg2, ...]<br/><br/></code>
 * 
 * For example,<br/><br/>
 * 
 * <code>hog --local WordCount.hog --input war_and_peace.txt --output
 * war_and_peace_counts.txt</code><br/><br/>
 * 
 * Compiles the program <code>WordCount.hog</code>, and runs the program on a local
 * Hadoop cluster on the file <code>war_and_peace.txt</code>. This class handles
 * copying <code>war_and_peace.txt</code> to HDFS (Hadoop's Distributed File System).
 * The class also handles downloading the output to the file 
 * <code>war_and_peace_counts.txt</code>.
 * 
 * @author sam
 * 
 */
public class Hog {

	// logger used for all nodes
	protected final static Logger LOGGER = Logger
			.getLogger(Hog.class.getName());
	protected static boolean local = true;
	protected static boolean hasInput;
	protected static boolean hasOutput;
	protected static FileReader source;
	protected static String input;
	protected static String output;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		usage(args);
		FileReader sourceReader = null;
		try {
			sourceReader = new FileReader(new File(source));
		} catch (FileNotFoundException fnfe) {
			
			LOGGER.severe("Hog program " + source + "not found!");
			System.exit(1);
			
		}
		Parser parser = new Parser(new Lexer(source));

	}

	/**
	 * Processes the input to this classes main function.
	 * 
	 * @param args the passed in command-line arguments.
	 */
	public static void usage(String[] args) {

		if (args[0].equals("--help")) {
			printUsage();
		}

		if (args.length % 2 != 0) {
			LOGGER.severe("Invalid arguments");
			die();
		}

		local = args[0].equals("--hdfs") ? false : true;
		
		try {
			source = new FileReader(args[1]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (!args[1].endsWith(".java") && (!args[1].endsWith(".hog"))) {
			die();
		}
		
		if (args.length == 6) {
			
			input = args[2].equals("--input") ? args[3] : args[5];
			output = args[2].equals("--output") ? args[3] : args[5];
			hasInput = hasOutput = true;
			
		} else if (args.length == 4) {
			
			input = args[2].equals("--input") ? args[3] :"";
			output = args[2].equals("--output") ? args[3] : "";
			hasInput = input.equals("") ? false : true;
			hasOutput = output.equals("") ? false : true;
		}

	}

	/**
	 * Prints usage information and exits.
	 */
	public static void die() {
		printUsage();
		System.exit(1);
	}

	/**
	 * Prints the usage information for the main method in this class to standard out.
	 */
	public static void printUsage() {
		LOGGER.info("Hog --- a scripting MapReduce language");
		LOGGER
				.info("Usage: Hog [--hdfs|--local] source [--input file] [--output file]");
	}

}
