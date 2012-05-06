package util.error;

/**
 * 
 * @author Benjamin Rapaport
 * @author Jason Halpern
 *
 */
@SuppressWarnings("serial")
public class FunctionNotDefinedError extends RuntimeException{
	public FunctionNotDefinedError(String message) {
		super(message);
	}
}
