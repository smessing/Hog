package util.ast.node;

public class ConstantNode<E> extends ExpressionNode {

	private E value;
	
	public ConstantNode() {
		this(null);
	}
	
	public ConstantNode(Node parent) {
		this(parent, null);
	}
	
	public ConstantNode(Node parent, E value) {
		super(parent);
		this.value = value;
	}
	
	public E getValue() {
		return this.value;
	}
	
	
	
	
}
