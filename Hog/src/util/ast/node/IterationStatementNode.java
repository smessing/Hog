package util.ast.node;

import java.util.ArrayList;

/**
 * IterationStatementNode is a node for 'while', 'for', and 'foreach' loops. 
 * Which of these constructs can be determined by the num of children the node has
 *   2 children: 'while'
 *   3 children: 'for'
 *   4 children: 'foreach'
 * 
 * @author ben
 *
 */
public class IterationStatementNode extends StatementNode {
	
	/**
	 * Constructor for 'while' loop
	 * @param E
	 * @param S
	 */
	public IterationStatementNode(ExpressionNode e, StatementListNode s) {
		super(new ArrayList<Node>());
		this.addChild(e);
		this.addChild(s);
		IterationStatementNode.LOGGER.info("Constructing WHILE loop IterationStatementNode");
	}
	
	/**
	 * Constructor for 'for' loop
	 * @param E1
	 * @param E2
	 * @param E3
	 * @param S
	 */
	public IterationStatementNode(ExpressionNode e1, ExpressionNode e2, ExpressionNode e3, StatementListNode s ) {
		super(new ArrayList<Node>());
		this.addChild(e1);
		this.addChild(e2);
		this.addChild(e3);
		this.addChild(s);
		IterationStatementNode.LOGGER.info("Constructing FOR loop IterationStatementNode");
	}
	
	/**
	 * Constructor for 'foreach statement'
	 * @param E1
	 * @param E2
	 * @param S
	 */
	public IterationStatementNode(ExpressionNode e1, ExpressionNode e2, StatementListNode s) {
		super(new ArrayList<Node>());
		this.addChild(e1);
		this.addChild(e2);
		this.addChild(s);
		IterationStatementNode.LOGGER.info("Constructing FOREACH loop IterationStatementNode");
	}
	
}
