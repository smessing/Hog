package util.ast.node;

import util.type.Types;

public class SelectionStatementNode extends ExpressionNode {

	protected StatementNode ifCondTrue;
	protected StatementNode ifCondFalse;
	protected ExpressionNode condition;
	
	public SelectionStatementNode(ExpressionNode condition, StatementNode ifCondTrue, StatementNode ifCondFalse) {
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
	
}
