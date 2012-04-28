package util.type;

public class DoubleValue extends ConstantValue{
	/** val final field of type double */
	private final double val;
    /** Constructor of DoubleValue(double f)
     * @param f
     */
    DoubleValue(double f) {
        val = Double.valueOf(f);
    }
    /** Method value() which returns val field of type double*/
    public double value() {
        return val;
    }
    /** Method toJavaObject() which returns Double object of val field */
    @Override
    public Double toJavaObject() {
        return Double.valueOf(val);
    }
}
