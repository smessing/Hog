/** The lexer for scanning command tokens. */
%%

%class Lexer

Parameter = [:jletterdigit:]+
WhiteSpace = [ \n\t\f]

%%

"#{"       { comment(); }

[:digit:]+ { return new Yytoken(Integer.parseInt(yytext())); }
{Parameter} { return new Yytoken(yytext()); }
{WhiteSpace} { /* Ignore Whitespace */ }
"-" { return new Yytoken('-'); }
"," { return new Yytoken(','); }

%%

yywrap()
{
  return(1);
}


comment()
{
  char c, c1;

loop:
  while ((c = input()) != '}' && c != 0)
    putchar(c);

  if ((c1 = input()) != '#' && c != 0)
  {
    unput(c1);
    goto loop;
  }

  if (c != 0)
    putchar(c1);
}