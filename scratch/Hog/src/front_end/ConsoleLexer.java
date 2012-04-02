package front_end;

import java.io.IOException;

import java_cup.runtime.Symbol;
import front_end.*;

@SuppressWarnings("unused")
public class ConsoleLexer {

  /**
  * @param args
  * */
  public static void main(String[] args) throws IOException {
    Lexer lexer = new Lexer(System.in);
    Parser parser = new Parser(lexer);
    Symbol token;
    System.out.println("test");
    do {
      try {
        token = parser.scan();
      } catch (Exception e) {
        throw new IOException("Error during lexer.yylex() call: ", e);
      }
        System.out.println("token = " + token);
    } while (token != null);
    System.out.println("test");
  }
}
