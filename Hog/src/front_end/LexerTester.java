package front_end;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import java_cup.runtime.Symbol;

/**
 * Tests Lexer's performance on decomposing different inputs into the correct sequence of tokens.
 * 
 * @author jason, sam
 *
 */
public class LexerTester {


	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {
	}

	/**
	 * Tests for correct parsing of addition operator and its operands.
	 * 
	 * Specifically, ensures that Lexer produces token streams of ID PLUS ID for strings like
	 * "a + b" and INT_CONST PLUS INT_CONST for strings like "1 + 2".
	 * 
	 * @throws IOException
	 */
	@Test
	public void additionSymbolTest1() throws IOException {

		String text = "2 + 5";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce find 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be an INT_CONST", sym.INT_CONST,
				tokenList.get(0).intValue());
		assertEquals("The second token should be a PLUS", sym.PLUS, tokenList
				.get(1).intValue());
		assertEquals("The first token should be an INT_CONST", sym.INT_CONST,
				tokenList.get(2).intValue());
		
	}
	
	/**
	 * Tests for correct parsing of addition operator and its operands.
	 * 
	 * Specifically, ensures that Lexer produces token streams of ID PLUS ID for strings like
	 * "a + b" and INT_CONST PLUS INT_CONST for strings like "1 + 2".
	 * 
	 * @throws IOException
	 */
	@Test
	public void additionSymbolTest2() throws IOException {

		String text = "a + b";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce find 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be an ID", sym.ID,
				tokenList.get(0).intValue());
		assertEquals("The second token should be a PLUS", sym.PLUS, tokenList
				.get(1).intValue());
		assertEquals("The first token should be an ID", sym.ID,
				tokenList.get(2).intValue());
		
	}
	
	/**
	 * Tests for correct parsing of subtraction operator and its operands.
	 * 
	 * Specifically, ensures that Lexer produces token streams of ID MINUS ID for strings like
	 * "a - b" and INT_CONST MINUS INT_CONST for strings like "1 - 2".
	 * 
	 * @throws IOException
	 */
	@Test
	public void subtractionSymbolTest1() throws IOException {

		String text = "a - b";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce find 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be an ID", sym.ID,
				tokenList.get(0).intValue());
		assertEquals("The second token should be a MINUS", sym.MINUS, tokenList
				.get(1).intValue());
		assertEquals("The first token should be an ID", sym.ID,
				tokenList.get(2).intValue());
		
	}
	
	/**
	 * Tests for correct parsing of subtraction operator and its operands.
	 * 
	 * Specifically, ensures that Lexer produces token streams of ID MINUS ID for strings like
	 * "a - b" and INT_CONST MINUS INT_CONST for strings like "1 - 2".
	 * 
	 * @throws IOException
	 */
	@Test
	public void subtractionSymbolTest2() throws IOException {

		String text = "1 - 2";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce find 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be an INT_CONST", sym.INT_CONST,
				tokenList.get(0).intValue());
		assertEquals("The second token should be a MINUS", sym.MINUS, tokenList
				.get(1).intValue());
		assertEquals("The first token should be an INT_CONST", sym.INT_CONST,
				tokenList.get(2).intValue());
		
	}
	
	/**
	 * Tests for correct parsing of division operator and its operands.
	 * 
	 * Specifically, ensures that Lexer produces token streams of ID DIVIDE ID for strings like
	 * "a / b" and INT_CONST DIVIDE INT_CONST for strings like "1 / 2".
	 * 
	 * @throws IOException
	 */
	@Test
	public void divisionSymbolTest1() throws IOException {

		String text = "1 / 2";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce find 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be an INT_CONST", sym.INT_CONST,
				tokenList.get(0).intValue());
		assertEquals("The second token should be a DIVIDE", sym.DIVIDE, tokenList
				.get(1).intValue());
		assertEquals("The first token should be an INT_CONST", sym.INT_CONST,
				tokenList.get(2).intValue());
		
	}

}
