package scratch;

import util.type.Types;


public class TypeCheck extends Types{
	/** Method isNumeric(Types.Primitive t)
	 * Returns a boolean which has value true if t is numeric.
	 * @param t
	 * @return
	 */
	public static boolean isNumeric(Types.Primitive t){
		if(t == Types.Primitive.INT || t == Types.Primitive.REAL){
			return true;
		}
		else{
			return false;
		}
	}
	/** Method correctType(Types.Primitive x1, Types.Primitive x2)
	 * This method determines the correct type to cast a primitive value.
	 * @param x1 Types.Primitive
	 * @param x2 Types.Primitive
	 * @return
	 */
	public static Types.Primitive correctType(Types.Primitive x1, Types.Primitive x2){
		if(!isNumeric(x1) || !isNumeric(x2)){
			return null;
		}
		else if(x1 == Types.Primitive.INT || x2 == Types.Primitive.INT){
			return Types.Primitive.INT;
		}
		else if(x1 == Types.Primitive.REAL || x2 == Types.Primitive.REAL){
			return Types.Primitive.REAL;
		}
		else if(x1 == Types.Primitive.REAL || x2 == Types.Primitive.INT){
			return Types.Primitive.REAL;
		}
		else if(x1 == Types.Primitive.INT || x2 == Types.Primitive.REAL){
			return Types.Primitive.REAL;
		}
		else{
			return Types.Primitive.REAL;
		}
	}
	
	
	

}