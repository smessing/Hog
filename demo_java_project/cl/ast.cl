// Technische Universitaet Muenchen 
// Fakultaet fuer Informatik 
// Riitta Hoellerer
//
// Praktikum des Uebersetzerbaus
// SS 2001
//
//  mimaAST.cl 
//  Classgen Abctract Syntax Tree Specification for Mima 
//
//  home page:
//  /usr/proj/uebbau/classgen-1.1/
//


package node;

attr "boolean" istvarParam, istformParam with Dekl;
attr DeklInfo deklinfo with Id_Seq, Var;

Prog ::= "String":ident  Proc_Dekl_Seq  Block


Proc_Dekl_Seq ::= Proc_Dekl Proc_Dekl_Seq
                | /* leere Sequenz */

Proc_Dekl     ::= "String":ident Form_Par_Seq Block

Form_Par_Seq ::= Form_Par Form_Par_Seq
               | /* leere Sequenz */

Form_Par     ::= { Param }     Var_Dekl
               |  { Var_Param } Var_Dekl
             
Var_Dekl     ::= { Variable }  Typ  Id_Seq:id_Seq
               |  { Array_Variable } "int":laenge Typ Id_Seq:id_Seq

Typ      ::=    "int":typ  // Basistypen int und boolean (als 1 und 2 codiert)
              
Block    ::= Dekl_Seq  Anw_Seq

Dekl_Seq ::= Dekl Dekl_Seq
           | /* leere Sequenz */

Dekl     ::= { Var_Dekl }   
           

Id_Seq   ::= "String":ident Id_Seq
           | "String":ident 
          

Anw_Seq ::= Anw Anw_Seq
          | Anw

Anw     ::= Ausdr   


Ausdr     ::= {BinAusdr}  Ausdr "int":op Ausdr
            | {IntAusdr}  "int":value
            | {VarAusdr}  Var

Var        ::= {IdentAusdr}   "String":ident
            |  {ArrayAusdr}   "String":ident Ausdr:index  

