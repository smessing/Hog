package util.type;

public class DoubleValue extends ConstantValue{

	private final double val;
    
    DoubleValue(double f) {
        val = Double.valueOf(f);
    }
    
    public double value() {
        return val;
    }

    @Override
    public Double toJavaObject() {
        return Double.valueOf(val);
    }
}
