package util.ast.node;

import back_end.Visitor;

/**
 * 
 * @author sam
 * 
 */
public class SwitchStatementNode extends SelectionStatementNode {

	/** Description of statements Field
	 *  Field that holds the statements of the node.  
	 */
	protected StatementListNode statements;

	/** Constructor of SwitchStatementNode 
	 * SwitchStatementNode(ExpressionNode expression, StatementListNode statements)
	 * 
	 * @param expression
	 * @param statements
	 */
	public SwitchStatementNode(ExpressionNode expression,
			StatementListNode statements) {
		super(expression);
		this.statements = statements;
		this.addChild(statements);
	}

	/**
	 * Method to return statements field getStatements()
	 * 
	 * @return Returns statements field of Node
	 */
	public StatementListNode getStatements() {
		return this.statements;
	}

	/**
	 * Method to return the name of Node
	 * @return Returns "SwitchStatementNode" string
	 */
	@Override
	public String getName() {
		return id + "-SwitchStatementNode newscope: " + isNewScope();
	}
	/**
	 * Method to accept a visitor accept(Visitor v)
	 * @param v param v is a Visitor 
	 */
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
