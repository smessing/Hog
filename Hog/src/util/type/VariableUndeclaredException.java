package util.type;

/**
 * 
 * @author Jason Halpern
 * @author Benjamin Rapaport
 *
 */
@SuppressWarnings("serial")
public class VariableUndeclaredException extends RuntimeException{
	public VariableUndeclaredException(String message) {
		super(message);
	}
}
