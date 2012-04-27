package util.ast.node;

import back_end.Visitor;
import util.type.Types;

/**
 * 
 * 
 * @author ben
 *
 */
public class ExceptionTypeNode extends TypeNode {

	protected Types.Exception localType;
	/**
	 * 
	 * @see Types.Exception for different exception types.
	 * @param localType 
	 */
	public ExceptionTypeNode(Types.Exception localType) {
		this.localType = localType;
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
		return "Exception Type: " + localType.toString();
	}
}
