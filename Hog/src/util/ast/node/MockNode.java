package util.ast.node;

/**
 * MockNode class, a stripped down implementation of the Node class used for testing.
 * @author sam
 *
 */
public class MockNode extends Node {

	protected static int mockNodeCount = 0;
	protected int id;
	
	public MockNode() {
		this(null);
	}
	
	public MockNode(Node parent) {
		super(parent);
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
	public String toString() {
		return Integer.toString(this.id);
	}
	
	public int compareTo(MockNode that) {
		if (this.id == that.getId()) {
			return 0;
		} else {
			return this.id - that.getId();
		}
	}

	@Override
	public int compareTo(Node that) {
		if (that instanceof MockNode) {
			return compareTo((MockNode) that);
		}
		return -1;
	}
	
	
	
}
