package util.type;

/**
 * 
 * @author Benjamin Rapaport
 * @author Jason Halpern
 *
 */
@SuppressWarnings("serial")
public class VariableRedefinedException extends RuntimeException {
	
	public VariableRedefinedException(String message) {
		super(message);
	}

}
