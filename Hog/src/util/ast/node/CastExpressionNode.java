package util.ast.node;

public class CastExpressionNode extends ExpressionNode {

	public CastExpressionNode() {
		this(null);
	}
	
	public CastExpressionNode(Node parent) {
		super(parent);
	}

	private int compareTo(CastExpressionNode that) {
		return this.getName().compareTo(that.getName());
	}
	
	@Override
	public int compareTo(Node that) {
		if (that instanceof CastExpressionNode) {
			return this.compareTo((CastExpressionNode) that);
		}
		return -1;
	}
	
	@Override
	public String getName() {
		return "CastExpressionNode<" + type.toString() + ">";
	}

}
