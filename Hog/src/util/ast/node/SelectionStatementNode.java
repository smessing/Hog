package util.ast.node;

import back_end.Visitor;

/**
 * @author paul
 *
 */

public class SelectionStatementNode extends StatementNode {

	/** condition type field 
	 * 
	 */
	ExpressionNode condition;
	
	/** Constructor SelectionStatementNode(ExpressionNode condition)
	 * @param condition
	 */
	public SelectionStatementNode(ExpressionNode condition) {
		this.condition = condition;
		this.addChild(condition);
	}
	/** Getter Method to return condition field getCondition()
	 * 
	 * @return Returns the condition field of node.
	 */
	public ExpressionNode getCondition() {
		return condition;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	/** Method to Return the name getName()
	 * @return Returns a string with the node's name
	 */
	@Override
	public String getName() {
		return "SelectionStatementNode";
	}
	
}
