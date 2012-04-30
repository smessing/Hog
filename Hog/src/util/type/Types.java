package util.type;

import util.ast.node.BiOpNode;
import util.ast.node.ExceptionTypeNode;
import util.ast.node.PrimitiveTypeNode;
import util.ast.node.DerivedTypeNode;
import util.ast.node.DictTypeNode;
import util.ast.node.TypeNode;
import util.ast.node.UnOpNode;

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

		if (one.isPrimitive() && two.isPrimitive()) {
			return isSameType((PrimitiveTypeNode) one, (PrimitiveTypeNode) two);
		} else if (one.isDict() && two.isDict()) {
			return isSameType((DictTypeNode) one, (DictTypeNode) two);
		} else if (one.isDerived() && two.isDerived()) {
			return isSameType((DerivedTypeNode) one, (DerivedTypeNode) two);
		} else if (one.isException() && two.isException()) {
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

	public static boolean isCompatible(BiOpNode.OpType op, TypeNode left,
			TypeNode right) {

		switch (op) {
		case ASSIGN:
		case NOT_EQLS:
		case DBL_EQLS:
			return isSameType(left, right);
		case PLUS:
			if (left.isText() && right.isText())
				return true;
		case MINUS:
		case DIVIDE:
		case TIMES:
		case MOD:
			return left.isNumeric() && right.isNumeric();
		case OR:
		case AND:
			return left.isBoolean() && right.isBoolean();
		case LESS:
		case GRTR:
		case LESS_EQL:
		case GRTR_EQL:
			return left.isPrimitive() && right.isPrimitive()
					&& isSameType(left, right);
		}

		// should never get here:
		throw new UnsupportedOperationException("OpType " + op
				+ "not implemented!");
	}

	public static TypeNode getResult(BiOpNode.OpType op, TypeNode left,
			TypeNode right) throws TypeMismatchException {

		if (!isCompatible(op, left, right)) {
			throw new TypeMismatchException("Tried to call " + op
					+ " on operands " + left + " (left) and " + right
					+ " (right)!");
		}

		switch (op) {
		case ASSIGN:
			return new PrimitiveTypeNode(Types.Primitive.VOID);
		case PLUS:
			if (left.isText() && right.isText())
				return new PrimitiveTypeNode(Types.Primitive.TEXT);
		case MINUS:
		case DIVIDE:
		case TIMES:
		case MOD:
			return getHigherNumericType((PrimitiveTypeNode) left,
					(PrimitiveTypeNode) right);
		case OR:
		case AND:
		case NOT_EQLS:
		case DBL_EQLS:
		case LESS:
		case GRTR:
		case LESS_EQL:
		case GRTR_EQL:
			return new PrimitiveTypeNode(Types.Primitive.BOOL);
		}

		// should never get here.
		throw new UnsupportedOperationException("OpType " + op
				+ "not implemented!");
	}

	public static boolean isCompatible(UnOpNode.OpType op, TypeNode operand) {
		
		switch(op) {
		case UMINUS:
		case INCR:
		case DECR:
			return operand.isNumeric();
		case CAST:
			throw new UnsupportedOperationException("TODO");
		case RETURN:
			throw new UnsupportedOperationException("TODO");
		case NOT:
			return operand.isBoolean();
		case NONE: 
			return true;
		}
		
		// should never get here.
		throw new UnsupportedOperationException("OpType " + op + "not implemented!");
	}

	public static TypeNode getResult(UnOpNode.OpType op, TypeNode operand) {
		throw new UnsupportedOperationException("TODO");
	}

	private static TypeNode getHigherNumericType(PrimitiveTypeNode left,
			PrimitiveTypeNode right) {
		if (left.getType() == Primitive.REAL
				|| right.getType() == Primitive.REAL) {
			return new PrimitiveTypeNode(Primitive.REAL);
		}
		return new PrimitiveTypeNode(Primitive.INT);
	}

}
