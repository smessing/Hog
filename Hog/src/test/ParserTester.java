package test;

import static org.junit.Assert.*;

import java.io.StringReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import front_end.Lexer;
import front_end.Parser;

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
		String text = "@Map (int lineNum, text line) -> (text, int) {   #{ this is a        block comment }#   int count = 1;   dict<int, real> face;   real face = 1.0;   foreach word in line.tokenize(\\\" \\\") {     emit(word, 1);   }   if (count == 2) {     print('count equals 2!');   } elseif (count == 3) {     print('count equals 3!');   } else {     int face = 0;     int x = face + 1;     face++;     print('count equals something else');   }     list<int> face;   try {     face.get(0);   } catch (FileNotFoundException  exception) {     print(exception);   } catch (ArrayOutOfBoundsException exception) {     print (exception);   }   for (int i = 0; i < 4; i++;) {     print(i);   } } @Reduce (text word, iter<int> values) -> (text, int) {   int count = 0;   while ( values.hasNext() ) {     count = count + values.next();   }   emit(count, word); } @Main {   mapReduce(); }";
		StringReader stringReader = new StringReader(text);
		Lexer lexer = new Lexer(stringReader);
		Parser parser = new Parser(lexer);
		ProgramNode root = (ProgramNode) parser.parse().value;
	}

}
