// Technische Universitaet Muenchen 
// Fakultaet fuer Informatik 
// Riitta Hoellerer
//
// Praktikum des Uebersetzerbaus
// SS 2001
//
// mimalex.flex
// JFlex lexer specification for Mima
//  
// JFlex - The Fast Scanner Generator for Java
//  home page: 
// /usr/proj/uebbau/JFlex/
//

import node.Constants;
import java_cup.runtime.Symbol;

%%

%class Lexer
%cup
%implements sym, Constants
%line
%column

%{

  private Symbol symbol(int sym) {
    return new Symbol(sym, yyline+1, yycolumn+1);
  }
  
  private Symbol symbol(int sym, Object val) {
    return new Symbol(sym, yyline+1, yycolumn+1, val);
  }
  
  private void error(String message) {
    System.out.println("Error at line "+(yyline+1)+", column "+(yycolumn+1)+" : "+message);
  }
%} 

Ident = [a-zA-Z] [a-zA-Z0-9]*

IntLiteral = 0 | [1-9][0-9]*

new_line = \r|\n|\r\n;

white_space = {new_line} | [ \t\f]

%%


/* keywords */
"array"           {return symbol(ARRAY); }
"int"             { return symbol(TYPE, new Integer( INTTYPE ) ); }
"bool"            { return symbol(TYPE, new Integer( BOOLTYPE ) ); }
"program"         {return symbol(PROG); }
"proc"            {return symbol(PROC); }
"var"             {return symbol(VARSY); }

/* names */
{Ident}           { return symbol(IDENT, yytext()); }
  
/* literals */
{IntLiteral} { return symbol(INTCONST, new Integer(Integer.parseInt(yytext()))); }



/* separators */
","               { return symbol(COMMA); }
"("               { return symbol(LPAR); }
")"               { return symbol(RPAR); }
"{"               { return symbol(BEGIN); }
"}"               { return symbol(END); }
"+"               { return symbol(ADDOP, new Integer( PLUS ) ); }
"-"               { return symbol(ADDOP, new Integer( MINUS ) ); }
"*"               { return symbol(MULOP, new Integer( MULT ) ); }
"/"               { return symbol(MULOP, new Integer( DIV ) ); }



{white_space}     { /* ignore */ }


/* error fallback */
.|\n              {  /* throw new Error("Illegal character <"+ yytext()+">");*/
		    error("Illegal character <"+ yytext()+">");
                  }
