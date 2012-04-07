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
		
		TreeIteratorBuilder iterator = new TreeIteratorBuilder(this.root, TreeIteratorBuilder.traversalOrder.PREORDER);
		return iterator.iterator();
		
	}
	
	public Iterator<Node> postOrderTraversal() {
		
		TreeIteratorBuilder iterator = new TreeIteratorBuilder(this.root, TreeIteratorBuilder.traversalOrder.POSTORDER);
		return iterator.iterator();
		
	}
	
	public Iterator<Node> inOrderTraversal() {
		
		TreeIteratorBuilder iterator = new TreeIteratorBuilder(this.root, TreeIteratorBuilder.traversalOrder.INORDER);
		return iterator.iterator();
		
	}
	
}
