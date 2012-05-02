package util.error;

@SuppressWarnings("serial")
public class FunctionNotDefinedError extends Exception{
	public FunctionNotDefinedError(String message) {
		super(message);
	}
}
