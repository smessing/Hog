package util.ast.node;

/**
 * A node representing the UnaryExpression nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
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
