package util.ast.node;

/**
 * A node representing the UnaryExpression nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class UnaryExpressionNode extends UnOpNode {
	
	public UnaryExpressionNode(Node child, OpType opType) {
		super(child, opType);
	}

	@Override
	public String getName() {
		return "UnaryExpressionNode<" + this.getTypeName() + ">";
	}

}
