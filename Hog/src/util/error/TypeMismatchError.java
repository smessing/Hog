package util.error;

@SuppressWarnings("serial")
public class TypeMismatchError extends RuntimeException {
	
	public TypeMismatchError(String message) {
		super(message);
	}

}
