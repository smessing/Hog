package util.ast.node;

import java.util.ArrayList;
import java.util.List;

import back_end.Visitor;

/**
 * MockNode class, a stripped down implementation of the Node class used for
 * testing.
 * 
 * @author sam
 * 
 */
public class MockNode extends Node {

	protected static int mockNodeCount = 0;
	protected int id;

	public MockNode() {
		this(new ArrayList<Node>());
	}

	/**
	 * 
	 * @param children the children of this node
	 */
	public MockNode(List<Node> children) {
		super(children);
		this.id = mockNodeCount;
		mockNodeCount++;
	}

	/**
	 * Returns the unique id of this node.
	 * 
	 * @return the unique id of this node.
	 */
	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MockNode-" + Integer.toString(this.id);
	}

	@Override
	public String getName(){
		return "MockNode";
	}
	
	protected int compareTo(MockNode that) {
		return this.id - that.getId();
	}

	@Override
	public int compareTo(Node that) {
		if (that instanceof MockNode) {
			return compareTo((MockNode) that);
		}
		return -1;
	}

	@Override
	public void accept(Visitor v) {
		// do nothing
	}

	@Override
	public int visitorTest(Visitor v) {
		v.visit(this);
		System.out.println("here in mock node");
		return 10;
	}

}
