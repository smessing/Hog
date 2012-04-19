package util.type;

import util.type.Types.Type;


public abstract class ConstantValue {

	public abstract Object toJavaObject();
	

	public static BooleanValue makeBoolean(boolean v) {
        return new BooleanValue(v);
    }
    
	public static LongValue makeLong(long v) {
        return new LongValue(v);
    }
	
	public static DoubleValue makeDouble(double d) {
        return new DoubleValue(d);
    }
    
    public static StringValue makeString(String v) {
        return new StringValue(v);
    }
    
    public static ConstantValue convert(Type type, double v) {
		if (Types.isInt(type)) return ConstantValue.makeLong(Long.valueOf((int)v));
        if (Types.isReal(type)) return ConstantValue.makeDouble(v);
        if (Types.isBool(type) && v == 0) return ConstantValue.makeBoolean(false);
        if (Types.isBool(type) && v == 0) return ConstantValue.makeBoolean(true);
        if (Types.isText(type)) return ConstantValue.makeString(Double.toString(v));

        //throw new InternalCompilerError("Unexpected type "+type);
        return null;
    }
    
    public static ConstantValue convert(Type type, int v) {
		if (Types.isInt(type)) return ConstantValue.makeLong(Long.valueOf(v));
        if (Types.isReal(type)) return ConstantValue.makeDouble((double)v);
        if (Types.isBool(type) && v == 0) return ConstantValue.makeBoolean(false);
        if (Types.isBool(type) && v == 0) return ConstantValue.makeBoolean(true);
        if (Types.isText(type)) return ConstantValue.makeString(Integer.toString(v));

        //throw new InternalCompilerError("Unexpected type "+type);
        return null;
    }
    
    public static ConstantValue convert(Type type, Boolean v) {
    	if (Types.isText(type)) return ConstantValue.makeString(Boolean.toString(v));
    	
    	 //throw new InternalCompilerError("Unexpected type "+type);
    	 return null;
    }
    
    public static ConstantValue convert(Type type, String v) {
    	if (Types.isReal(type)) return ConstantValue.makeDouble(Integer.parseInt( v ));
    	if (Types.isInt(type)) return ConstantValue.makeLong(Long.valueOf( v ));
    	
    	 //throw new InternalCompilerError("Unexpected type "+type);
    	 return null;
    }
 
	
}
