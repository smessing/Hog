package util.ast.node;

import java.util.ArrayList;

/**
 * A node representing the Unary Operator terminals in a parse tree.
 * 
 * @author sam
 *
 */
public abstract class UnOpNode extends ExpressionNode {
	
	// note: NONE means no unary operator applied.
	public static enum OpType {
		UMINUS, NOT, RETURN, INCR, DECR, NONE
	}
	
	protected OpType opType;
	
	public UnOpNode(Node child, OpType opType) {
		this.children = new ArrayList<Node>();
		// note implicitly sets child.parent = this
		this.addChild(child);
		this.opType = opType;
	}
	
	public OpType getOpType() {
		return opType;
	}

	@Override
	public String getName() {
		return opType.toString() + "<" + this.getTypeName() + ">";
	}

}
