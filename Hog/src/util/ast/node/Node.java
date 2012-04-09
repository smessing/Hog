package util.ast.node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A node within an AST.
 * 
 * @author !TODO!
 * 
 */
public abstract class Node {

	private Node parent;
	// Note: children are ordered left-to-right (first child is leftmost child).
	private List<Node> children;

	public Node() {
		this(null);
	}

	public Node(Node parent) {
		this.parent = parent;
		this.children = new ArrayList<Node>();
	}

	public List<Node> getChildren() {
		return this.children;
	}
	
	public Node getParent() {
		return this.parent;
	}
}
