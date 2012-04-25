package util.ast.node;

import back_end.Visitor;

/**
 * 
 * @author sam
 * 
 */
public class SwitchStatementNode extends SelectionStatementNode {

	protected StatementListNode statements;

	public SwitchStatementNode(ExpressionNode expression,
			StatementListNode statements) {
		super(expression);
		this.statements = statements;
		this.addChild(statements);
	}

	public StatementListNode getStatements() {
		return this.statements;
	}

	@Override
	public String getName() {
		return "SwitchStatementNode";
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
