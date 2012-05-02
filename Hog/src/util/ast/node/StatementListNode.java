package util.ast.node;

import java.util.List;

import back_end.Visitor;

/**
 * Represents the production for StatementList
 * 
 * @author ben
 *
 */
public class StatementListNode extends Node {
	
	/** Constructor of StatementListNode(List<Node> children)
	 * 
	 * @param children
	 */
	public StatementListNode(List<Node> children) {
		this.children = children;
	}
	/** Constructor of StatementListNode(StatementListNode list, StatementNode statement)
	 * 
	 * @param list
	 * @param statement
	 */
	public StatementListNode(StatementListNode list, StatementNode statement) {
		super();
		this.addChild(list);
		this.addChild(statement);
	}

	public StatementListNode(BiOpNode biOpNode) {
		super();
		this.addChild(biOpNode);
	}
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

	/** Method to Return the name getName()
	 * @return Returns a string with the node's name
	 */
	@Override
	public String getName() {
		return id + "-StatementListNode";
	}

}
