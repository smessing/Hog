%{
#include <stdio.h>
%}

%token IDENTIFIER CONSTANT
%token TEXT BOOL INT REAL
%token 

%left '+' '-'
%left '*' '/'
%right UMINUS

%%
unary_operator
	: '-'
	| '!'
	;
	
type_specifier
    : VOID
	| TEXT
	| BOOL
	| INT
	| REAL
	
	
declaration_list
	: declaration
	| declaration_list declaration
	;

statement_list
	: statement
	| statement_list statement
	;

expression_statement
    : '\n'
    | expression
	;
	
selection-statement:
   : if ( expression ) statement
   | if ( expression ) statement else statement
   | if ( expression ) statement elseif ( expression ) statement... else statement
   | switch ( expression ) statement if ( expression ) statement
   | switch ( expression ) statement
   ; 