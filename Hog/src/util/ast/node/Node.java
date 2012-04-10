package util.ast.node;

import java.util.ArrayList;
import java.util.List;

/**
 * A node within an AST.
 * 
 * @author sam
 * 
 */
public abstract class Node {

	protected Node parent;
	// Note: children are ordered left-to-right (first child is leftmost child).
	protected List<Node> children;

	public Node() {
		this(null);
	}

	public Node(Node parent) {
		this.parent = parent;
		this.children = new ArrayList<Node>();
	}

	public List<Node> getChildren() {
		return children;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public void addChild(Node child) {
		children.add(child);
	}
	
	
}
