package util.ast.node;

/**
 * A node representing the PrimaryExpression nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class PrimaryExpressionNode extends ExpressionNode {

	@Override
	public String getName() {
		return "PrimaryExpressionNode<" + this.getTypeName() + ">";
	}
	
}
