package front_end;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import java_cup.runtime.Symbol;

import org.junit.Test;

public class LexerTester {

	
	/*
	 * Test to make sure the appropriate symbols are returned
	 * for the addition of two numbers.
	 * To correctly use the test, input must be in the following format:
	 * number + number
	 * NOTE: This does not test whether or not the addition is being
	 * done correctly, it just makes sure the right symbols are being
	 * returned after the expression is parsed
	 */
	@Test
	public void additionSymbolTest() throws IOException {
		Lexer lexer = new Lexer(System.in);
		Symbol token;
		ArrayList<Integer> tokenList = new ArrayList<Integer>();
		System.out.print("input: ");
		for(int i = 0; i < 3; i++){
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		} 
		
		assertEquals(tokenList.get(0).intValue(), sym.INT_CONST);
		assertEquals(tokenList.get(1).intValue(), sym.PLUS);
		assertEquals(tokenList.get(2).intValue(), sym.INT_CONST);
	}
	
	/*
	 * Test to make sure the appropriate symbols are returned
	 * for the subtraction of two numbers.
	 * To correctly use the test, input must be in the following format:
	 * number - number
	 * NOTE: This does not test whether or not the subtraction is being
	 * done correctly, it just makes sure the right symbols are being
	 * returned after the expression is parsed
	 */
	@Test
	public void subtractionSymbolTest() throws IOException {
		Lexer lexer = new Lexer(System.in);
		Symbol token;
		ArrayList<Integer> tokenList = new ArrayList<Integer>();
		System.out.print("input: ");
		for(int i = 0; i < 3; i++){
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
	 * Test to make sure the appropriate symbols are returned
	 * for the division of two numbers.
	 * To correctly use the test, input must be in the following format:
	 * number / number
	 * NOTE: This does not test whether or not the division is being
	 * done correctly, it just makes sure the right symbols are being
	 * returned after the expression is parsed
	 */
	@Test
	public void divisionSymbolTest() throws IOException {
		Lexer lexer = new Lexer(System.in);
		Symbol token;
		ArrayList<Integer> tokenList = new ArrayList<Integer>();
		System.out.print("input: ");
		for(int i = 0; i < 3; i++){
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
	 * Test to make sure the appropriate symbols are returned
	 * for the multiplication of two numbers.
	 * To correctly use the test, input must be in the following format:
	 * number * number
	 * NOTE: This does not test whether or not the multiplication is being
	 * done correctly, it just makes sure the right symbols are being
	 * returned after the expression is parsed
	 */
	@Test
	public void multiplicationSymbolTest() throws IOException {
		Lexer lexer = new Lexer(System.in);
		Symbol token;
		ArrayList<Integer> tokenList = new ArrayList<Integer>();
		System.out.print("input: ");
		for(int i = 0; i < 3; i++){
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
	 * Test to make sure the appropriate symbols are returned
	 * for a negative number
	 * To correctly use the test, input must be in the following format:
	 * -number
	 */
	@Test
	public void negativeNumTest() throws IOException {
		Lexer lexer = new Lexer(System.in);
		Symbol token;
		ArrayList<Integer> tokenList = new ArrayList<Integer>();
		System.out.print("input: ");
		for(int i = 0; i < 2; i++){
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
	 * Test to make sure the appropriate symbols are returned
	 * for a parenthesized number
	 * To correctly use the test, input must be in the following format:
	 * (number)
	 */
	@Test
	public void parenthesesTest() throws IOException {
		Lexer lexer = new Lexer(System.in);
		Symbol token;
		ArrayList<Integer> tokenList = new ArrayList<Integer>();
		System.out.print("input: ");
		for(int i = 0; i < 3; i++){
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
	 * Test to make sure the appropriate symbols are returned
	 * for a comparison between two numbers.
	 * The comparison operators are <, <=, >, >=, !=, ==
	 * To correctly use the test, input must be in the following format:
	 * number comparison_operator number.
	 * Use the operators in the order listed above for correct testing flow
	 * 
	 * NOTE: This does not test whether or not the comparison is being
	 * done correctly, it just makes sure the right symbols are being
	 * returned after the expression is parsed
	 */
	@Test
	public void comparisonOpTest() throws IOException {
		Lexer lexer = new Lexer(System.in);
		Symbol token;
		ArrayList<Integer> tokenList = new ArrayList<Integer>();
		
		//BEGIN - less than test
		System.out.print("input: ");
		for(int i = 0; i < 3; i++){
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
		//END - less than test
		
		//BEGIN - less than or equal test
		tokenList.clear(); //clear list before starting next test
		System.out.print("input: ");
		for(int i = 0; i < 3; i++){
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
		//END - less than or equal test
		
		//BEGIN - greater than test
		tokenList.clear();
		System.out.print("input: ");
		for(int i = 0; i < 3; i++){
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
		//END - greater than test
		
		//BEGIN - greater than or equal test
		tokenList.clear();
		System.out.print("input: ");
		for(int i = 0; i < 3; i++){
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
		//END - greater than or equal test
		
		//BEGIN - not equal test
		tokenList.clear();
		System.out.print("input: ");
		for(int i = 0; i < 3; i++){
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
		//END - not equal test
		
		//BEGIN - equality test
		tokenList.clear();
		System.out.print("input: ");
		for(int i = 0; i < 3; i++){
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
		//END - equality test
		
	}
	
	/*
	 * Test to make sure the appropriate symbols are returned
	 * for the postfix operators. The postfix operators are ++, --
	 * To correctly use the test, input must be in the following format:
	 * variable++ or variable--
	 * Use the operators in the order listed above for correct testing flow
	 */
	@Test
	public void postfixOpTest() throws IOException {
		Lexer lexer = new Lexer(System.in);
		Symbol token;
		ArrayList<Integer> tokenList = new ArrayList<Integer>();
		
		//BEGIN - postfix increment test
		System.out.print("input: ");
		for(int i = 0; i < 2; i++){
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		} 
		
		assertEquals(tokenList.get(0).intValue(), sym.ID);
		assertEquals(tokenList.get(1).intValue(), sym.INCR);
		//END - postfix increment test
		
		//BEGIN - postfix decrement test
		tokenList.clear();
		System.out.print("input: ");
		for(int i = 0; i < 2; i++){
			try {
				token = lexer.next_token();
				tokenList.add(token.sym);
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
		} 
				
		assertEquals(tokenList.get(0).intValue(), sym.ID);
		assertEquals(tokenList.get(1).intValue(), sym.DECR);
		//END - postfix decrement test
	}
}
