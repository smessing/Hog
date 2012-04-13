package util.ast.node;

/**
 * A node representing the MultiplicativeExpression nonterminal in a parse tree.
 * 
 * @author ben
 * 
 */
public class AdditiveExpressionNode extends BiOpNode {

	public AdditiveExpressionNode(OpType type, ExpressionNode left, ExpressionNode right) {
		super(type, left, right);
	}

	@Override
	public String getName() {
		return "AdditiveExpressionNode<" + this.getTypeName() + ","
				+ this.opType.toString() + ">";
	}

}
