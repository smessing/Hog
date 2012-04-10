package util.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.ast.node.Node;

/**
 * Constructs an Iterator<Node> over a given AST for pre-order and post-order traversal.
 * 
 * @author sam
 * 
 */

class TreeTraversalBuilder {

	static enum traversalOrder {
		PREORDER, POSTORDER;
	}
	
	static Iterator<Node> buildTraversalIterator (Node root, traversalOrder order) {
		
		List<Node> iteratorList = new ArrayList<Node>();
		
		switch (order) {
		case PREORDER:
			iteratorList = buildPreOrderTraversal(root);
			break;
		case POSTORDER:
			iteratorList = buildPostOrderTraversal(root);
		}
		
		return iteratorList.iterator();
		
	}

	private static List<Node> buildPostOrderTraversal(Node root) {
		
		List<Node> subTree = new ArrayList<Node>();
		
		// base case
		if (root.getChildren().isEmpty()) {
			subTree.add(root);
			return subTree;
		}
		
		for (Node child : root.getChildren()) {
			subTree.addAll(buildPostOrderTraversal(child));
		}
		
		subTree.add(root);
		
		return subTree;
		
	}

	private static List<Node> buildPreOrderTraversal(Node root) {
		// TODO Auto-generated method stub
		return null;
	}

}
