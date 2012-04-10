package util.ast.node;

public class ConstantNode<E> extends ExpressionNode {

	private E value;
	
	public ConstantNode() {
		this(null);
	}
	
	public ConstantNode(Node parent) {
		this(parent, null);
	}
	
	public ConstantNode(Node parent, Type type) {
		this(parent, type, null);
	}
	
	public ConstantNode(Node parent, Type type, E value) {
		super(parent, type);
		this.value = value;
	}
	
	public E getValue() {
		return this.value;
	}
	
	@Override
	public String getName() {
		return "ConstantNode<" + this.getTypeName() + ">";
	}
	
	
	
}
