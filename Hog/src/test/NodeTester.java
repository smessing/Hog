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
 * @author Samuel Messing
 * @author Kurry Tran
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
		__biOpNode = new BiOpNode(BiOpNode.OpType.ASSIGN, A, B);
		__catchesNode = new CatchesNode(__idNode, __statementListNode);
		__constantNode = new ConstantNode(null, null);
		__derivedTypeNode = new DerivedTypeNode(Types.Derived.LIST, null);
		__elseIfStatementNode = new ElseIfStatementNode(A, __statementListNode, __elseIfStatementNode);
		__exceptionTypeNode = new ExceptionTypeNode(null);
		__functionNode = new FunctionNode(null, null, __parametersNode, __statementListNode);
		__guardingStatementNode = new GuardingStatementNode(__statementListNode, __catchesNode);
		__idNode = new IdNode("foo");
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

		String properName = "BiOpNode<TIMES>";

		assertEquals("Nodes should return the proper name when toString() is called.", properName, A.toString());

	}

	@Test
	public void toStringTest2() {

		String properName = "BiOpNode<TIMES>";

		assertEquals(
				"Nodes should return the proper name when toString() is called.",
				properName, A.toString());

	}

	@Test(expected = UnsupportedOperationException.class)
	public void doubleAddParentTest() {
		// note that this.addChild(that) implicitly sets that's parent to be
		// this. In this case, D already has it's parent set to B.
		B.setParent(D);
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
		assertEquals("removeChild should properly remove a child", 1, A
				.getChildren().size());
		assertEquals("removeChild should properly remove a child", false, A
				.hasChild(C));
		assertEquals("removeChild should properly unset childs parent", null, C
				.getParent());
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
