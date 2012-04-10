package util.ast.node;

public class CastExpressionNode extends ExpressionNode {

	public CastExpressionNode() {
		this(null);
	}
	
	public CastExpressionNode(Node parent) {
		super(parent);
	}

	@Override
	public String getName() {
		return "CastExpressionNode<" + type.toString() + ">";
	}

}
