package util.ast.node;

import back_end.Visitor;

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
	
	@Override
	public void visit(Visitor v) {
		v.visitMultiplicativeExpressionNode();
	}
	

}
