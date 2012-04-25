package util.ast.node;

public class SelectionStatementNode extends StatementNode {

	
	ExpressionNode condition;
	
	SelectionStatementNode(ExpressionNode condition) {
		this.condition = condition;
		this.addChild(condition);
	}
	
	public ExpressionNode getCondition() {
		return condition;
	}
	
}
