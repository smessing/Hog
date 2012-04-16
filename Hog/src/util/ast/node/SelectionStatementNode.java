package util.ast.node;

public class SelectionStatementNode extends ExpressionNode {

	protected StatementNode ifCondTrue;
	protected StatementNode ifCondFalse;
	protected ExpressionNode condition;
	
	public SelectionStatementNode(ExpressionNode condition, StatementNode ifCondTrue, StatementNode ifCondFalse) {
		this.ifCondTrue = ifCondTrue;
		this.ifCondFalse = ifCondFalse;
		this.condition = condition;
		this.addChild(condition);
		this.addChild(ifCondTrue);
		this.addChild(ifCondFalse);
	}
	
}
