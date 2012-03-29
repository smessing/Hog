/*-***
 *
 * This file defines a stand-alone lexical analyzer for a subset of the Pascal
 * programming language.  This is the same lexer that will later be integrated
 * with a CUP-based parser.  Here the lexer is driven by the simple Java test
 * program in ./PascalLexerTest.java, q.v.  See 330 Lecture Notes 2 and the
 * Assignment 2 writeup for further discussion.
 *
 */


import java_cup.runtime.*;
import parser.Symbol;


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
and             { return newSym(Symbol.AND); }
array           { return newSym(Symbol.ARRAY); }
begin           { return newSym(Symbol.BEGIN); }
else            { return newSym(Symbol.ELSE); }
end             { return newSym(Symbol.END); }
if              { return newSym(Symbol.IF); }
of              { return newSym(Symbol.OF); }
or              { return newSym(Symbol.OR); }
program         { return newSym(Symbol.PROGRAM); }
procedure       { return newSym(Symbol.PROCEDURE); }
then            { return newSym(Symbol.THEN); }
type            { return newSym(Symbol.TYPE); }
var             { return newSym(Symbol.VAR); }
"*"             { return newSym(Symbol.TIMES); }
"+"             { return newSym(Symbol.PLUS); }
"-"             { return newSym(Symbol.MINUS); }
"/"             { return newSym(Symbol.DIVIDE); }
";"             { return newSym(Symbol.SEMI); }
","             { return newSym(Symbol.COMMA); }
"("             { return newSym(Symbol.LEFT_PAREN); }
")"             { return newSym(Symbol.RT_PAREN); }
"["             { return newSym(Symbol.LEFT_BRKT); }
"]"             { return newSym(Symbol.RT_BRKT); }
"="             { return newSym(Symbol.EQ); }
"<"             { return newSym(Symbol.GTR); }
">"             { return newSym(Symbol.LESS); }
"<="            { return newSym(Symbol.LESS_EQ); }
">="            { return newSym(Symbol.GTR_EQ); }
"!="            { return newSym(Symbol.NOT_EQ); }
":"             { return newSym(Symbol.COLON); }
":="            { return newSym(Symbol.ASSMNT); }
"."             { return newSym(Symbol.DOT); }
{identifier}    { return newSym(Symbol.IDENT, yytext()); }
{integer}       { return newSym(Symbol.INT, new Integer(yytext())); }
{real}          { return newSym(Symbol.REAL, new Double(yytext())); }
{char}          { return newSym(Symbol.CHAR, new Character(yytext().charAt(1))); }
{comment}       { /* For this stand-alone lexer, print out comments. */
                  System.out.println("Recognized comment: " + yytext()); }
{whitespace}    { /* Ignore whitespace. */ }
.               { System.out.println("Illegal char, '" + yytext() +
                    "' line: " + yyline + ", column: " + yychar); }