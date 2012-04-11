package util.ast.node;

/**
 * A node representing the UnaryExpression nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class UnaryExpressionNode extends ExpressionNode {
	
	@Override
	public String getName() {
		return "UnaryExpressionNode<" + this.getTypeName() + ">";
	}

}
