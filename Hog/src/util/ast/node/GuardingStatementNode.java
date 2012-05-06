/**
 * 
 */
package util.ast.node;

import back_end.Visitor;

/**
 * A GuardingStatement represents:
 * 
 * TRY Block:b Finally:f
 * TRY Block:b Catches:c
 * TRY Block:b Catches:c Finally:f
 * 
 * @author Samuel Messing
 *
 */
public class GuardingStatementNode extends StatementNode {

	protected StatementListNode block;
	protected CatchesNode catches;
	protected StatementListNode finallyStatements;
	
	public GuardingStatementNode(StatementListNode block, StatementListNode finallyStatements) {
		this(block, null, finallyStatements);
	}
	
	public GuardingStatementNode(StatementListNode block, CatchesNode catches) {
		this(block, catches, null);
	}
	
	public GuardingStatementNode(StatementListNode block, CatchesNode catches,
			StatementListNode finallyStatements) {
		super();
		this.block = block;
		this.catches = catches;
		this.finallyStatements = finallyStatements;
		this.addChild(block);
		// protected against having nulls in child list:
		if (this.hasCatches()) this.addChild(catches);
		if (this.hasFinally()) this.addChild(finallyStatements);
		
	}
	
	public StatementListNode getBlock() {
		return block;
	}
	
	public boolean hasCatches() {
		return (catches != null);
	}
	
	public CatchesNode getCatches() {
		return catches;
	}
	
	public boolean hasFinally() {
		return (finallyStatements != null);
	}
	
	public StatementListNode getFinally() {
		return finallyStatements;
	}
	
	@Override
	public String getName() {
		return id + "-GuardingStatemenetNode newscope: " + isNewScope();
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
