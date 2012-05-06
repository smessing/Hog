package util.error;

/**
 * 
 * @author Samuel Messing
 *
 */
@SuppressWarnings("serial")
public class TypeMismatchError extends RuntimeException {
	
	public TypeMismatchError(String message) {
		super(message);
	}

}
