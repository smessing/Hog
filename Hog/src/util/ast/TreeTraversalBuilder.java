package util.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.ast.node.Node;

/**
 * Constructs an Iterator<{@link Node}> over a given AST for pre-order and post-order traversal.
 * 
 * @author Samuel Messing
 * 
 */
class TreeTraversalBuilder {

	/**
	 * Flags for setting order of iteration through the tree.
	 *
	 */
	static enum traversalOrder {
		PREORDER, POSTORDER;
	}
	
	/**
	 * Build an iterator for a particular traversal order over a tree.
	 * 
	 * @param root the root of the tree to walk.
	 * @param order the order to walk the tree.
	 * @return the iterator over the nodes of the tree.
	 */
	static Iterator<Node> buildTraversalIterator (Node root, traversalOrder order) {
		
		List<Node> iteratorList = new ArrayList<Node>();
		
		iteratorList = buildTraversal(root, order);
		
		return iteratorList.iterator();
		
	}
	
	/**
	 * Private method for actually constructing the traversal-ordered collection.
	 * 
	 * @param root the root node of the AST to walk.
	 * @param order the order in which to walk the tree.
	 * @return a collection of the nodes of the tree in traversal order.
	 */
	private static List<Node> buildTraversal(Node root, traversalOrder order) {
		
		List<Node> subTree = new ArrayList<Node>();
		
		// base case
		if (root.getChildren().isEmpty()) {
			subTree.add(root);
			return subTree;
		}
		
		if (order == traversalOrder.PREORDER) {
			subTree.add(root);
		}
		
		for (Node child : root.getChildren()) {
			subTree.addAll(buildTraversal(child, order));
		}
		
		if (order == traversalOrder.POSTORDER) {
			subTree.add(root);
		}
		
		return subTree;
		
	}

}
