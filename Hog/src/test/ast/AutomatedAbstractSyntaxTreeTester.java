package test.ast;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.ast.AbstractSyntaxTree;
import util.ast.UntypedAbstractSyntaxTree;
import util.ast.node.MockNode;
import util.ast.node.Node;

/**
 * 
 * Tests for the functionality provided by the AbstractSyntaxTree class.
 * 
 * @author sam
 * 
 */
public class AutomatedAbstractSyntaxTreeTester {
	
	private Node A;
	private Node B;
	private Node C;
	private Node D;
	private Node E;
	private Node F;
	private Node G;

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() {
		A = new MockNode();
		B = new MockNode();
		C = new MockNode();
		D = new MockNode();
		E = new MockNode();
		F = new MockNode();
		G = new MockNode();
	}

	@After
	public void tearDown() {
	}
	
	/**
	 * Tests for correct ordering of nodes when generating postOrderTraversal iterators.
	 */
	@Test
	public void postOrderTraversalTest() {
		
		// A is root of tree, with children B, C
		// B has children D, E
		// C has children F, G
		A.addChild(B);
		A.addChild(C);
		B.addChild(D);
		B.addChild(E);
		C.addChild(F);
		C.addChild(G);
		
		List<Node> correctPostOrderTraversal = new ArrayList<Node>();
		
		correctPostOrderTraversal.add(D);
		correctPostOrderTraversal.add(E);
		correctPostOrderTraversal.add(B);
		correctPostOrderTraversal.add(F);
		correctPostOrderTraversal.add(G);
		correctPostOrderTraversal.add(C);
		correctPostOrderTraversal.add(A);
		
		AbstractSyntaxTree tree = new UntypedAbstractSyntaxTree(A);
		
		Iterator<Node> postOrderTraversal = tree.postOrderTraversal();
		
		int index = 0;
		while (postOrderTraversal.hasNext()) {
			assertEquals("It should compute the postOrderTraversal in the correct order. " +
					"Next comes: " + correctPost)
		}
		
	}

}
