package front_end;

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
		Lexer lexer = new Lexer(System.in);
		Symbol token;
		
		do {
			try {
				token = lexer.next_token();
			} catch (Exception e) {
				throw new IOException("Error during lexer.yylex() call: ", e);
			}
			//System.out.println("token = " + token);
			switch (token.sym) {
			case sym.LESS_EQL:
				System.out.print("LESS_EQL ");
				break;
			case sym.MAP:
				System.out.print("MAP ");
				break;
			case sym.DIVIDE:
				System.out.print("DIVIDE ");
				break;
			case sym.CHAR:
				System.out.print("CHAR ");
				break;
			case sym.UMINUS:
				System.out.print("UMINUS ");
				break;
			case sym.L_PAREN:
				System.out.print("L_PAREN ");
				break;
			case sym.CASE:
				System.out.print("CASE ");
				break;
			case sym.R_PAREN:
				System.out.print("R_PAREN ");
				break;
			case sym.DECR:
				System.out.print("DECR ");
				break;
			case sym.INT:
				System.out.print("INT ");
				break;
			case sym.INCR:
				System.out.print("INCR ");
				break;
			case sym.FOR:
				System.out.print("FOR ");
				break;
			case sym.LESS:
				System.out.print("LESS ");
				break;
			case sym.MINUS:
				System.out.print("MINUS ");
				break;
			case sym.NOT:
				System.out.print("NOT ");
				break;
			case sym.AND:
				System.out.print("AND ");
				break;
			case sym.ELSEIF:
				System.out.print("ELSEIF ");
				break;
			case sym.IN:
				System.out.print("IN ");
				break;
			case sym.OR:
				System.out.print("OR ");
				break;
			case sym.COMMA:
				System.out.print("COMMA ");
				break;
			case sym.BOOL:
				System.out.print("BOOL ");
				break;
			case sym.SEMICOL:
				System.out.print("SEMICOL ");
				break;
			case sym.GRTR:
				System.out.print("GRTR ");
				break;
			case sym.PLUS:
				System.out.print("PLUS ");
				break;
			case sym.MAIN:
				System.out.print("MAIN ");
				break;
			case sym.IF:
				System.out.print("IF ");
				break;
			case sym.ASSIGN:
				System.out.print("ASSIGN ");
				break;
			case sym.GRTR_EQL:
				System.out.print("GRTR_EQL ");
				break;
			case sym.DOT:
				System.out.print("DOT ");
				break;
			case sym.ID:
				System.out.print("ID ");
				break;
			case sym.L_BRKT:
				System.out.print("L_BRKT ");
				break;
			case sym.EOF:
				System.out.print("EOF ");
				break;
			case sym.INT_CONST:
				System.out.print("INT_CONST ");
				break;
			case sym.error:
				System.out.print("<<<ERROR>>>");
				break;
			case sym.NEWLINE:
				System.out.print("NEWLINE ");
				break;
			case sym.R_BRKT:
				System.out.print("R_BRKT ");
				break;
			case sym.TEXT_LITERAL:
				System.out.print("TEXT_LITERAL ");
				break;
			case sym.MOD:
				System.out.print("MOD ");
				break;
			case sym.BREAK:
				System.out.print("BREAK ");
				break;
			case sym.VOID:
				System.out.print("VOID ");
				break;
			case sym.SWITCH:
				System.out.print("SWITCH ");
				break;
			case sym.COL:
				System.out.print("COL ");
				break;
			case sym.REAL:
				System.out.print("REAL ");
				break;
			case sym.TIMES:
				System.out.print("TIMES ");
				break;
			case sym.ARROW:
				System.out.print("ARROW ");
				break;
			case sym.L_BRACE:
				System.out.print("L_BRACE ");
				break;
			case sym.FOREACH:
				System.out.print("FOREACH ");
				break;
			case sym.ELSE:
				System.out.print("ELSE ");
				break;
			case sym.R_BRACE:
				System.out.print("R_BRACE ");
				break;
			case sym.FUNCTIONS:
				System.out.print("FUNCTIONS ");
				break;
			case sym.WHILE:
				System.out.print("WHILE ");
				break;
			case sym.LIST:
				System.out.print("LIST ");
				break;
			case sym.DEFAULT:
				System.out.print("DEFAULT ");
				break;
			case sym.REAL_CONST:
				System.out.print("REAL_CONST ");
				break;
			case sym.BOOL_CONST:
				System.out.print("BOOL_CONST ");
				break;
			case sym.TEXT:
				System.out.print("TEXT ");
				break;
			case sym.REDUCE:
				System.out.print("REDUCE ");
				break;
			case sym.NOT_EQLS:
				System.out.print("NOT_EQLS ");
				break;
			case sym.DBL_EQLS:
				System.out.print("DBL_EQLS ");
				break;
			case sym.RETURN:
				System.out.print("RETURN ");
				break;
			}
		} while (token != null);
	}
}
