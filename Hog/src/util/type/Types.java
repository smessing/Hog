package util.type;

import util.ast.node.ExpressionNode;

public class Types {

	public static enum Type {
		BOOL, TEXT, VOID, INT, REAL, DERIVED
	}
	
	public static enum Derived {
		LIST, ITER
	}
	
	public static boolean isSameType(ExpressionNode one, ExpressionNode two) {
		throw new UnsupportedOperationException("TODO");
	}
	
}
