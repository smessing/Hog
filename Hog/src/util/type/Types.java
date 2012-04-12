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

	public static Type getHigherType(Type typeOne, Type typeTwo) {

		if (typeOne == Type.REAL || typeTwo == Type.REAL)
			return Type.REAL;
		else if (typeOne == Type.INT || typeTwo == Type.INT)
			return Type.INT;
		else
			return Type.TEXT;

	}

}
