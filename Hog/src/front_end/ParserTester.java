package front_end;

import static org.junit.Assert.*;

import java.io.StringReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.ast.node.ProgramNode;


/**
 * Tests basic functionality of Parser.java.
 * 
 * 
 * @author sam
 *
 */
public class ParserTester {
	
	@Test
	public void firstTest() throws Exception {
		String text = "2 + 5";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		Parser parser = new Parser(lexer);
		ProgramNode root = (ProgramNode) parser.debug_parse().value;
		System.out.println(root);
	}
	

}
