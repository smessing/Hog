
public interface FunctionInstance {

	/*
	 * The functions's return type.
	 */
	public Type returnType();
	
	/*
	 * Destructively set the function's return type.
	 * 
	 */
	
	void setReturnType(Type type);
}
