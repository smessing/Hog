package util.ast.node;

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
		this(null);
	}
	
	public BiOpNode(Node parent) {
		super(parent);
		this.opType = null;
	}
	
	public BiOpNode(Node parent, OpType type) {
		this(parent);
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
