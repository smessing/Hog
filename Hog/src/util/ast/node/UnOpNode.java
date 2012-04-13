package util.ast.node;

import java.util.ArrayList;

import util.type.Types.Type;

/**
 * A node representing the Unary Operator terminals in a parse tree.
 * 
 * @author sam
 *
 */
public abstract class UnOpNode extends ExpressionNode {
	
	// note: NONE means no unary operator applied.
	public static enum OpType {
		UMINUS, NOT, RETURN, INCR, DECR, CAST, NONE
	}
	
	protected OpType opType;
	
	public UnOpNode(ExpressionNode child, OpType opType) {
		this.children = new ArrayList<Node>();
		// note implicitly sets child.parent = this
		this.addChild(child);
		this.opType = opType;
	}
	
	public UnOpNode(ExpressionNode child, Type type) {
		this.children = new ArrayList<Node>();
		this.addChild(child);
		this.opType = OpType.CAST;
		this.type = type;
	}
	
	public OpType getOpType() {
		return opType;
	}

	@Override
	public String getName() {
		return opType.toString() + "<" + this.getTypeName() + ">";
	}

}
