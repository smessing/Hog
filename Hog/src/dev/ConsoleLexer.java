package dev;

import java.io.IOException;
import front_end.*;

@SuppressWarnings("unused")
public class ConsoleLexer {

  /**
  * @param args
  * */
  public static void main(String[] args) throws IOException {
    Lexer lexer = new Lexer(System.in);

    do {
      try {
        token = lexer.next_token();
      } catch (IOException ioe) {
        throw new IOException("Error during lexer.yylex() call: ", ioe);
      }
        System.out.println("token = " + token);
    } while (token != null);
        System.out.println("test face");
  }
}
