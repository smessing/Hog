/*
 * 
 * 
 * 
 */
public abstract class IdentifierAttributes{

	/*
	 * Get the type object for the declaration's type.
	 * 
	 */
	public abstract Type declType();
	
	/*
	 * Get the declarations type.
	 */
	public abstract Type type();
	
	/*
	 * Get the declarations name.
	 */
	public abstract String name();
	
	/*
	 * Set the declarations name.
	 * 
	 */
	
	public abstract Identifier name(String name);

	
}
