package util.ast.node;

/**
 * A node representing the Binary Operator terminals in a parse tree.
 * 
 * @author sam
 *
 */
public class BiOpNode extends ExpressionNode {
	
	public static enum OpType{
		MINUS, PLUS, DIVIDE, MULT, MOD
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

	@Override
	public String getName() {
		return opType.toString();
	}

	@Override
	public int compareTo(Node that) {
		if (that instanceof BiOpNode) {
			return this.compareTo((BiOpNode) that);
		}
		return -1;
	}
	
	protected int compareTo(BiOpNode that) {
		return this.opType.compareTo(that.getOpType());
	}

}
