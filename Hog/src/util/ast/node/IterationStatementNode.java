package util.ast.node;

import java.util.ArrayList;

import back_end.Visitor;

/**
 * IterationStatementNode is a node for 'while', 'for', and 'foreach' loops.
 * Which of these constructs can be determined by the num of children the node
 * has 2 children: 'while' 3 children: 'for' 4 children: 'foreach'
 * 
 * @author Benjamin Rapaport
 * 
 */
public class IterationStatementNode extends StatementNode {

	public static enum IterationType {
		WHILE, FOR, FOREACH;
	}

	protected IterationType iterationType;

	protected StatementListNode initial;
	protected ExpressionNode check;
	protected StatementListNode increment;
	protected StatementListNode block;
	protected ExpressionNode part;
	protected ExpressionNode whole;

	/**
	 * Constructor for 'while' loop
	 * 
	 * @param E
	 * @param S
	 */
	public IterationStatementNode(ExpressionNode e, StatementListNode s) {
		super(new ArrayList<Node>());
		this.addChild(e);
		this.check = e;
		this.addChild(s);
		this.block = s;
		this.iterationType = IterationType.WHILE;
		IterationStatementNode.LOGGER
				.fine("Constructing WHILE loop IterationStatementNode");
	}

	/**
	 * Constructor for 'for' loop
	 * 
	 * @param E1
	 * @param E2
	 * @param E3
	 * @param S
	 */
	public IterationStatementNode(StatementListNode initial,
			ExpressionNode check, StatementListNode increment,
			StatementListNode block) {
		super(new ArrayList<Node>());
		this.addChild(initial);
		this.initial = initial;
		this.addChild(check);
		this.check = check;
		this.addChild(increment);
		this.increment = increment;
		this.addChild(block);
		this.block = block;
		this.iterationType = IterationType.FOR;
		IterationStatementNode.LOGGER
				.fine("Constructing FOR loop IterationStatementNode");
	}

	/**
	 * Constructor for 'foreach statement'
	 * 
	 * @param E1
	 * @param E2
	 * @param S
	 */
	public IterationStatementNode(ExpressionNode part, ExpressionNode whole,
			StatementListNode block) {
		super(new ArrayList<Node>());
		this.addChild(part);
		this.part = part;
		this.addChild(whole);
		this.whole = whole;
		this.addChild(block);
		this.block = block;
		this.iterationType = IterationType.FOREACH;
		IterationStatementNode.LOGGER
				.fine("Constructing FOREACH loop IterationStatementNode");
	}

	public IterationType getIterationType() {
		return iterationType;
	}

	public StatementListNode getInitial() {
		if (this.getIterationType() != IterationType.FOR) {
			throw new UnsupportedOperationException(
					"Tried to access initial statement for a non-for iteration node!");
		}
		return initial;
	}

	public ExpressionNode getCheck() {
		return check;
	}

	public StatementListNode getIncrement() {
		if (this.getIterationType() != IterationType.FOR) {
			throw new UnsupportedOperationException(
					"Tried to access increment statement for a non-for iteration node!");
		}
		return increment;
	}

	public StatementListNode getBlock() {
		return block;
	}

	public ExpressionNode getPart() {
		if (this.getIterationType() != IterationType.FOREACH) {
			throw new UnsupportedOperationException(
					"Tried to access a part for a non-for-each iteration node!");
		}
		return part;
	}

	public ExpressionNode getWhole() {
		if (this.getIterationType() != IterationType.FOREACH) {
			throw new UnsupportedOperationException(
					"Tried to access a part for a non-for-each iteration node.");
		}
		return whole;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public String getName() {
		return id + "-IterationStatement: " + iterationType.toString()
				+ " loop newscope: " + isNewScope();
	}

	@Override
	public int visitorTest(Visitor v) {
		return 0;
	}

}
