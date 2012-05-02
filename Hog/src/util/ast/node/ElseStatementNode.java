package util.ast.node;
/**
 * 
 * An ElseStatementNode represents an else statement and
 * takes a StatementListNode in it's constructor. 
 * 
 * @author sam
 *
 */
public class ElseStatementNode extends StatementNode {

	protected StatementListNode block;
	
	public ElseStatementNode(StatementListNode block) {
		this.addChild(block);
		this.block = block;
	}
	
	public StatementListNode getBlock() {
		return block;
	}

	@Override
	public String getName() {
		return "ElseStatementNode";
	}
}
