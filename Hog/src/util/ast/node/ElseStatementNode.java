package util.ast.node;
/**
 * 
 * An ElseStatementNode represents an else statement and
 * takes a StatementListNode in it's constructor. 
 * 
 * @author ktran
 *
 */
public class ElseStatementNode extends StatementNode {

	public ElseStatementNode(StatementListNode child) {
		this.addChild(child);
	}

	@Override
	public String getName() {
		return "ElseStatementNode";
	}
}
