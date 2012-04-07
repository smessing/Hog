package util.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A node within an AST.
 * 
 * @author !TODO!
 * 
 */
public class Node {

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
}
