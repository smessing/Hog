package util.ast.node;

import back_end.Visitor;
import util.type.Types;

/**
 * 
 * 
 * @author ben, sam
 *
 */
public class ExceptionTypeNode extends TypeNode {

	protected Types.Exception exceptionType;
	
	/**
	 * 
	 * @see Types.Exception for different exception types.
	 * @param localType 
	 */
	public ExceptionTypeNode(Types.Exception exceptionType) {
		this.exceptionType = exceptionType;
	}
	
	public Types.Exception getExceptionType() {
		return this.exceptionType;
	}
	
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		return "Exception Type: " + exceptionType.toString();
	}

	@Override
	public boolean isBoolean() {
		return false;
	}

	@Override
	public boolean isDerived() {
		return false;
	}

	@Override
	public boolean isDict() {
		return false;
	}

	@Override
	public boolean isException() {
		return true;
	}

	@Override
	public boolean isNumeric() {
		return false;
	}

	@Override
	public boolean isPrimitive() {
		return false;
	}

	@Override
	public boolean isText() {
		return false;
	}
}
