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
 * @author Benjamin Rapaport
 * 
 * Code adapted from http://www.javalobby.org/java/forums/t18515.html
 *
 */
 
public class BriefLogFormatter extends Formatter {
	/** format field of type DateFormat */
	private static final DateFormat format = new SimpleDateFormat("h:mm:ss");
	/** lineSep field of type String which contains line.separartor of system */
	private static final String lineSep = System.getProperty("line.separator");
	 
	/** Method format(LogRecord record)
	 * A Custom format implementation that is designed for brevity.
	 * @param record LogRecord
	 * @return message String
	 */
	public String format(LogRecord record) {
		String loggerName = record.getLoggerName();
		if(loggerName == null) {
			loggerName = "root";
		}
		StringBuilder output = new StringBuilder()
		    .append("[LOG] ")
			.append(record.getMessage()).append(' ')
			.append(lineSep);
		return output.toString();		
	}
 
}
