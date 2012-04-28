package util.type;

public class StringValue extends ConstantValue{
	 	/** val final field that contains the String value of this StringValue */
		private final String val;
	    
		/** Constructor StringValue(String s)
		 * @param s
		 */
	    public StringValue(String s) {
	        val = s;
	    }
	    /** Method value() returns String val field */
	    public String value() {
	        return val;
	    }

	    /** Method toJavaObject() returns String */
	    @Override
	    public String toJavaObject() {
	        return val;
	    }
}
