/**
 * 
 */
package front_end;

import java.util.logging.Logger;

/**
 * The Hog compiler.
 * 
 * Usage:
 * 
 * hog [--hdfs|--local] source [arg1, arg2, ...]
 * 
 * For example,
 * 
 * hog --local WordCount.hog --input war_and_peace.txt --output
 * war_and_peace_counts.txt
 * 
 * @author sam
 * 
 */
public class Hog {

	// logger used for all nodes
	protected final static Logger LOGGER = Logger
			.getLogger(Hog.class.getName());
	protected static boolean local = true;
	protected static String source;
	protected static String input;
	protected static String output;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		usage(args);

	}

	public static void usage(String[] args) {

		if (args[0].equals("--help")) {
			printUsage();
		}

		if (args.length % 2 != 0) {
			LOGGER.severe("Invalid arguments");
			die();
		}

		local = args[0].equals("--hdfs") ? false : true;

		source = args[1];
		
		if (!source.endsWith(".java") && (!source.endsWith(".hog"))) {
			die();
		}

	}

	public static void die() {
		printUsage();
		System.exit(1);
	}

	public static void printUsage() {
		LOGGER.info("Hog --- a scripting MapReduce language");
		LOGGER
				.info("Usage: Hog [--hdfs|--local] source [--input file] [--output file]");
	}

}
