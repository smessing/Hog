package front_end;

import java_cup.runtime.*;
import util.ast.node.ExceptionTypeNode;
import util.type.Types;

%%
/**
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


/**
 * PATTERN DEFINITIONS:
 */
letter          = [A-Za-z]
digit           = [0-9]
alphanumeric    = {letter}|{digit}
other_id_char   = [_]
text_literal_old    = [a-zA-Z_ ]?\"(\\.|[^\\'])*\" 
text_literal       = \".*\"
identifier      = {letter}({alphanumeric}|{other_id_char})*
integer         = {digit}*
real            = {integer}\.{integer}
commentlbrace   = \#\{
commentrbrace   = \}\#
nonrightbrace   = [^}]
comment_body    = {nonrightbrace}*
comment         = ({commentlbrace}{comment_body}{commentrbrace}|\#.*\n)
newline         = [\n]+
whitespace      = [ \t]


%%
/**
 * LEXICAL RULES:
 */
and             { return newSym(sym.AND); }
else            { return newSym(sym.ELSE); }
elseif          { return newSym(sym.ELSEIF); }
if              { return newSym(sym.IF); }
or              { return newSym(sym.OR); }
foreach         { return newSym(sym.FOREACH); }
for             { return newSym(sym.FOR); }
while           { return newSym(sym.WHILE); }
in              { return newSym(sym.IN); }
text            { return newSym(sym.TEXT); }
bool            { return newSym(sym.BOOL); }
int             { return newSym(sym.INT); }
real            { return newSym(sym.REAL); }
list            { return newSym(sym.LIST); }
void            { return newSym(sym.VOID); }
not             { return newSym(sym.NOT); }
switch          { return newSym(sym.SWITCH); }
case            { return newSym(sym.CASE); }
default         { return newSym(sym.DEFAULT); }
continue        { return newSym(sym.CONTINUE); }
return          { return newSym(sym.RETURN); }
iter            { return newSym(sym.ITER); }
try             { return newSym(sym.TRY); }
catch           { return newSym(sym.CATCH); }
@Functions      { return newSym(sym.FUNCTIONS); }
@Map            { return newSym(sym.MAP); }
@Reduce         { return newSym(sym.REDUCE); }
@Main           { return newSym(sym.MAIN); }
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
"->"            { return newSym(sym.ARROW); }
"--"            { return newSym(sym.DECR); }
"++"            { return newSym(sym.INCR); }
"="             { return newSym(sym.ASSIGN); }
"<"             { return newSym(sym.LESS); }
">"             { return newSym(sym.GRTR); }
"<="            { return newSym(sym.LESS_EQL); }
">="            { return newSym(sym.GRTR_EQL); }
"!="            { return newSym(sym.NOT_EQLS); }
":"             { return newSym(sym.COL); }
"=="            { return newSym(sym.DBL_EQLS); }
"."             { return newSym(sym.DOT); }
{text_literal}  { return newSym(sym.TEXT_LITERAL, new String(yytext())); }
true            { return newSym(sym.BOOL_CONST, new String("true")); }
false           { return newSym(sym.BOOL_CONST, new String("false")); }
return          { return newSym(sym.RETURN); }
FileNotFoundException { return newSym(sym.EXCEPTION, new ExceptionTypeNode(Types.Exception.FILE_NOT_FOUND)); }
FileLoadException  { return newSym(sym.EXCEPTION, new ExceptionTypeNode(Types.Exception.FILE_LOAD)); }
ArrayOutOfBoundsException { return newSym(sym.EXCEPTION, new ExceptionTypeNode(Types.Exception.ARRAY_OUT_OF_BOUNDS)); } 
IncorrectArgumentException { return newSym(sym.EXCEPTION, new ExceptionTypeNode(Types.Exception.INCORRECT_ARGUMENT)); }
TypeMismatchException { return newSym(sym.EXCEPTION, new ExceptionTypeNode(Types.Exception.TYPE_MISMATCH)); }
NullReferenceException { return newSym(sym.EXCEPTION, new ExceptionTypeNode(Types.Exception.NULL_REFERENCE)); }
ArtihmeticException { return newSym(sym.EXCEPTION, new ExceptionTypeNode(Types.Exception.ARITHMETIC)); }
{integer}       { return newSym(sym.INT_CONST, new String(yytext())); }
{real}          { return newSym(sym.REAL_CONST, new String(yytext())); }
{comment}       { /* For this stand-alone lexer, print out comments. */
                  System.out.println("Recognized comment: " + yytext()); }
{newline}       { /* Ignore newlines. */ }
{whitespace}    { /* Ignore whitespace. */ }
{identifier}    { return newSym(sym.ID, new String(yytext())); }
.               { System.out.println("Illegal char, '" + yytext() +
                    "' line: " + yyline + ", column: " + yychar); }