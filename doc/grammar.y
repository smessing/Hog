%{
#include <stdio.h>
%}

%token IDENTIFIER CONSTANT TEXT BOOL INT REAL LIST VOID
%token IN AND OR
%token WHILE FOR FOREACH IF ELSE ELSEIF SWITCH
%token FUNCTION FUNCTIONS MAIN MAP REDUCE

%left '+' '-'
%left '*' '/'
%right UMINUS

%start start_symbol
%%


start_symbol
    : functions map reduce main
	| /* epsilon */
	;

functions
    : FUNCTION statement_list
    ;
    
map
    : MAP statement_list
    ;
    
reduce
    : REDUCE statement_list
    ;

main
    : MAIN statement_list
    ; 
    

statement_list
    : statement
    | statement_list statement
    ;

	
statement
    : expression_statement
    | iteration_statement
    | selection_statement
    | declarator
    ;
	
expression_statement
    : '\n'
    | expression
    ;
    
expression
    : IDENTIFIER
	| CONSTANT
	| TEXT
	| '(' expression ')'
	;

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
    ;
    
declarator
    : IDENTIFIER
    | '(' declarator ')'    
    ;
    
declaration_list
    : declaration
    | declaration_list declaration
    ;
  	
declaration
    : declaration_specifiers
    ;   

declaration_specifiers
    : type_specifier
	;
		
selection_statement
    : IF '(' expression ')' statement
    | IF '(' expression ')' statement elseif_statement ELSE statement
    | SWITCH '(' expression ')' statement IF '(' expression ')' statement
    | SWITCH '(' expression ')' statement
    ; 

elseif_statement
    : ELSEIF '(' expression ')' elseif_statement
	| /* epsilon */
	;
   
iteration_statement 
    : WHILE '(' expression ')' statement
    | FOR '(' expression ';' expression ';' expression ')' statement
    | FOREACH '(' expression IN LIST ')' statement
    ;

   