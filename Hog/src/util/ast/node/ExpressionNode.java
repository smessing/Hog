package util.ast.node;

public abstract class ExpressionNode extends Node {

	protected static enum Type {
		BOOL, TEXT, VOID, INT, REAL
	}
	
	protected Type type;
	
	protected ExpressionNode(Node parent) {
		super(parent);
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public boolean isSameType(ExpressionNode that) {
		return this.type == that.getType();
	}

}