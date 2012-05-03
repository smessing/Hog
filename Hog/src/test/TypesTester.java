package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.ast.node.BiOpNode;
import util.ast.node.DerivedTypeNode;
import util.ast.node.DictTypeNode;
import util.ast.node.ExceptionTypeNode;
import util.ast.node.PrimitiveTypeNode;
import util.ast.node.TypeNode;
import util.ast.node.UnOpNode;
import util.error.TypeMismatchError;
import util.type.Types;

/**
 * A method to test the convenience class for the Types convenience class.
 * 
 * @author sam, jason
 * 
 */
public class TypesTester {

	private TypeNode boolNode;
	private TypeNode intNode;
	private TypeNode realNode;
	private TypeNode textNode;
	private TypeNode listInt;
	private TypeNode exceptionFileNotFound;
	private TypeNode dict_Text_ListInt;
	private TypeNode setBool;
	private TypeNode listSetBool;
	private TypeNode listListSetBool;
	private TypeNode setListListSetBool;

	@Before
	public void setUp() {

		boolNode = new PrimitiveTypeNode(Types.Primitive.BOOL);
		intNode = new PrimitiveTypeNode(Types.Primitive.INT);
		realNode = new PrimitiveTypeNode(Types.Primitive.REAL);
		textNode = new PrimitiveTypeNode(Types.Primitive.TEXT);
		listInt = new DerivedTypeNode(Types.Derived.LIST, intNode);
		exceptionFileNotFound = new ExceptionTypeNode(
				Types.Exception.FILE_NOT_FOUND);
		dict_Text_ListInt = new DictTypeNode(Types.Primitive.TEXT, listInt);
		setBool = new DerivedTypeNode(Types.Derived.SET, boolNode);
		listSetBool = new DerivedTypeNode(Types.Derived.LIST, setBool);
		listListSetBool = new DerivedTypeNode(Types.Derived.LIST, listSetBool);
		setListListSetBool = new DerivedTypeNode(Types.Derived.SET,
				listListSetBool);

	}

	@Test
	public void testTypeEquvilance() {

		assertFalse(Types.isSameType(boolNode, intNode));
		assertTrue(Types.isSameType(dict_Text_ListInt, dict_Text_ListInt));
		TypeNode secondIntNode = new PrimitiveTypeNode(Types.Primitive.INT);
		assertTrue(Types.isSameType(secondIntNode, intNode));
		TypeNode secondListInt = new DerivedTypeNode(Types.Derived.LIST,
				secondIntNode);
		assertTrue(Types.isSameType(secondListInt, listInt));
		assertFalse(Types.isSameType(listListSetBool, listSetBool));
		TypeNode secondExceptionFileNotFound = new ExceptionTypeNode(
				Types.Exception.FILE_NOT_FOUND);
		assertTrue(Types.isSameType(exceptionFileNotFound,
				secondExceptionFileNotFound));

	}

	@Test
	public void testGetHigherNumericType() throws TypeMismatchError {
		assertTrue(Types.isSameType(intNode, Types.getHigherNumericType(
				intNode, intNode)));
		assertTrue(Types.isSameType(realNode, Types.getHigherNumericType(
				realNode, intNode)));
		assertFalse(Types.isSameType(boolNode, Types.getHigherNumericType(
				realNode, realNode)));
		assertFalse(Types.isSameType(boolNode, Types.getHigherNumericType(
				intNode, intNode)));
		assertFalse(Types.isSameType(textNode, Types.getHigherNumericType(
				intNode, intNode)));
		assertFalse(Types.isSameType(textNode, Types.getHigherNumericType(
				realNode, realNode)));
		assertFalse(Types.isSameType(textNode, realNode));
		assertFalse(Types.isSameType(textNode, intNode));
		assertFalse(Types.isSameType(textNode, boolNode));
		assertFalse(Types.isSameType(boolNode, intNode));
		assertFalse(Types.isSameType(boolNode, realNode));
		assertTrue(Types.isSameType(boolNode, boolNode));
	}
	
	@Test
	public void testUnOpIsCompatible() throws TypeMismatchError {
		assertTrue(Types.isCompatible(UnOpNode.OpType.DECR, intNode));
		assertTrue(Types.isCompatible(UnOpNode.OpType.DECR, realNode));
		assertFalse(Types.isCompatible(UnOpNode.OpType.DECR, boolNode));
		assertFalse(Types.isCompatible(UnOpNode.OpType.DECR, textNode));
		
		assertTrue(Types.isCompatible(UnOpNode.OpType.INCR, intNode));
		assertTrue(Types.isCompatible(UnOpNode.OpType.INCR, realNode));
		assertFalse(Types.isCompatible(UnOpNode.OpType.INCR, boolNode));
		assertFalse(Types.isCompatible(UnOpNode.OpType.INCR, textNode));
		
		assertFalse(Types.isCompatible(UnOpNode.OpType.NOT, intNode));
		assertFalse(Types.isCompatible(UnOpNode.OpType.NOT, realNode));
		assertTrue(Types.isCompatible(UnOpNode.OpType.NOT, boolNode));
		assertFalse(Types.isCompatible(UnOpNode.OpType.NOT, textNode));
		
		assertTrue(Types.isCompatible(UnOpNode.OpType.UMINUS, intNode));
		assertTrue(Types.isCompatible(UnOpNode.OpType.UMINUS, realNode));
		assertFalse(Types.isCompatible(UnOpNode.OpType.UMINUS, boolNode));
		assertFalse(Types.isCompatible(UnOpNode.OpType.UMINUS, textNode));
		
	}
	
	@Test
	public void testBiOpIsCompatible() throws TypeMismatchError {
		assertTrue(Types.isCompatible(BiOpNode.OpType.AND, boolNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.AND, textNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.AND, intNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.AND, textNode, textNode));
		
		assertTrue(Types.isCompatible(BiOpNode.OpType.OR, boolNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.OR, textNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.OR, intNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.OR, textNode, textNode));
		
		assertFalse(Types.isCompatible(BiOpNode.OpType.LESS, boolNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.LESS, textNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.LESS, intNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.LESS, textNode, textNode));
		assertTrue(Types.isCompatible(BiOpNode.OpType.LESS, intNode, intNode));
		assertTrue(Types.isCompatible(BiOpNode.OpType.LESS, realNode, realNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.LESS, setBool, setBool));
		
		assertFalse(Types.isCompatible(BiOpNode.OpType.GRTR, boolNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.GRTR, textNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.GRTR, intNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.GRTR, textNode, textNode));
		assertTrue(Types.isCompatible(BiOpNode.OpType.GRTR, intNode, intNode));
		assertTrue(Types.isCompatible(BiOpNode.OpType.GRTR, realNode, realNode));
		
		assertFalse(Types.isCompatible(BiOpNode.OpType.GRTR_EQL, boolNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.GRTR_EQL, textNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.GRTR_EQL, intNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.GRTR_EQL, textNode, textNode));
		assertTrue(Types.isCompatible(BiOpNode.OpType.GRTR_EQL, intNode, intNode));
		assertTrue(Types.isCompatible(BiOpNode.OpType.GRTR_EQL, realNode, realNode));
	
		assertFalse(Types.isCompatible(BiOpNode.OpType.LESS_EQL, boolNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.LESS_EQL, textNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.LESS_EQL, intNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.LESS_EQL, textNode, textNode));
		assertTrue(Types.isCompatible(BiOpNode.OpType.LESS_EQL, intNode, intNode));
		assertTrue(Types.isCompatible(BiOpNode.OpType.LESS_EQL, realNode, realNode));
		
		assertTrue(Types.isCompatible(BiOpNode.OpType.DBL_EQLS, boolNode, boolNode));
		assertTrue(Types.isCompatible(BiOpNode.OpType.DBL_EQLS, textNode, textNode));
		assertTrue(Types.isCompatible(BiOpNode.OpType.DBL_EQLS, intNode, intNode));
		assertTrue(Types.isCompatible(BiOpNode.OpType.DBL_EQLS, intNode, realNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.DBL_EQLS, textNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.DBL_EQLS, intNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.DBL_EQLS, textNode, boolNode));
		
		assertTrue(Types.isCompatible(BiOpNode.OpType.NOT_EQLS, boolNode, boolNode));
		assertTrue(Types.isCompatible(BiOpNode.OpType.NOT_EQLS, textNode, textNode));
		assertTrue(Types.isCompatible(BiOpNode.OpType.NOT_EQLS, intNode, intNode));
		assertTrue(Types.isCompatible(BiOpNode.OpType.NOT_EQLS, intNode, realNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.NOT_EQLS, textNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.NOT_EQLS, intNode, boolNode));
		assertFalse(Types.isCompatible(BiOpNode.OpType.NOT_EQLS, textNode, boolNode));
		
		assertFalse(Types.isCompatible(BiOpNode.OpType.DBL_EQLS, listInt, setBool));
		assertTrue(Types.isCompatible(BiOpNode.OpType.DBL_EQLS, listInt, listInt));

	}

	@Test(expected = TypeMismatchError.class)
	public void testGetHigherNumericType2() throws TypeMismatchError {
		Types.getHigherNumericType(boolNode, setBool);
	}

}
