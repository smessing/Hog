package util.error;

@SuppressWarnings("serial")
public class MissingReturnError extends RuntimeException {
	
	public MissingReturnError(String message) {
		super(message);
	}

}
