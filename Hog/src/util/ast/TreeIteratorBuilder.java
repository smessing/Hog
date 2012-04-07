package util.ast;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Constructs an Iterator<Node> over a given AST for pre-order, in-order and post-order traversal.
 * !TODO!: define what in-order traversal means, since these are non-binary trees.
 * 
 * @author !TODO!
 * 
 */

public class TreeIteratorBuilder implements Iterable<Node> {

	private Node root;
	private List<Node> iteratorList;

	static enum traversalOrder {
		PREORDER, INORDER, POSTORDER;
	}

	TreeIteratorBuilder(Node root, traversalOrder order) {

	throw new UnsupportedOperationException("!TODO!");

	}

	@Override
	public Iterator<Node> iterator() {
		return this.iteratorList.iterator();
	}

}
