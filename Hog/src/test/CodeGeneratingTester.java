package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Iterator;

import org.junit.Test;

import util.ast.AbstractSyntaxTree;
import util.ast.node.IdNode;
import util.ast.node.Node;
import util.ast.node.ProgramNode;
import util.symbol_table.Symbol;
import util.symbol_table.SymbolTable;
import back_end.CodeGeneratingVisitor;
import back_end.SymbolTableVisitor;
import back_end.TypeCheckingVisitor;
import front_end.Lexer;
import front_end.Parser;

/**
 * 
 * @author Jason Halpern
 *
 */
public class CodeGeneratingTester {

	
	@Test
	public void codeGeneratingTest() {
		String filename = "WordCount.hog";
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
	    
	    TypeCheckingVisitor typeCheckVisitor = new TypeCheckingVisitor(ast);
	    typeCheckVisitor.walk();
	 
	    CodeGeneratingVisitor codeGenVisitor = new CodeGeneratingVisitor(ast);
	    codeGenVisitor.walk();
	    String temp = codeGenVisitor.getCode();
	    	    
		System.out.println(temp);

	}
	
	@Test
	public void codeGeneratingTestTwo() {
		String filename = "Factorial.hog";
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
	    
	    TypeCheckingVisitor typeCheckVisitor = new TypeCheckingVisitor(ast);
	    typeCheckVisitor.walk();
	 
	    CodeGeneratingVisitor codeGenVisitor = new CodeGeneratingVisitor(ast);
	    codeGenVisitor.walk();
	    String temp = codeGenVisitor.getCode();
	    	    
		System.out.println(temp);

	}
	
	@Test
	public void codeGeneratingTestThree() {
		String filename = "mergesort.hog";
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
	    
	    TypeCheckingVisitor typeCheckVisitor = new TypeCheckingVisitor(ast);
	    typeCheckVisitor.walk();
	 
	    CodeGeneratingVisitor codeGenVisitor = new CodeGeneratingVisitor(ast);
	    codeGenVisitor.walk();
	    String temp = codeGenVisitor.getCode();
	    	    
		System.out.println(temp);

	}
}
