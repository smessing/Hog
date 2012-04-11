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

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be an INT_CONST", sym.INT_CONST,
				tokenList.get(0).intValue());
		assertEquals("The second token should be a PLUS", sym.PLUS, tokenList
				.get(1).intValue());
		assertEquals("The third token should be an INT_CONST", sym.INT_CONST,
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

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be an ID", sym.ID,
				tokenList.get(0).intValue());
		assertEquals("The second token should be a PLUS", sym.PLUS, tokenList
				.get(1).intValue());
		assertEquals("The third token should be an ID", sym.ID,
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

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be an ID", sym.ID,
				tokenList.get(0).intValue());
		assertEquals("The second token should be a MINUS", sym.MINUS, tokenList
				.get(1).intValue());
		assertEquals("The third token should be an ID", sym.ID,
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

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be an INT_CONST", sym.INT_CONST,
				tokenList.get(0).intValue());
		assertEquals("The second token should be a MINUS", sym.MINUS, tokenList
				.get(1).intValue());
		assertEquals("The third token should be an INT_CONST", sym.INT_CONST,
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

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be an INT_CONST", sym.INT_CONST,
				tokenList.get(0).intValue());
		assertEquals("The second token should be a DIVIDE", sym.DIVIDE, tokenList
				.get(1).intValue());
		assertEquals("The third token should be an INT_CONST", sym.INT_CONST,
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
	public void divisionSymbolTest2() throws IOException {

		String text = "a / b";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be an ID", sym.ID,
				tokenList.get(0).intValue());
		assertEquals("The second token should be a DIVIDE", sym.DIVIDE, tokenList
				.get(1).intValue());
		assertEquals("The third token should be an ID", sym.ID,
				tokenList.get(2).intValue());
		
	}
	
	/**
	 * Tests for correct parsing of multiplication operator and its operands.
	 * 
	 * Specifically, ensures that Lexer produces token streams of ID TIMES ID for strings like
	 * "a * b" and INT_CONST TIMES INT_CONST for strings like "1 * 2".
	 * 
	 * @throws IOException
	 */
	@Test
	public void multiplicationSymbolTest1() throws IOException {

		String text = "1 * 2";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be an INT_CONST", sym.INT_CONST,
				tokenList.get(0).intValue());
		assertEquals("The second token should be a TIMES", sym.TIMES, tokenList
				.get(1).intValue());
		assertEquals("The third token should be an INT_CONST", sym.INT_CONST,
				tokenList.get(2).intValue());
		
	}

	/**
	 * Tests for correct parsing of multiplication operator and its operands.
	 * 
	 * Specifically, ensures that Lexer produces token streams of ID TIMES ID for strings like
	 * "a * b" and INT_CONST TIMES INT_CONST for strings like "1 * 2".
	 * 
	 * @throws IOException
	 */
	@Test
	public void multiplicationSymbolTest2() throws IOException {

		String text = "a * b";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be an ID", sym.ID,
				tokenList.get(0).intValue());
		assertEquals("The second token should be a TIMES", sym.TIMES, tokenList
				.get(1).intValue());
		assertEquals("The third token should be an ID", sym.ID,
				tokenList.get(2).intValue());
		
	}
	
	/**
	 * Tests for correct parsing of a parenthesized expression.
	 * 
	 * Specifically, ensures that Lexer produces a token stream of L_PAREN ID R_PAREN for 
	 * strings like "(a)"
	 * 
	 * @throws IOException
	 */
	@Test
	public void parenthesesSymbolTest() throws IOException {

		String text = "(a)";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be an L_PAREN", sym.L_PAREN,
				tokenList.get(0).intValue());
		assertEquals("The second token should be a ID", sym.ID, tokenList
				.get(1).intValue());
		assertEquals("The third token should be an R_PAREN", sym.R_PAREN,
				tokenList.get(2).intValue());
		
	}
	
	/**
	 * Tests for correct parsing of the postfix increment operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of ID INCR for 
	 * strings like "a++"
	 * 
	 * @throws IOException
	 */
	@Test
	public void incrementSymbolTest() throws IOException {

		String text = "a++";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 2 tokens for the string '"
				+ text + "'", 2, tokenList.size());
		assertEquals("The first token should be a ID", sym.ID, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a INCR", sym.INCR, tokenList
				.get(1).intValue());
	}
	
	/**
	 * Tests for correct parsing of the postfix decrement operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of ID DECR for 
	 * strings like "a--"
	 * 
	 * @throws IOException
	 */
	@Test
	public void decrementSymbolTest() throws IOException {

		String text = "a--";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 2 tokens for the string '"
				+ text + "'", 2, tokenList.size());
		assertEquals("The first token should be a ID", sym.ID, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a DECR", sym.DECR, tokenList
				.get(1).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements with the logical 'and' operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of BOOL_CONST AND BOOL_CONST
	 * for strings like "true and false" and a token stream of ID AND ID for strings like
	 * "variable and variable"
	 * 
	 * @throws IOException
	 */
	@Test
	public void andSymbolTest1() throws IOException {

		String text = "true and false";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be a BOOL_CONST", sym.BOOL_CONST, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a AND", sym.AND, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a BOOL_CONST", sym.BOOL_CONST, tokenList
				.get(2).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements with the logical 'and' operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of BOOL_CONST AND BOOL_CONST
	 * for strings like "true and false" and a token stream of ID AND ID for strings like
	 * "variable and variable"
	 * 
	 * @throws IOException
	 */
	@Test
	public void andSymbolTest2() throws IOException {

		String text = "variable and variable";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be a ID", sym.ID, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a AND", sym.AND, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a ID", sym.ID, tokenList
				.get(2).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements with the logical 'or' operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of BOOL_CONST OR BOOL_CONST
	 * for strings like "true or false" and a token stream of ID OR ID for strings like
	 * "variable or variable"
	 * 
	 * @throws IOException
	 */
	@Test
	public void orSymbolTest1() throws IOException {

		String text = "true or false";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be a BOOL_CONST", sym.BOOL_CONST, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a OR", sym.OR, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a BOOL_CONST", sym.BOOL_CONST, tokenList
				.get(2).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements with the logical 'or' operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of BOOL_CONST OR BOOL_CONST
	 * for strings like "true or false" and a token stream of BOOL OR BOOL for strings like
	 * "bool or bool"
	 * 
	 * @throws IOException
	 */
	@Test
	public void orSymbolTest2() throws IOException {

		String text = "variable or variable";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be a ID", sym.ID, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a OR", sym.OR, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a ID", sym.ID, tokenList
				.get(2).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements with the logical 'not' operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of NOT BOOL_CONST
	 * for strings like "not true"
	 * 
	 * @throws IOException
	 */
/*	@Test
	public void notSymbolTest() throws IOException {

		String text = "not true";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 2 tokens for the string '"
				+ text + "'", 2, tokenList.size());
		assertEquals("The first token should be a NOT", sym.NOT, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a BOOL", sym.BOOL, tokenList
				.get(1).intValue());
	}*/
	
	/**
	 * Tests for correct parsing of the statements with the 'greater than' comparison operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of INT_CONST GRTR INT_CONST
	 * for strings like "2 > 1" and a token stream of ID GRTR ID for strings like
	 * "number > number"
	 * 
	 * @throws IOException
	 */
	@Test
	public void greaterThanSymbolTest1() throws IOException {

		String text = "2 > 1";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be a INT_CONST", sym.INT_CONST, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a GRTR", sym.GRTR, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a INT_CONST", sym.INT_CONST, tokenList
				.get(2).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements with the 'greater than' comparison operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of INT_CONST GRTR INT_CONST
	 * for strings like "2 > 1" and a token stream of ID GRTR ID for strings like
	 * "number > number"
	 * 
	 * @throws IOException
	 */
	@Test
	public void greaterThanSymbolTest2() throws IOException {

		String text = "number > number";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be a ID", sym.ID, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a GRTR", sym.GRTR, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a ID", sym.ID, tokenList
				.get(2).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements with the 'greater than or equal to' comparison
	 * operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of INT_CONST GRTR_EQL INT_CONST
	 * for strings like "2 >= 1" and a token stream of ID GRTR_EQL ID for strings like
	 * "number >= number"
	 * 
	 * @throws IOException
	 */
	@Test
	public void greaterThanOrEqualSymbolTest1() throws IOException {

		String text = "2 >= 1";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be a INT_CONST", sym.INT_CONST, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a GRTR_EQL", sym.GRTR_EQL, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a INT_CONST", sym.INT_CONST, tokenList
				.get(2).intValue());
	}
	

	/**
	 * Tests for correct parsing of the statements with the 'greater than or equal to' comparison
	 * operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of INT_CONST GRTR_EQL INT_CONST
	 * for strings like "2 >= 1" and a token stream of ID GRTR_EQL ID for strings like
	 * "number >= number"
	 * 
	 * @throws IOException
	 */
	@Test
	public void greaterThanOrEqualSymbolTest2() throws IOException {

		String text = "number >= number";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be a ID", sym.ID, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a GRTR_EQL", sym.GRTR_EQL, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a ID", sym.ID, tokenList
				.get(2).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements with the 'less than' comparison operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of INT_CONST LESS INT_CONST
	 * for strings like "2 < 1" and a token stream of ID LESS ID for strings like
	 * "number < number"
	 * 
	 * @throws IOException
	 */
	@Test
	public void lessThanSymbolTest1() throws IOException {

		String text = "2 < 1";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be a INT_CONST", sym.INT_CONST, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a LESS", sym.LESS, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a INT_CONST", sym.INT_CONST, tokenList
				.get(2).intValue());
	}

	/**
	 * Tests for correct parsing of the statements with the 'less than' comparison operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of INT_CONST LESS INT_CONST
	 * for strings like "2 < 1" and a token stream of ID LESS ID for strings like
	 * "number < number"
	 * 
	 * @throws IOException
	 */
	@Test
	public void lessThanSymbolTest2() throws IOException {

		String text = "number < number";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be a ID", sym.ID, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a LESS", sym.LESS, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a ID", sym.ID, tokenList
				.get(2).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements with the 'less than or equal to' comparison
	 * operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of INT_CONST LESS_EQL INT_CONST
	 * for strings like "2 <= 1" and a token stream of ID LESS_EQL ID for strings like
	 * "number <= number"
	 * 
	 * @throws IOException
	 */
	@Test
	public void lessThanOrEqualSymbolTest1() throws IOException {

		String text = "2 <= 1";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be a INT_CONST", sym.INT_CONST, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a LESS_EQL", sym.LESS_EQL, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a INT_CONST", sym.INT_CONST, tokenList
				.get(2).intValue());
	}
	

	/**
	 * Tests for correct parsing of the statements with the 'less than or equal to' comparison
	 * operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of INT_CONST LESS_EQL INT_CONST
	 * for strings like "2 <= 1" and a token stream of ID LESS_EQL ID for strings like
	 * "number <= number"
	 * 
	 * @throws IOException
	 */
	@Test
	public void lessThanOrEqualSymbolTest2() throws IOException {

		String text = "number <= number";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be a ID", sym.ID, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a LESS_EQL", sym.LESS_EQL, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a ID", sym.ID, tokenList
				.get(2).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements with the 'not equal to' comparison operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of INT_CONST NOT_EQLS INT_CONST
	 * for strings like "2 != 1" and a token stream of ID NOT_EQLS ID for strings like
	 * "number != number"
	 * 
	 * @throws IOException
	 */
	@Test
	public void notEqualSymbolTest1() throws IOException {

		String text = "2 != 1";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be a INT_CONST", sym.INT_CONST, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a NOT_EQLS", sym.NOT_EQLS, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a INT_CONST", sym.INT_CONST, tokenList
				.get(2).intValue());
	}
	

	/**
	 * Tests for correct parsing of the statements with the 'not equal to' comparison operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of INT_CONST NOT_EQLS INT_CONST
	 * for strings like "2 != 1" and a token stream of ID NOT_EQLS ID for strings like
	 * "number != number"
	 * 
	 * @throws IOException
	 */
	@Test
	public void notEqualSymbolTest2() throws IOException {

		String text = "number != number";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be a ID", sym.ID, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a NOT_EQLS", sym.NOT_EQLS, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a ID", sym.ID, tokenList
				.get(2).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements with the 'equal to' comparison operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of INT_CONST DBL_EQLS INT_CONST
	 * for strings like "2 == 1" and a token stream of ID DBL_EQLS ID for strings like
	 * "number == number"
	 * 
	 * @throws IOException
	 */
	@Test
	public void equalSymbolTest1() throws IOException {

		String text = "2 == 1";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be a INT_CONST", sym.INT_CONST, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a DBL_EQLS", sym.DBL_EQLS, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a INT_CONST", sym.INT_CONST, tokenList
				.get(2).intValue());
	}
	

	/**
	 * Tests for correct parsing of the statements with the 'equal to' comparison operator
	 * 
	 * Specifically, ensures that Lexer produces a token stream of INT_CONST DBL_EQLS INT_CONST
	 * for strings like "2 == 1" and a token stream of ID DBL_EQLS ID for strings like
	 * "number == number"
	 * 
	 * @throws IOException
	 */
	@Test
	public void equalSymbolTest2() throws IOException {

		String text = "number == number";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 3 tokens for the string '"
				+ text + "'", 3, tokenList.size());
		assertEquals("The first token should be a ID", sym.ID, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a DBL_EQLS", sym.DBL_EQLS, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a ID", sym.ID, tokenList
				.get(2).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements with 'if'
	 * 
	 * Specifically, ensures that Lexer produces a token stream of IF L_PAREN ID GRTR ID R_PAREN
	 * for strings like "if(number > number)"
	 * 
	 * @throws IOException
	 */
	@Test
	public void ifSymbolTest() throws IOException {

		String text = "if(number > number)";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 6 tokens for the string '"
				+ text + "'", 6, tokenList.size());
		assertEquals("The first token should be a IF", sym.IF, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a L_PAREN", sym.L_PAREN, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a ID", sym.ID, tokenList
				.get(2).intValue());
		assertEquals("The fourth token should be a GRTR", sym.GRTR, tokenList
				.get(3).intValue());
		assertEquals("The fifth token should be a ID", sym.ID, tokenList
				.get(4).intValue());
		assertEquals("The sixth token should be a R_PAREN", sym.R_PAREN, tokenList
				.get(5).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements surrounded by braces '{' and '}'
	 * 
	 * Specifically, ensures that Lexer produces a token stream of 
	 * L_BRACE INT ID SEMICOL R_BRACE for strings like "{  int variable; }"
	 * 
	 * @throws IOException
	 */
	@Test
	public void bracketSymbolTest() throws IOException {

		String text = "{  int variable; }";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 5 tokens for the string '"
				+ text + "'", 5, tokenList.size());
		assertEquals("The first token should be a L_BRACE", sym.L_BRACE, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a INT", sym.INT, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a ID", sym.ID, tokenList
				.get(2).intValue());
		assertEquals("The fourth token should be a SEMICOL", sym.SEMICOL, tokenList
				.get(3).intValue());
		assertEquals("The fifth token should be a R_BRACE", sym.R_BRACE, tokenList
				.get(4).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements with an 'else' clause
	 * 
	 * Specifically, ensures that Lexer produces a token stream of IF L_PAREN ID GRTR ID R_PAREN
	 * L_BRACE INT ID SEMICOL R_BRACE ELSE L_BRACE INT ID SEMICOL R_BRACE
	 * for strings like "if(number > numberTwo){  int variable; } else {  int other; }"
	 * 
	 * @throws IOException
	 */
	@Test
	public void elseSymbolTest() throws IOException {

		String text = "if(number > numberTwo){  int variable; } else {  int other; }";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 17 tokens for the string '"
				+ text + "'", 17, tokenList.size());
		assertEquals("The first token should be a IF", sym.IF, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a L_PAREN", sym.L_PAREN, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a ID", sym.ID, tokenList
				.get(2).intValue());
		assertEquals("The fourth token should be a GRTR", sym.GRTR, tokenList
				.get(3).intValue());
		assertEquals("The fifth token should be a ID", sym.ID, tokenList
				.get(4).intValue());
		assertEquals("The sixth token should be a R_PAREN", sym.R_PAREN, tokenList
				.get(5).intValue());
		assertEquals("The seventh token should be a L_BRACE", sym.L_BRACE, tokenList
				.get(6).intValue());
		assertEquals("The eighth token should be a INT", sym.INT, tokenList
				.get(7).intValue());
		assertEquals("The ninth token should be a ID", sym.ID, tokenList
				.get(8).intValue());
		assertEquals("The tenth token should be a SEMICOL", sym.SEMICOL, tokenList
				.get(9).intValue());
		assertEquals("The eleventh token should be a R_BRACE", sym.R_BRACE, tokenList
				.get(10).intValue());
		assertEquals("The twelfth token should be a ELSE", sym.ELSE, tokenList
				.get(11).intValue());
		assertEquals("The thirteenth token should be a L_BRACE", sym.L_BRACE, tokenList
				.get(12).intValue());
		assertEquals("The fourteenth token should be a INT", sym.INT, tokenList
				.get(13).intValue());
		assertEquals("The fifteenth token should be a ID", sym.ID, tokenList
				.get(14).intValue());
		assertEquals("The sixteenth token should be a SEMICOL", sym.SEMICOL, tokenList
				.get(15).intValue());
		assertEquals("The seventeenth token should be a R_BRACE", sym.R_BRACE, tokenList
				.get(16).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements with an 'elseif' clause
	 * 
	 * Specifically, ensures that Lexer produces a token stream of IF L_PAREN ID GRTR ID R_PAREN
	 * L_BRACE INT ID SEMICOL R_BRACE ELSEIF L_PAREN ID DBL_EQLS ID R_PAREN L_BRACE INT ID SEMICOL R_BRACE 
	 * ELSE L_BRACE INT ID SEMICOL R_BRACE
	 * for strings like 
	 * "if(number > numberTwo){  int variable; } elseif(number == numberTwo) {  int next; }
	 * else {  int other; }"
	 * 
	 * @throws IOException
	 */
	@Test
	public void elseIfSymbolTest() throws IOException {

		String text = "if(number > numberTwo){  int variable; } elseif (number == numberTwo)" +
				"{  int next; } else {  int other; }";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 28 tokens for the string '"
				+ text + "'", 28, tokenList.size());
		assertEquals("The first token should be a IF", sym.IF, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a L_PAREN", sym.L_PAREN, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a ID", sym.ID, tokenList
				.get(2).intValue());
		assertEquals("The fourth token should be a GRTR", sym.GRTR, tokenList
				.get(3).intValue());
		assertEquals("The fifth token should be a ID", sym.ID, tokenList
				.get(4).intValue());
		assertEquals("The sixth token should be a R_PAREN", sym.R_PAREN, tokenList
				.get(5).intValue());
		assertEquals("The seventh token should be a L_BRACE", sym.L_BRACE, tokenList
				.get(6).intValue());
		assertEquals("The eighth token should be a INT", sym.INT, tokenList
				.get(7).intValue());
		assertEquals("The ninth token should be a ID", sym.ID, tokenList
				.get(8).intValue());
		assertEquals("The tenth token should be a SEMICOL", sym.SEMICOL, tokenList
				.get(9).intValue());
		assertEquals("The eleventh token should be a R_BRACE", sym.R_BRACE, tokenList
				.get(10).intValue());
		assertEquals("The twelfth token should be a ELSEIF", sym.ELSEIF, tokenList
				.get(11).intValue());
		assertEquals("The thirteenth token should be a L_PAREN", sym.L_PAREN, tokenList
				.get(12).intValue());
		assertEquals("The fourteenth token should be a ID", sym.ID, tokenList
				.get(13).intValue());
		assertEquals("The fifteenth token should be a DBL_EQLS", sym.DBL_EQLS, tokenList
				.get(14).intValue());
		assertEquals("The sixteenth token should be a ID", sym.ID, tokenList
				.get(15).intValue());
		assertEquals("The seventeenth token should be a R_PAREN", sym.R_PAREN, tokenList
				.get(16).intValue());
		assertEquals("The eighteenth token should be a L_BRACE", sym.L_BRACE, tokenList
				.get(17).intValue());
		assertEquals("The nineteenth token should be a INT", sym.INT, tokenList
				.get(18).intValue());
		assertEquals("The twentieth token should be a ID", sym.ID, tokenList
				.get(19).intValue());
		assertEquals("The twenty first token should be a SEMICOL", sym.SEMICOL, tokenList
				.get(20).intValue());
		assertEquals("The twenty second token should be a R_BRACE", sym.R_BRACE, tokenList
				.get(21).intValue());
		assertEquals("The twenty third token should be a ELSE", sym.ELSE, tokenList
				.get(22).intValue());
		assertEquals("The twenth fourth token should be a L_BRACE", sym.L_BRACE, tokenList
				.get(23).intValue());
		assertEquals("The twenty fifth token should be a INT", sym.INT, tokenList
				.get(24).intValue());
		assertEquals("The twenty sixth token should be a ID", sym.ID, tokenList
				.get(25).intValue());
		assertEquals("The twenty seventh token should be a SEMICOL", sym.SEMICOL, tokenList
				.get(26).intValue());
		assertEquals("The twenty eighth token should be a R_BRACE", sym.R_BRACE, tokenList
				.get(27).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements with the 'assignment' symbol
	 * 
	 * Specifically, ensures that Lexer produces a token stream of INT ID ASSIGN INT_CONST SEMICOL
	 * for strings like "int variable = 1;"
	 * 
	 * @throws IOException
	 */
	@Test
	public void assignmentSymbolTest1() throws IOException {

		String text = "int variable = 1;";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 5 tokens for the string '"
				+ text + "'", 5, tokenList.size());
		assertEquals("The first token should be a INT", sym.INT, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a ID", sym.ID, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a ASSIGN", sym.ASSIGN, tokenList
				.get(2).intValue());
		assertEquals("The fourth token should be a INT_CONST", sym.INT_CONST, tokenList
				.get(3).intValue());
		assertEquals("The fifth token should be a SEMICOL", sym.SEMICOL, tokenList
				.get(4).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements with the 'assignment' symbol
	 * 
	 * Specifically, ensures that Lexer produces a token stream of BOOL ID ASSIGN BOOL_CONST SEMICOL
	 * for strings like "bool variable = true;"
	 * 
	 * @throws IOException
	 */
	@Test
	public void assignmentSymbolTest2() throws IOException {

		String text = "bool variable = true;";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 5 tokens for the string '"
				+ text + "'", 5, tokenList.size());
		assertEquals("The first token should be a BOOL", sym.BOOL, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a ID", sym.ID, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a ASSIGN", sym.ASSIGN, tokenList
				.get(2).intValue());
		assertEquals("The fourth token should be a BOOL_CONST", sym.BOOL_CONST, tokenList
				.get(3).intValue());
		assertEquals("The fifth token should be a SEMICOL", sym.SEMICOL, tokenList
				.get(4).intValue());
	}
	
	/**
	 * Tests for correct parsing of the statements with the 'assignment' symbol
	 * 
	 * Specifically, ensures that Lexer produces a token stream of BOOL ID ASSIGN BOOL_CONST SEMICOL
	 * for strings like "bool variable = true;"
	 * 
	 * @throws IOException
	 */
	@Test
	public void assignmentSymbolTest3() throws IOException {

		String text = "real variable = 1.3;";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce 5 tokens for the string '"
				+ text + "'", 5, tokenList.size());
		assertEquals("The first token should be a REAL", sym.REAL, tokenList
				.get(0).intValue());
		assertEquals("The second token should be a ID", sym.ID, tokenList
				.get(1).intValue());
		assertEquals("The third token should be a ASSIGN", sym.ASSIGN, tokenList
				.get(2).intValue());
		assertEquals("The fourth token should be a REAL_CONST", sym.REAL_CONST, tokenList
				.get(3).intValue());
		assertEquals("The fifth token should be a SEMICOL", sym.SEMICOL, tokenList
				.get(4).intValue());
	}
	
}
