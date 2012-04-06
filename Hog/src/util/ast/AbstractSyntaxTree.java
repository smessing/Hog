package util.ast;

import java.util.Iterator;

/**
 * Abstract class for specifying common behavior for ASTs.
 * @author !TODO!
 *
 */
public abstract class AbstractSyntaxTree {

	private Node root;
	
	public Iterator<Node> preOrderTraversal() {
		throw new UnsupportedOperationException("!TODO!");
	}
	
	public Iterator<Node> postOrderTraversal() {
		throw new UnsupportedOperationException("!TODO!");
	}
	
	public Iterator<Node> inOrderTraversal() {
		throw new UnsupportedOperationException("!TODO!");
	}
	
}
