package util.error;

/**
 * 
 * @author Jason Helpern
 * @author Benjamin Rapaport
 *
 */
@SuppressWarnings("serial")
public class InvalidFunctionArgumentsError extends RuntimeException {

	public InvalidFunctionArgumentsError(String message) {
		super(message);
	}
}
