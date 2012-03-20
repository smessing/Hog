%{
#include <stdio.h>
%}

%token FALSE TRUE
%token UMINUS DECR INCR
%token ID CONST TEXT BOOL INT REAL LIST VOID
%token TEXT_LITERAL
%token IN AND OR NOT
%token WHILE FOR FOREACH IF ELSE ELSEIF SWITCH
%token FUNCTION FUNCTIONS MAIN MAP REDUCE

%left OR
%left AND
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

parameter_list
    : type ID ',' parameter_list
    | type ID
    | /* epsilon */
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
    | expression '\n'
    ;

expression
    : logical_expression
    | unary_expression '=' assignment_expression
    ;

logical_expression
    : expression OR logical_term
    | logical_term
    ;

logical_term
    : logical_term AND logical_factor
    | logical_factor
    ;

logical_factor
    : NOT logical_factor
    | '(' logical_expression ')'
    | TRUE
    | FALSE
    ;

unary_expression
    : postfix_expression
    | cast_expression
    ;

postfix_expression
    : primary_expression
    | postfix_expression INCR
    | postfix_expression DECR
    ;

primary_expression
    : ID
    | CONST
    | TEXT_LITERAL

cast_expression
    : unary_expression
    | '(' type ')' cast_expression
    ;

conditional_expression
    : logical_and_expression
    | conditional_expression 'or' logical_and_expression
    ;

logical_and_expression:
    : inclusive_or_expression
    | 

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

   
