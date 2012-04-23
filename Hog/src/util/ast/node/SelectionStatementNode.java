package util.ast.node;

import util.type.Types;

public class SelectionStatementNode extends StatementNode {

	protected StatementNode ifCondTrue;
	protected StatementNode ifCondFalse;
	protected ExpressionNode condition;
	
	public SelectionStatementNode(ExpressionNode condition, StatementNode ifCondTrue, StatementNode ifCondFalse) {
		super();
		this.ifCondTrue = ifCondTrue;
		this.ifCondFalse = ifCondFalse;
		if (condition == null) {
			// if condition was null, we make it trivially true:
			condition = new ConstantNode(Types.Type.BOOL, "true");
		}
		this.condition = condition;
		this.addChild(condition);
		this.addChild(ifCondTrue);
		this.addChild(ifCondFalse);
	}
	
	public ExpressionNode getCondition() {
		return condition;
	}
	
}
