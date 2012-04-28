package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.ast.node.DerivedTypeNode;
import util.ast.node.DictTypeNode;
import util.ast.node.ExceptionTypeNode;
import util.ast.node.PrimitiveTypeNode;
import util.ast.node.TypeNode;
import util.type.Types;



/**
 * A method to test the convenience class for the Types convenience class.
 * 
 * @author sam
 *
 */
public class TypesTester {
	
	private TypeNode boolNode;
	private TypeNode intNode;
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
		textNode = new PrimitiveTypeNode(Types.Primitive.TEXT);
		listInt = new DerivedTypeNode(Types.Derived.LIST, intNode);
		exceptionFileNotFound = new ExceptionTypeNode(Types.Exception.FILE_NOT_FOUND);
		dict_Text_ListInt = new DictTypeNode(Types.Primitive.TEXT, listInt);
		setBool = new DerivedTypeNode(Types.Derived.SET, boolNode);
		listSetBool = new DerivedTypeNode(Types.Derived.LIST, setBool);
		listListSetBool = new DerivedTypeNode(Types.Derived.LIST, listSetBool);
		setListListSetBool = new DerivedTypeNode(Types.Derived.SET, listListSetBool);
		
	}
	
	
	
}
