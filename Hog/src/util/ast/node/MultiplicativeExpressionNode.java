package util.ast.node;

/**
 * A node representing the MultiplicativeExpression nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class MultiplicativeExpressionNode extends ExpressionNode {
	
	public MultiplicativeExpressionNode() {
		this(null);
	}
	
	public MultiplicativeExpressionNode(Node parent) {
		super(parent);
	}

	@Override
	public String getName() {
		return "MultiplicativeExpressionNode<" + type.toString() + ">";
	}
	

}
