package util.ast.node;

import back_end.Visitor;

public class IfElseStatementNode extends SelectionStatementNode {

	protected StatementListNode ifCondTrue;
	protected ElseIfStatementNode checkNext;
	protected ElseStatementNode ifCondFalse;

	public IfElseStatementNode(ExpressionNode condition,
			StatementListNode ifCondTrue, ElseIfStatementNode checkNext,
			ElseStatementNode ifCondFalse) {
		super(condition);
		this.addChild(ifCondTrue);
		this.ifCondTrue = ifCondTrue;
		this.addChild(checkNext);
		this.checkNext = checkNext;
		this.addChild(ifCondFalse);
		this.ifCondFalse = ifCondFalse;
	}

	public StatementListNode getIfCondTrue() {
		return ifCondTrue;
	}

	public ElseStatementNode getIfCondFalse() {
		return ifCondFalse;
	}

	public ElseIfStatementNode getCheckNext() {
		return checkNext;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public String getName() {
		return id + "-IfElseStatementNode";
	}

}
