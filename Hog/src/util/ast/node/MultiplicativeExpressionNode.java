package util.ast.node;

public class MultiplicativeExpressionNode extends ExpressionNode {

	protected Type type;
	
	public MultiplicativeExpressionNode(Node parent) {
		super(parent);
	}
	
	private int compareTo(MultiplicativeExpressionNode that) {
		return (this.getName().compareTo(that.getName()));
	}
	
	@Override
	public int compareTo(Node that) {
		if (that instanceof MultiplicativeExpressionNode) {
			return this.compareTo((MultiplicativeExpressionNode) that);
		}
		return -1;
	}

}
