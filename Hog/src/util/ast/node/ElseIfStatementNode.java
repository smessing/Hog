package util.ast.node;

/**
 * An ElseIfStatementNode represents an else-if statement
 * and contains the statement if the condition is true, and
 * the statement if the condition is true.
 * 
 * @author Samuel Messing
 *
 */

import back_end.Visitor;

public class ElseIfStatementNode extends SelectionStatementNode {

	protected StatementListNode ifCondFalse;
	protected StatementListNode ifCondTrue;

	public ElseIfStatementNode(ExpressionNode condition,
			StatementListNode ifCondTrue, ElseIfStatementNode ifCondFalse) {
		super(condition);
		this.addChild(ifCondTrue);
		this.ifCondTrue = ifCondTrue;
		this.addChild(ifCondFalse);
		this.ifCondFalse = ifCondFalse;

	}
	
	public StatementListNode getIfCondTrue() {
		return ifCondTrue;
	}

	public StatementListNode getIfCondFalse() {
		return ifCondFalse;
	}

	@Override
	public String getName() {
		return id + "-ElseIfStatementNode newscope: " + isNewScope();
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
