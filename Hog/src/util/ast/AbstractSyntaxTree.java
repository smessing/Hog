package util.ast;

import java.util.Iterator;

import util.ast.node.Node;

/**
 * Abstract class for specifying common behavior for ASTs.
 * 
 * @author sam
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

}
