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
	public IterationStatementNode(ExpressionNode E, StatementNode S) {
		super(new ArrayList<Node>());
		this.addChild(E);
		this.addChild(S);
	}
	
	/**
	 * Constructor for 'for' loop
	 * @param E1
	 * @param E2
	 * @param E3
	 * @param S
	 */
	public IterationStatementNode(ExpressionNode E1, ExpressionNode E2, ExpressionNode E3, StatementNode S ) {
		super(new ArrayList<Node>());
		this.addChild(E1);
		this.addChild(E2);
		this.addChild(E3);
		this.addChild(S);
	}
	
	/**
	 * Constructor for 'foreach statement'
	 * @param E1
	 * @param E2
	 * @param S
	 */
	public IterationStatementNode(ExpressionNode E1, ExpressionNode E2, StatementNode S) {
		super(new ArrayList<Node>());
		this.addChild(E1);
		this.addChild(E2);
		this.addChild(S);
	}
	
}
