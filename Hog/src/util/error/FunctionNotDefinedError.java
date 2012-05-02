package util.error;

@SuppressWarnings("serial")
public class FunctionNotDefinedError extends RuntimeException{
	public FunctionNotDefinedError(String message) {
		super(message);
	}
}
