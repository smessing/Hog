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
	//private IterationStatementNode __iterationStatementNode;
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
	//private SwitchStatementNode __switchStatementNode;
	//private TypeNode __typeNode;
	private UnOpNode __unOpNode;

	
	

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
		
		//IdNode arg1 = new IdNode("emit");
		//IdNode arg2 = new IdNode("values");
		//IdNode arg3 = new IdNode("next");
		//IdNode arg4 = new IdNode("UNKNOWN");
		/*
		__argumentsNode = new ArgumentsNode(arg2, arg3);	
		__postfixExpressionNode = new PostfixExpressionNode(PostfixType.METHOD_WITH_PARAMS, arg4, arg1);
		__statementListNode = new StatementListNode();
		__sectionNode = new SectionNode(__statementListNode, SectionNode.SectionName.MAIN);
		__biOpNode = new BiOpNode(null, A, A);
		__catchesNode = new CatchesNode(__idNode, __statementListNode);
		__constantNode = new ConstantNode(null, null);
		//__derivedTypeNode = new DerivedTypeNode(Type.Derived, new Types());
		__elseIfStatementNode = new ElseIfStatementNode(A, __statementListNode, __elseIfStatementNode);
		__exceptionTypeNode = new ExceptionTypeNode(null);
		//__expressionNode = new ExpressionNode(new MockExpressionNode());
		//__functionNode = new FunctionNode(null, null, __parametersNode, __statementListNode);
		__guardingStatementNode = new GuardingStatementNode(__statementListNode, __catchesNode);
		__idNode = new IdNode(null);
		__ifElseStatementNode = new IfElseStatementNode(A, __statementListNode, __elseIfStatementNode, null);
		//private IterationStatementNode __iterationStatementNode;
		__jumpStatementNode = new JumpStatementNode(null);
		__mockExpressionNode = new MockExpressionNode();	
		__mockNode= new MockNode();
		//__parametersNode = new ParametersNode(null, null);
		__primaryExpressionNode = new PrimaryExpressionNode();
		__primitiveTypeNode = new PrimitiveTypeNode(null);
		__programNode = new ProgramNode(__sectionNode, __sectionNode, __sectionNode, __sectionNode);
		__relationalExpressionNode = new RelationalExpressionNode(null, A, A);
		//__sectionTypeNode = new SectionTypeNode();
		//private SwitchStatementNode __switchStatementNode;
		//private TypeNode __typeNode;
		//__selectionStatementNode = new SelectionStatementNode(A);
		//
		//__statementNode = new StatementNode();
		//__unOpNode = new UnOpNode();
		 * 
		 */
	}

	@After
	public void tearDown() {
	}

	@Test
	public void toStringTest1() {

		String properName = "BiOpNode<TIMES>";

		assertEquals(
				"Nodes should return the proper name when toString() is called.",
				properName, A.toString());

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
