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

import org.junit.Test;

public class LexerTester {

	private StringReader stringReader;

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
	 * Tests for correct parsing of addition operator and it's operands.
	 * 
	 * Specifically, ensures that Lexer produces token streams of ID PLUS ID for strings like
	 * "a + b" and INT_CONST PLUS INT_CONST for strings like "1 + 2".
	 * 
	 * @throws IOException
	 */
	@Test
	public void additionSymbolTest1() throws IOException {

		String additionText = "2 + 5";
		stringReader = new StringReader(additionText);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce find 3 tokens for the string '"
				+ additionText + "'", 3, tokenList.size());
		assertEquals("The first token should be an INT_CONST", sym.INT_CONST,
				tokenList.get(0).intValue());
		assertEquals("The second token should be a PLUS", sym.PLUS, tokenList
				.get(1).intValue());
		assertEquals("The first token should be an INT_CONST", sym.INT_CONST,
				tokenList.get(2).intValue());
		
	}
	
	/**
	 * Tests for correct parsing of addition operator and it's operands.
	 * 
	 * Specifically, ensures that Lexer produces token streams of ID PLUS ID for strings like
	 * "a + b" and INT_CONST PLUS INT_CONST for strings like "1 + 2".
	 * 
	 * @throws IOException
	 */
	@Test
	public void additionSymbolTest2() throws IOException {

		String additionText = "a + b";
		stringReader = new StringReader(additionText);
		Lexer lexer = new Lexer(stringReader);
		List<Integer> tokenList = new ArrayList<Integer>();
		Symbol token = lexer.next_token();
		
		while (token.sym != sym.EOF) {
			tokenList.add(token.sym);
			token = lexer.next_token();
		}

		assertEquals("It should produce find 3 tokens for the string '"
				+ additionText + "'", 3, tokenList.size());
		assertEquals("The first token should be an ID", sym.ID,
				tokenList.get(0).intValue());
		assertEquals("The second token should be a PLUS", sym.PLUS, tokenList
				.get(1).intValue());
		assertEquals("The first token should be an ID", sym.ID,
				tokenList.get(2).intValue());
		
	}

	/*
	/*
	 * Test to make sure the appropriate symbols are returned for the
	 * subtraction of two numbers. To correctly use the test, input must be in
	 * the following format: number - number NOTE: This does not test whether or
	 * not the subtraction is being done correctly, it just makes sure the right
	 * symbols are being returned after the expression is parsed
	 *
	@Test
	public void subtractionSymbolTest() throws IOException {
		Lexer lexer = new Lexer(System.in);
		Symbol token;
		ArrayList<Integer> tokenList = new ArrayList<Integer>();
		System.out.print("input: ");
		for (int i = 0; i < 3; i++) {
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		}

		assertEquals(tokenList.get(0).intValue(), sym.INT_CONST);
		assertEquals(tokenList.get(1).intValue(), sym.MINUS);
		assertEquals(tokenList.get(2).intValue(), sym.INT_CONST);
	}

	/*
	 * Test to make sure the appropriate symbols are returned for the division
	 * of two numbers. To correctly use the test, input must be in the following
	 * format: number / number NOTE: This does not test whether or not the
	 * division is being done correctly, it just makes sure the right symbols
	 * are being returned after the expression is parsed
	 *
	@Test
	public void divisionSymbolTest() throws IOException {
		Lexer lexer = new Lexer(System.in);
		Symbol token;
		ArrayList<Integer> tokenList = new ArrayList<Integer>();
		System.out.print("input: ");
		for (int i = 0; i < 3; i++) {
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		}

		assertEquals(tokenList.get(0).intValue(), sym.INT_CONST);
		assertEquals(tokenList.get(1).intValue(), sym.DIVIDE);
		assertEquals(tokenList.get(2).intValue(), sym.INT_CONST);
	}

	/*
	 * Test to make sure the appropriate symbols are returned for the
	 * multiplication of two numbers. To correctly use the test, input must be
	 * in the following format: number * number NOTE: This does not test whether
	 * or not the multiplication is being done correctly, it just makes sure the
	 * right symbols are being returned after the expression is parsed
	 *
	@Test
	public void multiplicationSymbolTest() throws IOException {
		Lexer lexer = new Lexer(System.in);
		Symbol token;
		ArrayList<Integer> tokenList = new ArrayList<Integer>();
		System.out.print("input: ");
		for (int i = 0; i < 3; i++) {
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		}

		assertEquals(tokenList.get(0).intValue(), sym.INT_CONST);
		assertEquals(tokenList.get(1).intValue(), sym.TIMES);
		assertEquals(tokenList.get(2).intValue(), sym.INT_CONST);
	}

	/*
	 * Test to make sure the appropriate symbols are returned for a negative
	 * number To correctly use the test, input must be in the following format:
	 * -number
	 *
	@Test
	public void negativeNumTest() throws IOException {
		Lexer lexer = new Lexer(System.in);
		Symbol token;
		ArrayList<Integer> tokenList = new ArrayList<Integer>();
		System.out.print("input: ");
		for (int i = 0; i < 2; i++) {
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		}

		assertEquals(tokenList.get(0).intValue(), sym.UMINUS);
		assertEquals(tokenList.get(1).intValue(), sym.INT_CONST);
	}

	/*
	 * Test to make sure the appropriate symbols are returned for a
	 * parenthesized number To correctly use the test, input must be in the
	 * following format: (number)
	 *
	@Test
	public void parenthesesTest() throws IOException {
		Lexer lexer = new Lexer(System.in);
		Symbol token;
		ArrayList<Integer> tokenList = new ArrayList<Integer>();
		System.out.print("input: ");
		for (int i = 0; i < 3; i++) {
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		}

		assertEquals(tokenList.get(0).intValue(), sym.L_PAREN);
		assertEquals(tokenList.get(1).intValue(), sym.INT_CONST);
		assertEquals(tokenList.get(2).intValue(), sym.R_PAREN);
	}

	/*
	 * Test to make sure the appropriate symbols are returned for a comparison
	 * between two numbers. The comparison operators are <, <=, >, >=, !=, == To
	 * correctly use the test, input must be in the following format: number
	 * comparison_operator number. Use the operators in the order listed above
	 * for correct testing flow
	 * 
	 * NOTE: This does not test whether or not the comparison is being done
	 * correctly, it just makes sure the right symbols are being returned after
	 * the expression is parsed
	 *
	@Test
	public void comparisonOpTest() throws IOException {
		Lexer lexer = new Lexer(System.in);
		Symbol token;
		ArrayList<Integer> tokenList = new ArrayList<Integer>();

		// BEGIN - less than test
		System.out.print("input: ");
		for (int i = 0; i < 3; i++) {
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		}

		assertEquals(tokenList.get(0).intValue(), sym.INT_CONST);
		assertEquals(tokenList.get(1).intValue(), sym.LESS);
		assertEquals(tokenList.get(2).intValue(), sym.INT_CONST);
		// END - less than test

		// BEGIN - less than or equal test
		tokenList.clear(); // clear list before starting next test
		System.out.print("input: ");
		for (int i = 0; i < 3; i++) {
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		}

		assertEquals(tokenList.get(0).intValue(), sym.INT_CONST);
		assertEquals(tokenList.get(1).intValue(), sym.LESS_EQL);
		assertEquals(tokenList.get(2).intValue(), sym.INT_CONST);
		// END - less than or equal test

		// BEGIN - greater than test
		tokenList.clear();
		System.out.print("input: ");
		for (int i = 0; i < 3; i++) {
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		}

		assertEquals(tokenList.get(0).intValue(), sym.INT_CONST);
		assertEquals(tokenList.get(1).intValue(), sym.GRTR);
		assertEquals(tokenList.get(2).intValue(), sym.INT_CONST);
		// END - greater than test

		// BEGIN - greater than or equal test
		tokenList.clear();
		System.out.print("input: ");
		for (int i = 0; i < 3; i++) {
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		}

		assertEquals(tokenList.get(0).intValue(), sym.INT_CONST);
		assertEquals(tokenList.get(1).intValue(), sym.GRTR_EQL);
		assertEquals(tokenList.get(2).intValue(), sym.INT_CONST);
		// END - greater than or equal test

		// BEGIN - not equal test
		tokenList.clear();
		System.out.print("input: ");
		for (int i = 0; i < 3; i++) {
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		}

		assertEquals(tokenList.get(0).intValue(), sym.INT_CONST);
		assertEquals(tokenList.get(1).intValue(), sym.NOT_EQLS);
		assertEquals(tokenList.get(2).intValue(), sym.INT_CONST);
		// END - not equal test

		// BEGIN - equality test
		tokenList.clear();
		System.out.print("input: ");
		for (int i = 0; i < 3; i++) {
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		}

		assertEquals(tokenList.get(0).intValue(), sym.INT_CONST);
		assertEquals(tokenList.get(1).intValue(), sym.DBL_EQLS);
		assertEquals(tokenList.get(2).intValue(), sym.INT_CONST);
		// END - equality test

	}

	/*
	 * Test to make sure the appropriate symbols are returned for the postfix
	 * operators. The postfix operators are ++, -- To correctly use the test,
	 * input must be in the following format: variable++ or variable-- Use the
	 * operators in the order listed above for correct testing flow
	 *
	@Test
	public void postfixOpTest() throws IOException {
		Lexer lexer = new Lexer(System.in);
		Symbol token;
		ArrayList<Integer> tokenList = new ArrayList<Integer>();

		// BEGIN - postfix increment test
		System.out.print("input: ");
		for (int i = 0; i < 2; i++) {
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		}

		assertEquals(tokenList.get(0).intValue(), sym.ID);
		assertEquals(tokenList.get(1).intValue(), sym.INCR);
		// END - postfix increment test

		// BEGIN - postfix decrement test
		tokenList.clear();
		System.out.print("input: ");
		for (int i = 0; i < 2; i++) {
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		}

		assertEquals(tokenList.get(0).intValue(), sym.ID);
		assertEquals(tokenList.get(1).intValue(), sym.DECR);
		// END - postfix decrement test
	}

	/*
	 * Test to make sure the appropriate symbols are returned for the logical
	 * operators 'and', 'or' and 'not'. To correctly use the test, input must be
	 * in one of the following formats: variable and variable, variable or
	 * variable, not variable Use the operators in the order listed above for
	 * correct testing flow NOTE: This is only to test the correct parsing of
	 * expressions with a logical operator, not to confirm the validity of the
	 * result
	 *
	@Test
	public void logicalOpTest() throws IOException {
		Lexer lexer = new Lexer(System.in);
		Symbol token;
		ArrayList<Integer> tokenList = new ArrayList<Integer>();

		// BEGIN - logical 'and' test
		System.out.print("input: ");
		for (int i = 0; i < 3; i++) {
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		}

		assertEquals(tokenList.get(0).intValue(), sym.ID);
		assertEquals(tokenList.get(1).intValue(), sym.AND);
		assertEquals(tokenList.get(2).intValue(), sym.ID);
		// END - logical 'and' test

		// BEGIN - logical 'or' test
		tokenList.clear();
		System.out.print("input: ");
		for (int i = 0; i < 3; i++) {
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		}

		assertEquals(tokenList.get(0).intValue(), sym.ID);
		assertEquals(tokenList.get(1).intValue(), sym.OR);
		assertEquals(tokenList.get(2).intValue(), sym.ID);
		// END - logical 'or' test
	}*/
}
