package util.error;

@SuppressWarnings("serial")
public class InvalidFunctionArgumentsError extends RuntimeException {

	public InvalidFunctionArgumentsError(String message) {
		super(message);
	}
}
