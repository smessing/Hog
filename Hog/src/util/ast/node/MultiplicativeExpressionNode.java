package util.ast.node;

public class MultiplicativeExpressionNode extends ExpressionNode {

	protected Type type;
	
	public MultiplicativeExpressionNode(Node parent) {
		super(parent);
		type = null;
		//computeType();
	}
	
	protected void computeType() {
		throw new UnsupportedOperationException("TODO");
	}
	
	protected int compareTo(MultiplicativeExpressionNode that) {
		return (this.getName().compareTo(that.getName()));
	}
	
	@Override
	public int compareTo(Node that) {
		if (that instanceof MultiplicativeExpressionNode) {
			return this.compareTo((MultiplicativeExpressionNode) that);
		}
		return -1;
	}

	@Override
	public String getName() {
		return type.toString();
	}
	

}
