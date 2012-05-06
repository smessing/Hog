package util.error;

/**
 * 
 * @author Paul Tylkin
 *
 */
@SuppressWarnings("serial")
public class MissingReturnError extends RuntimeException {

	public MissingReturnError(String message) {
		super(message);
	}

}