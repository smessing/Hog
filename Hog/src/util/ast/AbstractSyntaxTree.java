package util.ast;

import java.util.Iterator;

/**
 * Abstract class for specifying common behavior for ASTs.
 * 
 * @author !TODO!
 * 
 */
public abstract class AbstractSyntaxTree {

	private Node root;

	public Iterator<Node> preOrderTraversal() {

		return TreeTraversalBuilder.buildTraversalIterator(root,
				TreeTraversalBuilder.traversalOrder.PREORDER);

	}

	public Iterator<Node> postOrderTraversal() {

		return TreeTraversalBuilder.buildTraversalIterator(root,
				TreeTraversalBuilder.traversalOrder.POSTORDER);

	}

	public Iterator<Node> inOrderTraversal() {

		return TreeTraversalBuilder.buildTraversalIterator(root,
				TreeTraversalBuilder.traversalOrder.INORDER);

	}

}
