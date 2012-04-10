package util.ast.node;

/**
 * An abstract class inherited by all expression classes, specifying type information.
 * 
 * @author sam
 *
 */
public abstract class ExpressionNode extends Node {

	protected static enum Type {
		BOOL, TEXT, VOID, INT, REAL
	}
	
	protected Type type;
	
	public ExpressionNode(Node parent) {
		super(parent);
		type = null;
	}
	
	public Type getType() {
		return type;
	}
	
	protected void computeType() {
		throw new UnsupportedOperationException("TODO");
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public boolean isSameType(ExpressionNode that) {
		return this.type == that.getType();
	}
	
	@Override
	public String getName() {
		return "ExpressionNode<" + type.toString() + ">";
	}
	
	@Override
	public int compareTo(Node that) {
		return this.getName().compareTo(that.getName());
	}

}
