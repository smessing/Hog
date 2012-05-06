package util.error;

/**
 * 
 * @author Benjamin Rapaport
 * @author Jason Halpern
 *
 */
@SuppressWarnings("serial")
public class VariableRedefinedError extends RuntimeException {
	
	public VariableRedefinedError(String message) {
		super(message);
	}

}
