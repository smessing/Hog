package util.ast.node;

/**
 * An abstract class inherited by all expression classes, specifying type information.
 * 
 * @author sam
 *
 */
public abstract class ExpressionNode extends Node {

	public static enum Type {
		BOOL, TEXT, VOID, INT, REAL
	}
	
	protected Type type;
	
	public ExpressionNode() {
		this(null);
	}
	
	public ExpressionNode(Node parent) {
		this(parent, null);
	}
	
	public ExpressionNode(Node parent, Type type) {
		super(parent);
		this.type = type;
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
		return "ExpressionNode<" + this.getTypeName() + ">";
	}
	
	public String getTypeName() {
		if (type != null) {
			return type.toString();
		}
		return "unknown";
	}

}
