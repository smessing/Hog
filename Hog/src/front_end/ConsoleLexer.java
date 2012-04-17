package front_end;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import util.ast.AbstractSyntaxTree;
import util.ast.UntypedAbstractSyntaxTree;
import util.ast.node.BiOpNode;
import util.ast.node.ExpressionNode;
import util.ast.node.IdNode;
import util.ast.node.MockExpressionNode;
import util.ast.node.MockNode;
import util.ast.node.Node;
import util.type.Types;

import java_cup.parser;
import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;
import front_end.*;

/**
 * A console front-end to the Lexer class for dynamically testing the Lexer.
 * 
 * @author sam
 *
 */
@SuppressWarnings("unused")
public class ConsoleLexer {

	/**
	 * @param args
	 * */
	public static void main(String[] args) throws IOException {
		
		String filename = "testWordCountProg";
		File testFile = new File(filename);
	    try {
	        //Parser p = new Parser(new Lexer(new FileReader(filename)));
	    	Parser p = new Parser(testFile);
	        Object result = p.parse().value;
	      }
	      catch (FileNotFoundException e) {
	    	  System.out.println("file not found.");
	      }
	      catch (Exception ex) {
	    	  System.out.println("some other exception.");
	    	  ex.printStackTrace();
	      }
	}
}
