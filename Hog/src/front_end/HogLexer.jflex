package front_end;

import java_cup.runtime.*;

%%
/*-*
 * LEXICAL FUNCTIONS:
 */

%cup
%line
%column
%unicode
%class Lexer

%{

/**
 * Return a new Symbol with the given token id, and with the current line and
 * column numbers.
 */
Symbol newSym(int tokenId) {
    return new Symbol(tokenId, yyline, yycolumn);
}

/**
 * Return a new Symbol with the given token id, the current line and column
 * numbers, and the given token value.  The value is used for tokens such as
 * identifiers and numbers.
 */
Symbol newSym(int tokenId, Object value) {
    return new Symbol(tokenId, yyline, yycolumn, value);
}

%}


/*-*
 * PATTERN DEFINITIONS:
 */
letter          = [A-Za-z]
digit           = [0-9]
alphanumeric    = {letter}|{digit}
other_id_char   = [_]
identifier      = {letter}({alphanumeric}|{other_id_char})*
integer         = {digit}*
real            = {integer}\.{integer}
char            = '.'
leftbrace       = \{
rightbrace      = \}
nonrightbrace   = [^}]
comment_body    = {nonrightbrace}*
comment         = {leftbrace}{comment_body}{rightbrace}
whitespace      = [ \n\t]


%%
/**
 * LEXICAL RULES:
 */
and             { return newSym(sym.AND); }
else            { return newSym(sym.ELSE); }
elseif          { return newSym(sym.ELSEIF); }
if              { return newSym(sym.IF); }
or              { return newSym(sym.OR); }
@Functions      { return newSym(sym.FUNCTIONS); }
@Map            { return newSym(sym.MAP); }
@Reduce         { return newSym(sym.REDUCE); }
@Main           { return newSym(sym.MAIN); }
then            { return newSym(sym.THEN); }
type            { return newSym(sym.TYPE); }
var             { return newSym(sym.VAR); }
"*"             { return newSym(sym.TIMES); }
"+"             { return newSym(sym.PLUS); }
"-"             { return newSym(sym.MINUS); }
"/"             { return newSym(sym.DIVIDE); }
"%"             { return newSym(sym.MOD); }
";"             { return newSym(sym.SEMICOL); }
","             { return newSym(sym.COMMA); }
"("             { return newSym(sym.L_PAREN); }
")"             { return newSym(sym.R_PAREN); }
"{"             { return newSym(sym.L_BRACE); }
"}"             { return newSym(sym.R_BRACE); }
"["             { return newSym(sym.L_BRKT); }
"]"             { return newSym(sym.R_BRKT); }
"="             { return newSym(sym.ASSIGN); }
"<"             { return newSym(sym.GRTR); }
">"             { return newSym(sym.LESS); }
"<="            { return newSym(sym.LESS_EQL); }
">="            { return newSym(sym.GRTR_EQL); }
"!="            { return newSym(sym.NOT_EQS); }
":"             { return newSym(sym.COL); }
"=="            { return newSym(sym.DBL_EQLS); }
"."             { return newSym(sym.DOT); }
{identifier}    { return newSym(sym.IDENT, yytext()); }
{integer}       { return newSym(sym.INT, new Integer(yytext())); }
{real}          { return newSym(sym.REAL, new Double(yytext())); }
{char}          { return newSym(sym.CHAR, new Character(yytext().charAt(1))); }
{comment}       { /* For this stand-alone lexer, print out comments. */
                  System.out.println("Recognized comment: " + yytext()); }
{whitespace}    { /* Ignore whitespace. */ }
.               { System.out.println("Illegal char, '" + yytext() +
                    "' line: " + yyline + ", column: " + yychar); }