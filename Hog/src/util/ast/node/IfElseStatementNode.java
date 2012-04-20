package util.ast.node;

public class IfElseStatementNode extends SelectionStatementNode {
	
	protected StatementNode ifCondTrue;
	protected StatementNode ifCondFalse;
	
	IfElseStatementNode(ExpressionNode condition, StatementNode ifCondTrue, StatementNode ifCondFalse) {
		super(condition);
		this.addChild(ifCondTrue);
		this.addChild(ifCondFalse);
	}
	
	public StatementNode getIfCondTrue() {
		return ifCondTrue;
	}
	
	public StatementNode getIfCondFalse() {
		return ifCondFalse;
	}

}
