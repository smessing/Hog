package util.error;

@SuppressWarnings("serial")
public class UnreachableCodeError extends RuntimeException {
	
	public UnreachableCodeError(String message) {
		super(message);
	}

}
