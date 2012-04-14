package util.ast.node;

import back_end.Visitor;

/**
 * A node representing a LogicalExpression nonterminal
 * 
 * @author ben
 * 
 */
public class LogicalExpressionNode extends BiOpNode {

	public LogicalExpressionNode(ExpressionNode left, ExpressionNode right) {
		super(BiOpNode.OpType.OR, left, right);
	}

	@Override
	public String getName() {
		return "LogicalExpressionNode<" + this.getTypeName() + ","
				+ this.opType.toString() + ">";
	}
	
	@Override
	public void visit(Visitor v) {
		// TODO Auto-generated method stub
	}

}
