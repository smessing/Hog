package util.ast.node;

public class UnOpNode extends ExpressionNode {
	
	public static enum OpType {
		UMINUS, NOT, RETURN
	}
	
	protected OpType opType;

	protected UnOpNode(Node parent) {
		super(parent);
		this.opType = null;
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
		if (that instanceof UnOpNode) {
			return this.compareTo((UnOpNode) that);
		}
		return -1;
	}
	
	private int compareTo(UnOpNode that) {
		return this.opType.compareTo(that.getOpType());
	}

}
