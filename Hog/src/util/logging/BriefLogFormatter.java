/**
 * 
 */
package util.logging;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ben
 * Code adapted from http://www.javalobby.org/java/forums/t18515.html
 *
 */
 
public class BriefLogFormatter extends Formatter {
	
	private static final DateFormat format = new SimpleDateFormat("h:mm:ss");
	private static final String lineSep = System.getProperty("line.separator");
	/**
	 * A Custom format implementation that is designed for brevity.
	 */
	public String format(LogRecord record) {
		String loggerName = record.getLoggerName();
		if(loggerName == null) {
			loggerName = "root";
		}
		StringBuilder output = new StringBuilder()
		    .append("[LOG] ")
			.append(record.getMessage()).append(' ')
			.append(loggerName)
			.append("  [")
			.append(record.getLevel()).append('|')
			.append(Thread.currentThread().getName()).append('|')
			.append(format.format(new Date(record.getMillis())))
			.append("]: ")
			.append(lineSep);
		return output.toString();		
	}
 
}
