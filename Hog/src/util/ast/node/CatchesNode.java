package util.ast.node;

import java.util.ArrayList;

import back_end.Visitor;

/**
 * A CatchesNode represents a catch statement with an exception and exception
 * type. E.g.
 * 
 * try {
 *		...
 * } catch (NumberFormateException nfe) {
 * 		catchStatements;
 * }
 * 
 * @author sam
 * 
 */
public class CatchesNode extends StatementListNode {

	protected IdNode header;
	protected StatementListNode block;
	protected CatchesNode next;

	/**
	 * Create a new CatchesNode.
	 * 
	 * @param header
	 *            - the IdNode that represents the exception being caught. (e.g.
	 *            catch (NumberFormatException nfe)).
	 * @param block
	 *            - the StatementListNode that represents the statements to
	 *            execute upon catching the exception represented by IdNode.
	 */
	public CatchesNode(IdNode header, StatementListNode block) {
		this(header, block, null);
	}

	/**
	 * Create a new CatchesNode. 
	 * @param header
	 * @param block
	 * @param next
	 */
	public CatchesNode(IdNode header, StatementListNode block, CatchesNode next) {
		super(new ArrayList<Node>());
		this.header = header;
		this.block = block;
		this.next = next;
		this.addChild(header);
		this.addChild(block);
		// protect against having nulls in child list:
		if (this.hasNext())
			this.addChild(next);
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
