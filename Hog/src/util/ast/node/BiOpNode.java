package util.ast.node;

import java.util.ArrayList;
import java.util.List;

/**
 * A node representing the Binary Operator terminals in a parse tree.
 * 
 * @author sam
 *
 */
public abstract class BiOpNode extends ExpressionNode {
	
	public static enum OpType{
		MINUS, PLUS, DIVIDE, TIMES, MOD
	}
	
	protected OpType opType;
	
	public BiOpNode(OpType type, Node left, Node right) {
		this.children = new ArrayList<Node>();
		this.children.add(left);
		this.children.add(right);
		this.opType = type;	
	}
	
	public OpType getOpType() {
		return opType;
	}
	
	public void setOpType(OpType type) {
		this.opType = type;
	}

	@Override
	public String getName() {
		return opType.toString() + "<" + this.getTypeName() + ">";
	}

}
