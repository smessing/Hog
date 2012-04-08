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

		TreeTraversalBuilder iterator = new TreeTraversalBuilder(this.root,
				TreeTraversalBuilder.traversalOrder.PREORDER);
		return iterator.iterator();

	}

	public Iterator<Node> postOrderTraversal() {

		TreeTraversalBuilder iterator = new TreeTraversalBuilder(this.root,
				TreeTraversalBuilder.traversalOrder.POSTORDER);
		return iterator.iterator();

	}

	public Iterator<Node> inOrderTraversal() {

		TreeTraversalBuilder iterator = new TreeTraversalBuilder(this.root,
				TreeTraversalBuilder.traversalOrder.INORDER);
		return iterator.iterator();

	}

}
