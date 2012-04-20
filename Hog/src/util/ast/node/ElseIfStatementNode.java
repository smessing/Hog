package util.ast.node;

public class ElseIfStatementNode extends SelectionStatementNode {

	protected StatementNode ifCondTrue;
	protected StatementNode ifCondFalse;
	
	public ElseIfStatementNode(ExpressionNode condition, StatementListNode checkNext, ElseIfStatementNode ifCondFalse) {
		super(condition);
		this.addChild(ifCondTrue);
		this.addChild(checkNext);
		this.addChild(ifCondFalse);
	}
	
	@Override
	public String getName() {
		return "ElseIfStatementNode";
	}
	
}
