package util.ast.node;

import back_end.Visitor;

/**
 * @author paul
 *
 */

public class SelectionStatementNode extends StatementNode {

	ExpressionNode condition;
	
	SelectionStatementNode(ExpressionNode condition) {
		this.condition = condition;
		this.addChild(condition);
	}
	
	public ExpressionNode getCondition() {
		return condition;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public String getName() {
		return "SelectionStatementNode";
	}
	
}
