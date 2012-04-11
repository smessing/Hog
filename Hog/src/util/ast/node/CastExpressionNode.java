package util.ast.node;

/**
 * A node representing the CastExpression nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class CastExpressionNode extends ExpressionNode {

	@Override
	public String getName() {
		return "CastExpressionNode<" + this.getTypeName() + ">";
	}

}
