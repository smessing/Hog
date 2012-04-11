package util.ast.node;

import java.util.List;

/**
 * A node representing the Unary Operator terminals in a parse tree.
 * 
 * @author sam
 *
 */
public class UnOpNode extends ExpressionNode {
	
	public static enum OpType {
		UMINUS, NOT, RETURN, INCR, DECR
	}
	
	protected OpType opType;
	
	public UnOpNode(List<Node> children, OpType type) {
		super(children);
		this.opType = type;
	}
	
	public OpType getOpType() {
		return opType;
	}

	@Override
	public String getName() {
		return opType.toString() + "<" + this.getTypeName() + ">";
	}

}
