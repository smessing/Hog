%{
#include <stdio.h>
%}

%token UMINUS DECR INCR
%token ID CONSTANT TEXT BOOL INT REAL LIST VOID
%token IN AND OR NOT
%token WHILE FOR FOREACH IF ELSE ELSEIF SWITCH
%token FUNCTION FUNCTIONS MAIN MAP REDUCE

%left AND OR
%right NOT

%left '+' '-'
%left '*' '/'
%right UMINUS
%left DECR
%left INCR

%start program
%%


program
    : functions map reduce main
    ;

functions
    : FUNCTION '{' function_list '}'
    | /* epsilon */
    ;

function_list
    : function
    | function_list function
    ;

function
    : type ID '(' parameter_list ')' '{' statement_list '}'
    ;

map
    : MAP section_type '{' statement_list '}'
    ;
    
reduce
    : REDUCE section_type '{' statement_list '}'
    ;

section_type
    : '(' type ID ',' type ID ')' '-' '>' '(' type ',' type ')'
    ;

main
    : MAIN '{' statement_list '}'
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
    : ID
	| CONSTANT
	| TEXT
	| '(' expression ')'
	;

unary_operator
    : '-'
    | NOT
    ;
	
type
    : VOID
    | TEXT
    | BOOL
    | INT
    | REAL
    ;
    
declarator
    : ID
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
    : type
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

   
