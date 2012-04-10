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
	public String getName() {
		return Integer.toString(this.id);
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
