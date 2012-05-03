package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import back_end.TypeCheckingVisitor;
import util.ast.AbstractSyntaxTree;
import util.ast.node.BiOpNode;
import util.ast.node.ConstantNode;
import util.ast.node.ExpressionNode;
import util.ast.node.IdNode;
import util.ast.node.MockExpressionNode;
import util.ast.node.MockNode;
import util.ast.node.Node;
import util.ast.node.RelationalExpressionNode;
import util.ast.node.UnOpNode;
import util.type.Types;


/**
 * 
 * Tests for the functionality provided by the AbstractSyntaxTree class.
 * 
 * @author sam, jason
 * 
 */
public class AbstractSyntaxTreeTester {

	private ExpressionNode A;
	private ExpressionNode B;
	private ExpressionNode C;
	private ExpressionNode D;
	private ExpressionNode E;
	private ExpressionNode F;
	private ExpressionNode G;
	private ExpressionNode H;
	private ExpressionNode I;
	private ExpressionNode J;
	private AbstractSyntaxTree tree;

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() {
		// A is root of tree, with children B, C
		// B has children D, E
		// C has children F, G
		D = new MockExpressionNode();
		E = new MockExpressionNode();
		F = new MockExpressionNode();
		G = new MockExpressionNode();
		J = new MockExpressionNode();
		H = new UnOpNode(UnOpNode.OpType.UMINUS, G);
		I = new RelationalExpressionNode(BiOpNode.OpType.LESS, E, J);
		B = new BiOpNode(BiOpNode.OpType.PLUS, D, I);
		C = new BiOpNode(BiOpNode.OpType.MINUS, F, H);
		A = new BiOpNode(BiOpNode.OpType.TIMES, B, C);
		tree = new AbstractSyntaxTree(A);
	}

	@After
	public void tearDown() {
	}

	/**
	 * Tests for correct ordering of nodes when generating preOrderTraversal
	 * iterators.
	 */
	@Test
	public void preOrderTraversalTest() {

		List<Node> correctPreOrderTraversal = new ArrayList<Node>();

		correctPreOrderTraversal.add(A);
		correctPreOrderTraversal.add(B);
		correctPreOrderTraversal.add(D);
		correctPreOrderTraversal.add(I);
		correctPreOrderTraversal.add(E);
		correctPreOrderTraversal.add(J);
		correctPreOrderTraversal.add(C);
		correctPreOrderTraversal.add(F);
		correctPreOrderTraversal.add(H);
		correctPreOrderTraversal.add(G);

		Iterator<Node> preOrderTraversal = tree.preOrderTraversal();
 
		int index = 0;
		while (preOrderTraversal.hasNext()) {
			Node nextNode = preOrderTraversal.next();
			Node correctNextNode = correctPreOrderTraversal.get(index);
			assertEquals(
					"It should compute the preOrderTraversal in the correct order.",
					nextNode, correctNextNode);
			index++;
		}

	}

	/**
	 * Tests for correct ordering of nodes when generating postOrderTraversal
	 * iterators.
	 */
	@Test
	public void postOrderTraversalTest() {

		List<Node> correctPostOrderTraversal = new ArrayList<Node>();

		correctPostOrderTraversal.add(D);
		correctPostOrderTraversal.add(E);
		correctPostOrderTraversal.add(J);
		correctPostOrderTraversal.add(I);
		correctPostOrderTraversal.add(B);
		correctPostOrderTraversal.add(F);
		correctPostOrderTraversal.add(G);
		correctPostOrderTraversal.add(H);
		correctPostOrderTraversal.add(C);
		correctPostOrderTraversal.add(A);

		Iterator<Node> postOrderTraversal = tree.postOrderTraversal();

		int index = 0;
		while (postOrderTraversal.hasNext()) {
			Node nextNode = postOrderTraversal.next();
			Node correctNextNode = correctPostOrderTraversal.get(index);
			assertEquals(
					"It should compute the postOrderTraversal in the correct order.",
					nextNode, correctNextNode);
			index++;
		}

	}
	



}
