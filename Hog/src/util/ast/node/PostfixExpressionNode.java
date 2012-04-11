package util.ast.node;

/**
 * A node representing the PostfixExpression nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class PostfixExpressionNode extends ExpressionNode {
	
	@Override
	public String getName() {
		return "PostfixExpressionNode<" + this.getTypeName() + ">";
	}
}
