package util.ast.node;

public class PostfixExpressionNode extends ExpressionNode {

	
	
	public PostfixExpressionNode() {
		this(null);
	}
	
	public PostfixExpressionNode(Node parent) {
		super(parent);
	}
	
	@Override
	public String getName() {
		return "PostfixExpressionNode<" + type.toString() + ">";
	}
}
