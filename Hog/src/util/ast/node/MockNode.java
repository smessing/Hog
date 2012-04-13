package util.ast.node;

import java.util.ArrayList;
import java.util.List;

/**
 * MockNode class, a stripped down implementation of the Node class used for testing.
 * @author sam
 *
 */
public class MockNode extends Node {

	protected static int mockNodeCount = 0;
	protected int id;
	
	public MockNode() {
		this(new ArrayList<Node>());
	}
	
	public MockNode(List<Node> children) {
		super(children);
		this.id = mockNodeCount;
		mockNodeCount++;	
	}
	
	/**
	 * Returns the unique id of this node.
	 * @return the unique id of this node.
	 */
	public int getId() {
		return this.id;
	}
	
	@Override
	public String getName() {
		return "MockNode-" + Integer.toString(this.id);
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
	
	
	
}
