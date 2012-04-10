package util.ast.node;

public abstract class ExpressionNode extends Node {

	protected static enum Type {
		BOOL, TEXT, VOID, INT, REAL
	}
	
	protected Type type;
	
	protected ExpressionNode(Node parent) {
		super(parent);
	}

}
