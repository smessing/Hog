package util.type;

import util.ast.node.ExceptionTypeNode;
import util.ast.node.ExpressionNode;
import util.ast.node.PrimitiveTypeNode;
import util.ast.node.DerivedTypeNode;
import util.ast.node.DictTypeNode;
import util.ast.node.TypeNode;

/**
 * A convenience class for defining and manipulating internal type
 * representations.
 * 
 * Types are represented by TypeNode classes {DerivedTypeNode, DictTypeNode,
 * ExceptionTypeNode, PrimitiveTypeNode}, in conjunction with the static enums
 * Primitive, Derived and Exception defined by this class.
 * 
 * @author sam
 * 
 */
public class Types {

	public static enum Primitive {
		BOOL, TEXT, VOID, INT, REAL, CHECK_INNER_TYPE
	}

	public static enum Derived {
		LIST, ITER, DICT, MULTISET, SET
	}

	public static enum Exception {
		FILE_NOT_FOUND, FILE_LOAD, ARRAY_OUT_OF_BOUNDS, INCORRECT_ARGUMENT, TYPE_MISMATCH, NULL_REFERENCE, ARITHMETIC
	}

	public static enum Flags {
		RESERVED_WORD, CHECK_INNER_TYPE, BOOL, TEXT, VOID, INT, REAL,
	}

	public static boolean isSameType(TypeNode one, TypeNode two) {

		if (one instanceof PrimitiveTypeNode
				&& two instanceof PrimitiveTypeNode) {

			return isSameType((PrimitiveTypeNode) one, (PrimitiveTypeNode) two);

		} else if (one instanceof DictTypeNode
				&& two instanceof DictTypeNode) {

			return isSameType((DictTypeNode) one, (DictTypeNode) two);

		} else if (one instanceof DerivedTypeNode && two instanceof DerivedTypeNode) {

			return isSameType((DerivedTypeNode) one, (DerivedTypeNode) two);

		} else if (one instanceof ExceptionTypeNode
				&& two instanceof ExceptionTypeNode) {

			return isSameType((ExceptionTypeNode) one, (ExceptionTypeNode) two);

		}

		return false;

	}

	private static boolean isSameType(ExceptionTypeNode one,
			ExceptionTypeNode two) {
		return one.getExceptionType() == two.getExceptionType();
	}

	private static boolean isSameType(DictTypeNode one, DictTypeNode two) {
		if (one.getKeyType() == two.getKeyType()) {
			return isSameType(one.getValueType(), two.getValueType());
		}
		return false;
	}

	private static boolean isSameType(PrimitiveTypeNode one,
			PrimitiveTypeNode two) {
		return one.getType() == two.getType();
	}

	private static boolean isSameType(DerivedTypeNode one, DerivedTypeNode two) {
		if (one.getLocalType() == two.getLocalType()) {
			return isSameType(one.getInnerTypeNode(), two.getInnerTypeNode());
		}
		return false;
	}

	public static TypeNode getHigherType(TypeNode typeOne, TypeNode typeTwo) {

		throw new UnsupportedOperationException("TODO");

	}

	public static boolean isInt(Primitive type) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isReal(Primitive type) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isBool(Primitive type) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isText(Primitive type) {
		// TODO Auto-generated method stub
		return false;
	}

}
