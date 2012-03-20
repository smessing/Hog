%{
#include <stdio.h>
%}

%token IDENTIFIER CONSTANT TEXT BOOL INT REAL LIST VOID
%token IN 
%token WHILE FOR FOREACH IF ELSE ELSEIF SWITCH
%token FUNCTION FUNCTIONS MAIN MAP REDUCE

%left '+' '-'
%left '*' '/'
%right UMINUS

%start start_symbol
%%

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

header
    : FUNCTIONS
    | MAP
    | REDUCE
    | MAIN
    ;


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
	
declaration
    : declaration_specifiers
    ;   
	
declaration_specifiers
    : type_specifier
	;
	
declaration_list
    : declaration
    | declaration_list declaration
    ;

statement_list
    : statement
    | statement_list statement
    ;

	
statement
    : expression_statement
    ;
	
expression_statement
    : '\n'
    | expression
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

   