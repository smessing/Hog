package util.ast.node;

public class BiOpNode extends ExpressionNode {
	
	public static enum OpType{
		MINUS, PLUS, DIVIDE, MULT, MOD
	}
	
	protected OpType opType;
	
	protected BiOpNode() {
		this(null);
	}
	
	protected BiOpNode(Node parent) {
		super(parent);
	}
	
	protected BiOpNode(Node parent, OpType type) {
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
