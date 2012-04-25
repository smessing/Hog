package util.ast.node;

/**
 * 
 * @author sam
 *
 */
public class SwitchStatementNode extends StatementNode {

	protected ExpressionNode expression;
	protected StatementListNode statements;
	
	public SwitchStatementNode(ExpressionNode expression, StatementListNode statements) {
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
	
	
}
