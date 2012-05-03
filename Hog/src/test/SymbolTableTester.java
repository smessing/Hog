package test;

import static org.junit.Assert.*;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Set;

import org.junit.Test;

import back_end.SymbolTableVisitor;
import front_end.Lexer;
import front_end.Parser;

import util.ast.AbstractSyntaxTree;
import util.ast.node.ProgramNode;
import util.symbol_table.SymbolTable;

public class SymbolTableTester {

	@Test
	public void reservedSymbolTableTest() {
		/* 
		 * create a new symbol table, this should be root 
		 * and should be populated with all reserved words and functions
		 */
		SymbolTable sym = new SymbolTable(null);
		Set<String> reservedSet = sym.table.keySet();
		for(String s : reservedSet){
			System.out.println("KEY: "+ s + " VALUE: " + sym.get(s).type);
		}
	}
	
	@Test
	public void symbolTableTestTwo() {
		/* 
		 * create a new symbol table, this should be root 
		 * and should be populated with all reserved words and functions
		 */
		String filename = "Factorial2.hog";
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
	    //write tests
	    SymbolTable.print();
	    System.out.println("\n\n\n");
	    SymbolTable.printSymbolTable();
	}
	
	@Test
	public void symbolTableTest() {
		/* 
		 * create a new symbol table, this should be root 
		 * and should be populated with all reserved words and functions
		 */
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
	    //write tests
	    SymbolTable.print();
	    System.out.println("\n\n\n");
	    SymbolTable.printSymbolTable();
	}
	
	@Test
	public void symbolTableTestThree() {
		/* 
		 * create a new symbol table, this should be root 
		 * and should be populated with all reserved words and functions
		 */
		String filename = "TestProgram.hog";
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
	    System.out.println("\n\n\n");
	    
	    SymbolTableVisitor symTabVisitor = new SymbolTableVisitor(ast);
	    symTabVisitor.walk();
	    //write tests
	    SymbolTable.print();
	    System.out.println("\n\n\n");
	    SymbolTable.printSymbolTable();

	}
	
	@Test
	public void WordCountTest() {
		/* 
		 * create a new symbol table, this should be root 
		 * and should be populated with all reserved words and functions
		 */
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
	    System.out.println("\n\n\n");
	    
	    SymbolTableVisitor symTabVisitor = new SymbolTableVisitor(ast);
	    symTabVisitor.walk();
	    //write tests
	    SymbolTable.print();
	    System.out.println("\n\n\n");
	    SymbolTable.printSymbolTable();

	}

}
