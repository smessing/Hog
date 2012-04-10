package util.ast.node;

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

	public UnOpNode() {
		this(null);
	}
	
	public UnOpNode(Node parent) {
		this(parent, null);
	}
	
	public UnOpNode(Node parent, OpType type) {
		super(parent);
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
