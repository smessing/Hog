/**
 * 
 */
package front_end;

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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		usage(args);

	}

	public static void usage(String[] args) {
		
	}
	
}
