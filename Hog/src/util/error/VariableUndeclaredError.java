package util.error;

/**
 * 
 * @author Jason Halpern
 * @author Benjamin Rapaport
 *
 */
@SuppressWarnings("serial")
public class VariableUndeclaredError extends RuntimeException{
	public VariableUndeclaredError(String message) {
		super(message);
	}
}
