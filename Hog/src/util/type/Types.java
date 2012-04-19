package util.type;

import util.ast.node.ExpressionNode;

public class Types {

	public static enum Type {
		BOOL, TEXT, VOID, INT, REAL, DERIVED, UNKNOWN, NONE
	}

	public static enum Derived {
		LIST, ITER, DICT, MULTISET, SET
	}

	public static boolean isSameType(ExpressionNode one, ExpressionNode two) {
		throw new UnsupportedOperationException("TODO");
	}

	public static Type getHigherType(Type typeOne, Type typeTwo) {

		if (typeOne == Type.REAL || typeTwo == Type.REAL)
			return Type.REAL;
		else if (typeOne == Type.INT || typeTwo == Type.INT)
			return Type.INT;
		else if (typeOne == Type.TEXT || typeTwo == Type.TEXT)
			return Type.TEXT;
		else
			return Type.UNKNOWN;

	}

	public static boolean isInt(Type type) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isReal(Type type) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isBool(Type type) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isText(Type type) {
		// TODO Auto-generated method stub
		return false;
	}

}
