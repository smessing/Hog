package util.ast.node;

/**
 * A node representing the MultiplicativeExpression nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class MultiplicativeExpressionNode extends ExpressionNode {

	@Override
	public String getName() {
		return "MultiplicativeExpressionNode<" + this.getTypeName() + ">";
	}
	

}
