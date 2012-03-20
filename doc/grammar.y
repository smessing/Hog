%{
#include <stdio.h>
%}

%token IDENTIFIER CONSTANT
%token TEXT BOOL 


%left '+' '-'
%left '*' '/'
%right UMINUS

%%
unary_operator
	: '-'
	| '!'
	;
	
declaration_list
	: declaration
	| declaration_list declaration
	;

statement_list
	: statement
	| statement_list statement
	;
