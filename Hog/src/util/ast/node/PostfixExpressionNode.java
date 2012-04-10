package util.ast.node;

/**
 * A node representing the PostfixExpression nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
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
