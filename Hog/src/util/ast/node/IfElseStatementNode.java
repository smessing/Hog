package util.ast.node;

import back_end.Visitor;

public class IfElseStatementNode extends SelectionStatementNode {

	protected StatementNode ifCondTrue;
	protected StatementNode checkNext;
	protected StatementNode ifCondFalse;

	public IfElseStatementNode(ExpressionNode condition,
			StatementListNode ifCondTrue, ElseIfStatementNode checkNext,
			ElseStatementNode ifCondFalse) {
		super(condition);
		this.addChild(ifCondTrue);
		this.addChild(checkNext);
		this.addChild(ifCondFalse);
	}

	public StatementNode getIfCondTrue() {
		return ifCondTrue;
	}

	public StatementNode getIfCondFalse() {
		return ifCondFalse;
	}

	public StatementNode getCheckNext() {
		return checkNext;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public String getName() {
		return "IfElseStatementNode";
	}

}
