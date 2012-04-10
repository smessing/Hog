package util.ast.node;

/**
 * A node representing the CastExpression nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class CastExpressionNode extends ExpressionNode {

	public CastExpressionNode() {
		this(null);
	}
	
	public CastExpressionNode(Node parent) {
		super(parent);
	}

	@Override
	public String getName() {
		return "CastExpressionNode<" + this.getTypeName() + ">";
	}

}
