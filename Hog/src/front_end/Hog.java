/**
 * 
 */
package front_end;

import java.util.logging.Logger;

import util.ast.node.Node;

/**
 * The Hog compiler.
 * 
 * Usage:
 * 
 * hog [--hdfs|--local] source [arg1, arg2, ...]
 * 
 * For example,
 * 
 * hog --local WordCount.hog --input war_and_peace.txt --output war_and_peace_counts.txt
 * 
 * @author sam
 *
 */
public class Hog {
	
	// logger used for all nodes
	protected final static Logger LOGGER = Logger.getLogger(Hog.class
			.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		usage(args);

	}

	public static void usage(String[] args) {
		if (args.length % 2 != 0) {
		}
	}
	
}
