package util.ast.node;

import back_end.Visitor;

/**
 * 
 * @author sam
 * 
 */
public class SwitchStatementNode extends StatementNode {

	protected ExpressionNode expression;
	protected StatementListNode statements;

	public SwitchStatementNode(ExpressionNode expression,
			StatementListNode statements) {
		this.expression = expression;
		this.statements = statements;
		this.addChild(expression);
		this.addChild(statements);
	}

	public ExpressionNode getExpression() {
		return this.expression;
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
