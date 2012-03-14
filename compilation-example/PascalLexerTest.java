/****
 *
 * This is a simple stand-alone testing program for the Pascal lexer defined in
 * PascalLexer.JFLex.  The main method accepts an input file as its first
 * command-line argument.  It then calls the lexer's next_token method with an
 * input reader for that file.  The value of each Symbol returned by next_token
 * is printed to stanard output.
 *                                                                      <p> 
 * The following command-line invocation will read in the test program in the
 * file "lexer-test.p" and print out each token found in that file:
 *
 *     java PascalLexerTest lexer-test.p
 *
 */

import java.io.*;
import java_cup.runtime.*;

public class PascalLexerTest {

    public static void main(String[] args) {
        Symbol sym;
        try {
            PascalLexer lexer = new PascalLexer(new FileReader(args[0]));
            for (sym = lexer.next_token(); sym.sym != 0;
                    sym = lexer.next_token()) {

                System.out.println("Token " + sym +
                    ", with value = " + sym.value + 
                    "; at line " + sym.left + ", column " + sym.right);

            }
        }
        catch (Exception e) {
        }
    }
}
