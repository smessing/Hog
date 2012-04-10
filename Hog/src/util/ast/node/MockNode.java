package util.ast.node;

public class MockNode extends Node {

	protected static int mockNodeCount = 0;
	protected int id;
	
	public MockNode() {
		this(null);
		
	}
	
	public MockNode(Node parent) {
		this.parent = parent;
		this.id = mockNodeCount;
		mockNodeCount++;
		
	}
	
	@Override
	public String toString() {
		return Integer.toString(this.id);
	}
	
	
	
}
