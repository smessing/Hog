package util.ast.node;

public class UnaryExpressionNode extends ExpressionNode {

	public UnaryExpressionNode() {
		this(null);
	}
	
	public UnaryExpressionNode(Node parent) {
		super(parent);
	}
	
	@Override
	public String getName() {
		return "UnaryExpressionNode<" + type.toString() + ">";
	}

}
