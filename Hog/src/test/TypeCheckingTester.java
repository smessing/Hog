package test;

import static org.junit.Assert.assertEquals;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import org.junit.Test;

import util.ast.AbstractSyntaxTree;
import util.ast.node.IdNode;
import util.ast.node.Node;
import util.ast.node.PostfixExpressionNode;
import util.ast.node.ProgramNode;
import util.symbol_table.Symbol;
import util.symbol_table.SymbolTable;
import back_end.SymbolTableVisitor;
import back_end.TypeCheckingVisitor;
import front_end.Lexer;
import front_end.Parser;

/**
 * 
 * @author Jason Halpern
 *
 */

public class TypeCheckingTester {

	@Test
	public void typeCheckingTest() {
		String filename = "TypeDecoratorTest.hog";
		ProgramNode root = null;
		FileReader fileReader;
	    try {
			fileReader = new FileReader(new File(filename));
	        // Parser p = new Parser(new Lexer(System.in));
	    	Parser p = new Parser(new Lexer(fileReader));
	    	root = (ProgramNode) p.parse().value;
	    	
	      }
	      catch (FileNotFoundException e) {
	    	  System.out.println("file not found.");
	      }
	      catch (Exception ex) {
	    	  ex.printStackTrace();
	      }
	    
	    AbstractSyntaxTree ast = new AbstractSyntaxTree(root);
	    root.print();
	    
	    SymbolTableVisitor symTabVisitor = new SymbolTableVisitor(ast);
	    symTabVisitor.walk();
	    SymbolTable.printSymbolTable();
	    System.out.println("\n\n\n");
	    SymbolTable.print();
	    
	    root.print();
	    
	    TypeCheckingVisitor typeCheckVisitor = new TypeCheckingVisitor(ast);
	    typeCheckVisitor.walk();
	    
	    root.print();
	    
		Iterator<Node> postOrderTraversal = ast.postOrderTraversal();
		Node nextNode;
		Symbol tempSymbol;
		PostfixExpressionNode n;
		while (postOrderTraversal.hasNext()) {
			nextNode = postOrderTraversal.next(); 
			if(nextNode instanceof IdNode){
				tempSymbol = SymbolTable.getSymbolForIdNode((IdNode)nextNode);
				System.out.println("Identifier: " + ((IdNode) nextNode).getIdentifier() + " " + tempSymbol.getType().toString());
			}
			if(nextNode instanceof PostfixExpressionNode){
				n = (PostfixExpressionNode)nextNode;
				//tempSymbol = SymbolTable.getSymbolForIdNode((IdNode)nextNode);
				System.out.println("Function Name : " + n.getNameOfFunctionOrMethod() + " " + n.getTypeName().toString());
			}
		}

	}
	
	@Test
	public void typeCheckingTestTwo() {
		String filename = "TypeDecoratorTestTwo.hog";
		ProgramNode root = null;
		FileReader fileReader;
	    try {
			fileReader = new FileReader(new File(filename));
	        // Parser p = new Parser(new Lexer(System.in));
	    	Parser p = new Parser(new Lexer(fileReader));
	    	root = (ProgramNode) p.parse().value;
	    	
	      }
	      catch (FileNotFoundException e) {
	    	  System.out.println("file not found.");
	      }
	      catch (Exception ex) {
	    	  ex.printStackTrace();
	      }
	    
	    AbstractSyntaxTree ast = new AbstractSyntaxTree(root);
	    root.print();
	    
	    SymbolTableVisitor symTabVisitor = new SymbolTableVisitor(ast);
	    symTabVisitor.walk();
	    SymbolTable.printSymbolTable();
	    System.out.println("\n\n\n");
	    SymbolTable.print();
	    
	    root.print();
	    
	    TypeCheckingVisitor typeCheckVisitor = new TypeCheckingVisitor(ast);
	    typeCheckVisitor.walk();
	    
	    root.print();
	    
		Iterator<Node> postOrderTraversal = ast.postOrderTraversal();
		Node nextNode;
		Symbol tempSymbol;
		PostfixExpressionNode n;
		while (postOrderTraversal.hasNext()) {
			nextNode = postOrderTraversal.next(); 
			if(nextNode instanceof IdNode){
				tempSymbol = SymbolTable.getSymbolForIdNode((IdNode)nextNode);
				System.out.println("Identifier: " + ((IdNode) nextNode).getIdentifier() + " " + tempSymbol.getType().toString());
			}
			if(nextNode instanceof PostfixExpressionNode){
				n = (PostfixExpressionNode)nextNode;
				//tempSymbol = SymbolTable.getSymbolForIdNode((IdNode)nextNode);
				System.out.println("Function Name : " + n.getNameOfFunctionOrMethod() + " " + n.getTypeName().toString());
			}
		}

	}
}
