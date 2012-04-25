package util.ast.node;

import java.util.ArrayList;

import back_end.Visitor;

/**
 * 
 * @author sam
 *
 */
public class CatchesNode extends StatementListNode {
	
	protected IdNode header;
	protected StatementListNode block;
	protected CatchesNode next;
	
	public CatchesNode(IdNode header, StatementListNode block) {
		this(header, block, null);
	}
	
	public CatchesNode(IdNode header, StatementListNode block, CatchesNode next) {
		super(new ArrayList<Node>());
		this.header = header;
		this.block = block;
		this.next = next;
		this.addChild(header);
		this.addChild(block);
		// protect against having nulls in child list:
		if (this.hasNext()) this.addChild(next);
	}
	
	public IdNode getHeader() {
		return header;
	}
	
	public StatementListNode getBlock() {
		return block;
	}
	
	public boolean hasNext() {
		return (next == null);
	}
	
	public CatchesNode getNext() {
		return next;
	}
	
	@Override
	public String getName() {
		return "CatchesNode";
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
