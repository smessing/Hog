package test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.ast.node.*;
import util.ast.node.PostfixExpressionNode.PostfixType;
import util.ast.node.BiOpNode.OpType;
import util.ast.node.SectionNode.SectionName;

import util.type.Types;

/**
 * 
 * Tests for the functionality provided by the AbstractSyntaxTree class.
 * 
 * @author sam
 * 
 */
public class NodeTester {

	private ExpressionNode A;
	private ExpressionNode B;
	private ExpressionNode C;
	private ExpressionNode D;
	private ExpressionNode E;
	private ExpressionNode F;
	private ExpressionNode G;
	
	private ArgumentsNode __argumentsNode;
	private BiOpNode __biOpNode;
	private CatchesNode __catchesNode;
	private ConstantNode __constantNode;
	private DerivedTypeNode __derivedTypeNode;
	private ElseIfStatementNode __elseIfStatementNode;
	private ExceptionTypeNode __exceptionTypeNode;
	private ExpressionNode __expressionNode;
	private FunctionNode __functionNode;
	private GuardingStatementNode __guardingStatementNode;
	private IdNode __idNode;
	private IfElseStatementNode __ifElseStatementNode;
	private IterationStatementNode __iterationStatementNode;
	private JumpStatementNode __jumpStatementNode;
	private MockExpressionNode __mockExpressionNode;
	private MockNode __mockNode;
	private ParametersNode __parametersNode;
	private PostfixExpressionNode __postfixExpressionNode;
	private PrimaryExpressionNode __primaryExpressionNode;
	private PrimitiveTypeNode __primitiveTypeNode;
	private ProgramNode __programNode;
	private RelationalExpressionNode __relationalExpressionNode;
	private SectionNode __sectionNode;
	private SectionTypeNode __sectionTypeNode;
	private SelectionStatementNode __selectionStatementNode;
	private StatementListNode __statementListNode;
	private StatementNode __statementNode;
	private SwitchStatementNode __switchStatementNode;
	private TypeNode __typeNode;
	private UnOpNode __unOpNode;

	public static final BiOpNode.OpType OPTYPE_ASSIGN = BiOpNode.OpType.ASSIGN;
	public static final String ERROR_MESSAGE_TO_STRING = "Nodes should return the proper name when toString() is called.";
	public static final String ERROR_MESSAGE_GET_NAME = "Nodes should return the proper name when getName() is called.";
	public static final String ERROR_MESSAGE_REMOVE_CHILD = "removeChild should properly remove a child";
	public static final String ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT = "removeChild should properly unset the parent of child";

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() {
		// A (MultExprNode) -> B (MultExprNode) * C (idNode)
		// B -> D * E
		C = new IdNode("C");
		D = new UnOpNode(UnOpNode.OpType.CAST, new MockExpressionNode());
		E = new UnOpNode(UnOpNode.OpType.CAST, new MockExpressionNode());
		B = new BiOpNode(BiOpNode.OpType.TIMES, D, E);
		A = new BiOpNode(BiOpNode.OpType.TIMES, B, C);
		
		/* FUNCTION_CALL<unknown>
		 * |-- IdNode<unknown,emit> 
		 * L__ ArgumentsNode
		 * 		|-- IdNode<unknown,count>
		 * 		L__ IdNode<unknown,word>
		 * 
		 */	
		__argumentsNode = new ArgumentsNode(new IdNode("values"),new IdNode("next"));
		__postfixExpressionNode = new PostfixExpressionNode(PostfixType.METHOD_WITH_PARAMS,  new IdNode("UNKNOWN"), new IdNode("emit"));
		
		/* StatementListNode
		 * BiOpNode<ASSIGN>
		 * IdNode<Primitive Type: INT, count>
		 * ConstantNode<Primitive Type: INT>
		 * 
		 */
		__statementListNode = new StatementListNode(new BiOpNode(BiOpNode.OpType.ASSIGN,new IdNode("count"),new ConstantNode(Types.Primitive.INT,"constant")));
		__sectionNode = new SectionNode(__statementListNode, SectionNode.SectionName.MAIN);
		__biOpNode = new BiOpNode(null, A, A);
		__catchesNode = new CatchesNode(__idNode, __statementListNode);
		__constantNode = new ConstantNode(null, null);
		__derivedTypeNode = new DerivedTypeNode(Types.Derived.DICT, null);
		__elseIfStatementNode = new ElseIfStatementNode(A, __statementListNode, __elseIfStatementNode);
		__exceptionTypeNode = new ExceptionTypeNode(null);
		__functionNode = new FunctionNode(null, null, __parametersNode, __statementListNode);
		__guardingStatementNode = new GuardingStatementNode(__statementListNode, __catchesNode);
		__idNode = new IdNode(null);
		__ifElseStatementNode = new IfElseStatementNode(A, __statementListNode, __elseIfStatementNode, null);
		__iterationStatementNode = new IterationStatementNode(A, A, __statementListNode) ;
		__jumpStatementNode = new JumpStatementNode(null);
		__mockExpressionNode = new MockExpressionNode();	
		__mockNode= new MockNode();
		__parametersNode = new ParametersNode(null, null);
		__primaryExpressionNode = new PrimaryExpressionNode();
		__primitiveTypeNode = new PrimitiveTypeNode(null);
		__programNode = new ProgramNode(__sectionNode, __sectionNode, __sectionNode, __sectionNode);
		__relationalExpressionNode = new RelationalExpressionNode(null, A, A);
		__sectionTypeNode = new SectionTypeNode(__idNode, __idNode, __typeNode, __typeNode);
		 __switchStatementNode = new SwitchStatementNode(A, __statementListNode);
		__selectionStatementNode = new SelectionStatementNode(A);
		__statementNode = new StatementNode();
		__unOpNode = new UnOpNode(null, A);
	
	}

	@After
	public void tearDown() {
	}

	@Test
	public void getNameTest1(){
		
		assertEquals( ERROR_MESSAGE_GET_NAME, "ArgumentsNode", __argumentsNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "BiOpNode", __biOpNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "CatchesNode", __catchesNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "ConstantNode", __constantNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "DerivedTypeNode", __derivedTypeNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "ElseIfStatementNode", __elseIfStatementNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "ExceptionTypeNode", __exceptionTypeNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "ExpressionNode", __expressionNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "FunctionNode", __functionNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "GuardingStatementNode", __guardingStatementNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "IdNode", __idNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "IfElseStatementNode", __ifElseStatementNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "IterationStatementNode", __iterationStatementNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "JumpStatementNode", __jumpStatementNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "MockExpressionNode", __mockExpressionNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "MockNode", __mockNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "ParametersNode", __parametersNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "PostFixExpressionNode", __postfixExpressionNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "PrimaryExpressionNode", __primaryExpressionNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "PrimitiveTypeNode", __primitiveTypeNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "ProgramNode", __programNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "RelationalExpressionNode", __relationalExpressionNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "SectionNode", __sectionNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "StatementListNode", __statementListNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "StatementNode", __statementNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "SwitchStatementNode", __switchStatementNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "UnOpNode", __unOpNode.getName());	
		
	}
	
	@Test
	public void getNameTest2(){
		
		assertEquals( ERROR_MESSAGE_GET_NAME, "ArgumentsNode", __argumentsNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "BiOpNode", __biOpNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "CatchesNode", __catchesNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "ConstantNode", __constantNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "DerivedTypeNode", __derivedTypeNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "ElseIfStatementNode", __elseIfStatementNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "ExceptionTypeNode", __exceptionTypeNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "ExpressionNode", __expressionNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "FunctionNode", __functionNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "GuardingStatementNode", __guardingStatementNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "IdNode", __idNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "IfElseStatementNode", __ifElseStatementNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "IterationStatementNode", __iterationStatementNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "JumpStatementNode", __jumpStatementNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "MockExpressionNode", __mockExpressionNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "MockNode", __mockNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "ParametersNode", __parametersNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "PostFixExpressionNode", __postfixExpressionNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "PrimaryExpressionNode", __primaryExpressionNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "PrimitiveTypeNode", __primitiveTypeNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "ProgramNode", __programNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "RelationalExpressionNode", __relationalExpressionNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "SectionNode", __sectionNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "StatementListNode", __statementListNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "StatementNode", __statementNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "SwitchStatementNode", __switchStatementNode.getName());
		assertEquals( ERROR_MESSAGE_GET_NAME, "UnOpNode", __unOpNode.getName());		
		
	}
	
	@Test
	public void toStringTest1() {
		String TO_BE_DETERMINED = "";
		
		String properName = "BiOpNode<TIMES>"; 
		assertEquals("Nodes should return the proper name when toString() is called.", properName, A.toString());
		/**
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __argumentsNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __biOpNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __catchesNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __constantNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __derivedTypeNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __elseIfStatementNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __exceptionTypeNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __expressionNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __functionNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __guardingStatementNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __idNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __ifElseStatementNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __iterationStatementNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __jumpStatementNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __mockExpressionNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __mockNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __parametersNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __postfixExpressionNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __primaryExpressionNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __primitiveTypeNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __programNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __relationalExpressionNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __sectionNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __statementListNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __statementNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __switchStatementNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __unOpNode.toString());
		
		*/

	}

	@Test
	public void toStringTest2() {

		String properName = "BiOpNode<TIMES>";

		assertEquals("Nodes should return the proper name when toString() is called.", properName, A.toString());
		/*
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __argumentsNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __biOpNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __catchesNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __constantNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __derivedTypeNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __elseIfStatementNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __exceptionTypeNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __expressionNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __functionNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __guardingStatementNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __idNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __ifElseStatementNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __iterationStatementNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __jumpStatementNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __mockExpressionNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __mockNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __parametersNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __postfixExpressionNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __primaryExpressionNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __primitiveTypeNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __programNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __relationalExpressionNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __sectionNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __statementListNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __statementNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __switchStatementNode.toString());
		assertEquals( ERROR_MESSAGE_TO_STRING, TO_BE_DETERMINED, __unOpNode.toString());
		
		*/
	}

	@Test(expected = UnsupportedOperationException.class)
	public void doubleAddParentTest() {
		// note that this.addChild(that) implicitly sets that's parent to be
		// this. In this case, D already has it's parent set to B.
		B.setParent(D);
		__argumentsNode.setParent(D);
		__biOpNode.setParent(D);
		__catchesNode.setParent(D);
		 __constantNode.setParent(D);
		__derivedTypeNode.setParent(D);
		__elseIfStatementNode.setParent(D);
		__exceptionTypeNode.setParent(D);
		__expressionNode.setParent(D);
		__functionNode.setParent(D);
		__guardingStatementNode.setParent(D);
		__idNode.setParent(D);
		__ifElseStatementNode.setParent(D);
		__iterationStatementNode.setParent(D);
		__jumpStatementNode.setParent(D);
		__mockExpressionNode.setParent(D);
		__mockNode.setParent(D);
		__parametersNode.setParent(D);
		__postfixExpressionNode.setParent(D);
		__primaryExpressionNode.setParent(D);
		__primitiveTypeNode.setParent(D);
		__programNode.setParent(D);
		__relationalExpressionNode.setParent(D);
		__sectionNode.setParent(D);
		__sectionTypeNode.setParent(D);
		__selectionStatementNode.setParent(D);
		__statementListNode.setParent(D);
		__statementNode.setParent(D);
		__switchStatementNode.setParent(D);
		__typeNode.setParent(D);
		__unOpNode.setParent(D);
	}

	@Test
	public void addChildTest() {
		MockNode parent = new MockNode();
		MockNode childOne = new MockNode();
		MockNode childTwo = new MockNode();
		parent.addChild(childOne);
		parent.addChild(childTwo);
		assertEquals("addChild should properly add children", 2, parent
				.getChildren().size());
		assertEquals(
				"addChild should always add a new child as rightmost child",
				childTwo, parent.getChildren().get(1));
		assertEquals(
				"addChild should always add a new child as rightmost child",
				childOne, parent.getChildren().get(0));
		parent.addChild(null);
		assertEquals("adding a null child should do nothing", 2, parent
				.getChildren().size());
	}

	@Test
	public void removeChildTest() {
		A.removeChild(C);
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, A .getChildren().size());
		
		/*
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __argumentsNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __biOpNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __catchesNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __constantNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __derivedTypeNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __elseIfStatementNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __exceptionTypeNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __expressionNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __functionNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __guardingStatementNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __idNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __ifElseStatementNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __iterationStatementNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __jumpStatementNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __mockExpressionNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __mockNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __parametersNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __postfixExpressionNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __primaryExpressionNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __primitiveTypeNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __programNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __relationalExpressionNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __sectionNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __sectionTypeNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __selectionStatementNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __statementListNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __statementNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __switchStatementNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __typeNode.getChildren().size());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, 1, __unOpNode.getChildren().size());
		*/
		
		
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD, false, A .hasChild(C));
		/*
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __argumentsNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __biOpNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __catchesNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __constantNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __derivedTypeNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __elseIfStatementNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __exceptionTypeNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __expressionNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __functionNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __guardingStatementNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __idNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __ifElseStatementNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __iterationStatementNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __jumpStatementNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __mockExpressionNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __mockNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __parametersNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __postfixExpressionNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __primaryExpressionNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __primitiveTypeNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __programNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __relationalExpressionNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __sectionNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __sectionTypeNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __selectionStatementNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __statementListNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __statementNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __switchStatementNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __typeNode.hasChild(C));
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, false, __unOpNode.hasChild(C));
		*/
		
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, C.getParent());
		/*
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __argumentsNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __biOpNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __catchesNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __constantNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __derivedTypeNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __elseIfStatementNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __exceptionTypeNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __expressionNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __functionNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __guardingStatementNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __idNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __ifElseStatementNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __iterationStatementNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __jumpStatementNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __mockExpressionNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __mockNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __parametersNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __postfixExpressionNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __primaryExpressionNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __primitiveTypeNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __programNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __relationalExpressionNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __sectionNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __sectionTypeNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __selectionStatementNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __statementListNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __statementNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __switchStatementNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __typeNode.getParent());
		assertEquals(ERROR_MESSAGE_REMOVE_CHILD_UNSET_PARENT, null, __unOpNode.getParent());
		*/
		
		
	}

	@Test
	public void setUnsetParentTest() {
		MockNode parent = new MockNode();
		MockNode child = new MockNode();
		assertEquals("Nodes should have null parents by default", null, child
				.getParent());
		parent.addChild(child);
		assertEquals(
				"Adding a child to a parent should set parent to be child's parent.",
				parent, child.getParent());
		child.unsetParent();
		assertEquals("Unsetting a child's parent should set parent to null",
				null, child.getParent());
		assertEquals(
				"Unsetting a child's parent removes the child from the parent's children list.",
				false, parent.getChildren().contains(child));
	}
}
