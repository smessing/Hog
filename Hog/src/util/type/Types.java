package util.type;

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
 * ExceptionTypeNode PrimitiveTypeNode}, in conjunction with the static enums
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
			return isSamePrimitiveType((PrimitiveTypeNode) one,
					(PrimitiveTypeNode) two);
		} else if (one instanceof DerivedTypeNode
				&& two instanceof DerivedTypeNode) {

		} else if (one instanceof DictTypeNode && two instanceof DictTypeNode) {

		}

		throw new UnsupportedOperationException("TODO");
	}

	public static boolean isSamePrimitiveType(PrimitiveTypeNode one,
			PrimitiveTypeNode two) {
		return one.getType() == two.getType();
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
