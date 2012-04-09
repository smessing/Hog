package util.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.ast.node.Node;

/**
 * Constructs an Iterator<Node> over a given AST for pre-order, in-order and post-order traversal.
 * !TODO!: define what in-order traversal means, since these are non-binary trees.
 * 
 * @author !TODO!
 * 
 */

class TreeTraversalBuilder {

	static enum traversalOrder {
		PREORDER, INORDER, POSTORDER;
	}
	
	static Iterator<Node> buildTraversalIterator (Node root, traversalOrder order) {
		
		List<Node> iteratorList = new ArrayList<Node>();
		
		switch (order) {
		case PREORDER:
			iteratorList = buildPreOrderTraversal(root);
			break;
		case INORDER:
			iteratorList = buildInOrderTraversal(root);
			break;
		case POSTORDER:
			iteratorList = buildPostOrderTraversal(root);
		}
		
		return iteratorList.iterator();
		
	}

	private static List<Node> buildPostOrderTraversal(Node root) {
		// TODO Auto-generated method stub
		return null;
	}

	private static List<Node> buildInOrderTraversal(Node root) {
		// TODO Auto-generated method stub
		return null;
	}

	private static List<Node> buildPreOrderTraversal(Node root) {
		// TODO Auto-generated method stub
		return null;
	}

}
