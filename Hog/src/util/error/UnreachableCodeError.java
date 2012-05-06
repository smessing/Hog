package util.error;

/**
 * 
 * @author Paul Tylkin
 *
 */
@SuppressWarnings("serial")
public class UnreachableCodeError extends RuntimeException {

	public UnreachableCodeError(String message) {
		super(message);
	}

}
