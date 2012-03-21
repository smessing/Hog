%{
#include <stdio.h>
%}

%token UMINUS DECR INCR
%token MINUS PLUS TIMES DIVIDE MOD
%token LESS GRTR LESS_EQL GRTR_EQL DBL_EQLS NOT_EQLS ASSIGN
%token TEXT BOOL INT REAL LIST VOID
%token ARROW DOT
%token TEXT_LITERAL ID INT_CONST REAL_CONST BOOL_CONST
%token BREAK CASE DEFAULT
%token IN AND OR NOT
%token WHILE FOR FOREACH IF ELSE ELSEIF SWITCH
%token FUNCTION MAIN MAP REDUCE

%left OR
%left AND
%right NOT

%left MINUS PLUS
%left TIMES DIVIDE
%left MOD
%right UMINUS
%left DECR INCR

%nonassoc LESS GRTR LESS_EQL GRTR_EQL DBL_EQLS NOT_EQLS
%right ASSIGN

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
    : '(' type ID ',' type ID ')' ARROW '(' type ',' type ')'
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
    | selection_statement
    | iteration_statement
    | labeled_statement
    | BREAK
    ;

expression_statement
    : '\n'
    | expression '\n'
    ;

expression
    : logical_expression
    | unary_expression ASSIGN expression
    ;

logical_expression
    : logical_expression OR logical_term
    | logical_term
    ;

logical_term
    : logical_term AND equality_expression
    | equality_expression
    ;

equality_expression
    : relational_expression
    | equality_expression DBL_EQLS relational_expression
    | equality_expression NOT_EQLS relational_expression
    ;

relational_expression
    : additive_expression
    | relational_expression LESS additive_expression
    | relational_expression GRTR additive_expression
    | relational_expression LESS_EQL additive_expression
    | relational_expression GRTR_EQL additive_expression
    ;

additive_expression
    : multiplicative_expression
    | additive_expression PLUS multiplicative_expression
    | additive_expression MINUS multiplicative_expression
    ;

multiplicative_expression
    : cast_expression
    | multiplicative_expression TIMES cast_expression
    | multiplicative_expression DIVIDE cast_expression
    | multiplicative_expression MOD cast_expression
    ;

cast_expression
    : unary_expression
    | '(' type ')' cast_expression
    ;

unary_expression
    : UMINUS cast_expression
    | NOT cast_expression
    | postfix_expression
    ;

postfix_expression
    : primary_expression
    | postfix_expression INCR
    | postfix_expression DECR
    ;

primary_expression
    : ID
    | ID DOT ID '(' parameters ')'
    | constant
    | TEXT_LITERAL
    | '(' expression ')'
    ;

parameters
    : ID
    | ID ',' parameters
    ;

constant
   : INT_CONST
   | REAL_CONST
   | BOOL_CONST
   ;

selection_statement
    : IF '(' expression ')' statement elseif_statement else_statement
    | SWITCH '(' expression ')' statement
    ; 

elseif_statement
    : ELSEIF '(' expression ')' elseif_statement
    | /* epsilon */
    ;

else_statement
    : ELSE statement
    | /* epsilon */
    ;

iteration_statement 
    : WHILE '(' expression ')' statement
    | FOR '(' expression ';' expression ';' expression ')' statement
    | FOREACH '(' expression IN expression ')' statement
    ;

labeled_statement
    : CASE ':' statement
    | DEFAULT ':' statement
    ;

type
    : VOID
    | TEXT
    | BOOL
    | INT
    | REAL
    ;