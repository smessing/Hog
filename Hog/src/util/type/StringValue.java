package util.type;

public class StringValue extends ConstantValue{
	 	private final String val;
	    
	    StringValue(String s) {
	        val = s;
	    }
	    
	    public String value() {
	        return val;
	    }

	    @Override
	    public String toJavaObject() {
	        return val;
	    }
}
