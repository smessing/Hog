import java_cup.runtime.*;
import hog_parser.Symbols;


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
and             { return newSym(Symbols.AND); }
else            { return newSym(Symbols.ELSE); }
elseif          { return newSym(Symbols.ELSEIF); }
if              { return newSym(Symbols.IF); }
or              { return newSym(Symbols.OR); }
@Functions      { return newSym(Symbols.FUNCTIONS); }
@Map            { return newSym(Symbols.MAP); }
@Reduce         { return newSym(Symbols.REDUCE); }
@Main           { return newSym(Symbols.MAIN); }
then            { return newSym(Symbols.THEN); }
type            { return newSym(Symbols.TYPE); }
var             { return newSym(Symbols.VAR); }
"*"             { return newSym(Symbols.TIMES); }
"+"             { return newSym(Symbols.PLUS); }
"-"             { return newSym(Symbols.MINUS); }
"/"             { return newSym(Symbols.DIVIDE); }
"%"             { return newSym(Symbols.MOD); }
";"             { return newSym(Symbols.SEMICOL); }
","             { return newSym(Symbols.COMMA); }
"("             { return newSym(Symbols.L_PAREN); }
")"             { return newSym(Symbols.R_PAREN); }
"{"             { return newSym(Symbols.L_BRACE); }
"}"             { return newSym(Symbols.R_BRACE); }
"["             { return newSym(Symbols.L_BRKT); }
"]"             { return newSym(Symbols.R_BRKT); }
"="             { return newSym(Symbols.ASSIGN); }
"<"             { return newSym(Symbols.GRTR); }
">"             { return newSym(Symbols.LESS); }
"<="            { return newSym(Symbols.LESS_EQL); }
">="            { return newSym(Symbols.GRTR_EQ); }
"!="            { return newSym(Symbols.NOT_EQS); }
":"             { return newSym(Symbols.COL); }
"=="            { return newSym(Symbols.DBL_EQLS); }
"."             { return newSym(Symbols.DOT); }
{identifier}    { return newSym(Symbols.IDENT, yytext()); }
{integer}       { return newSym(Symbols.INT, new Integer(yytext())); }
{real}          { return newSym(Symbols.REAL, new Double(yytext())); }
{char}          { return newSym(Symbols.CHAR, new Character(yytext().charAt(1))); }
{comment}       { /* For this stand-alone lexer, print out comments. */
                  System.out.println("Recognized comment: " + yytext()); }
{whitespace}    { /* Ignore whitespace. */ }
.               { System.out.println("Illegal char, '" + yytext() +
                    "' line: " + yyline + ", column: " + yychar); }