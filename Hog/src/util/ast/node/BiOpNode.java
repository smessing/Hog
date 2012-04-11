package util.ast.node;

import java.util.ArrayList;
import java.util.List;

/**
 * A node representing the Binary Operator terminals in a parse tree.
 * 
 * @author sam
 *
 */
public class BiOpNode extends ExpressionNode {
	
	public static enum OpType{
		MINUS, PLUS, DIVIDE, TIMES, MOD
	}
	
	protected OpType opType;
	
	public BiOpNode() {
		this(new ArrayList<Node>());
	}
	
	public BiOpNode(List<Node> children) {
		this(children, null);
	}
	
	public BiOpNode(List<Node> children, OpType type) {
		super(children);
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
