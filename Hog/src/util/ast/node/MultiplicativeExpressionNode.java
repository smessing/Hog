package util.ast.node;

/**
 * A node representing the MultiplicativeExpression nonterminal in a parse tree.
 * 
 * @author sam
 * 
 */
public class MultiplicativeExpressionNode extends BiOpNode {

	public MultiplicativeExpressionNode(OpType type, ExpressionNode left, ExpressionNode right) {
		super(type, left, right);
	}

	@Override
	public String getName() {
		return "MultiplicativeExpressionNode<" + this.getTypeName() + ","
				+ this.opType.toString() + ">";
	}

}
