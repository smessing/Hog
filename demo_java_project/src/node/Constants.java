// Technische Universitaet Muenchen 
// Fakultaet fuer Informatik 
// Riitta Hoellerer
//
// Praktikum des Uebersetzerbaus 
// SS 2001
//
// interface containing constants (for Lexer, IdentificationVisitor and 
// EmitCodeVisitor)
//

package node;

public interface Constants {

  public static final int INTTYPE  = 1;
  public static final int BOOLTYPE = 2;

  public static final int TRUE  = 1;
  public static final int FALSE = 0;
 
  public static final int PLUS  = 1;
  public static final int MINUS = 2;
  public static final int MULT  = 3;
  public static final int DIV   = 4;

  public static final int LESS_EQUAL    = 1;
  public static final int NOT_EQUAL     = 2;
  public static final int GREATER_EQUAL = 3;
  public static final int LESS          = 4;
  public static final int GREATER       = 5;
  public static final int EQUAL         = 6;


  public static final int VARIABLE    = 1;
  public static final int ARRAYVAR    = 2;
  public static final int PAR         = 3;
  public static final int VARPAR      = 4;
  public static final int ARRAYPAR    = 5;
  public static final int VARARRAYPAR = 6;
  public static final int PROCEDURE   = 7;
  public static final int PROGRAM     = 8; 
}
