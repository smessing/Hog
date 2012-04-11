package util.ast.node;

/**
 * A node representing the PostfixExpression nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class PostfixExpressionNode extends UnOpNode {
	
	public PostfixExpressionNode(Node child, OpType opType) {
		super(child, opType);
	}

	@Override
	public String getName() {
		return "PostfixExpressionNode<" + this.getTypeName() + ">";
	}
}
