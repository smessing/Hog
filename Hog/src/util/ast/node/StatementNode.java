package util.ast.node;

import java.util.ArrayList;
import java.util.List;

import back_end.Visitor;

/**
 * This node is used for the StatementList productions
 * 
 * @author ben
 *
 */
public class StatementNode extends StatementListNode {
	/** Constructor of StatementNode() 
	 *  Takes No Arguments
	 */
	public StatementNode() {
		this(new ArrayList<Node>());
	}
	
	/** Constructor or StatementNode(StatementNode left, StatementNode right)
	 * 
	 * 
	 * @param left left is a StatementNode
	 * @param right right is a StatementNode
	 */
	public StatementNode(StatementNode left, StatementNode right) {
		super(new ArrayList<Node>());
		this.addChild(left);
		this.addChild(right);
	}

	/** Constructor or StatementNode(List<Node> children)
	 * @param children
	 */
	public StatementNode(List<Node> children) {
		super(children);
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
		return id + "-StatementNode";
	}

	@Override
	public int visitorTest(Visitor v) {
		return 0;
	}

}
