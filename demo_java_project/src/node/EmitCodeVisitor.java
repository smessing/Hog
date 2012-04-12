
// Technische Universitaet Muenchen 
// Fakultaet fuer Informatik 
// Riitta Hoellerer
//
// Praktikum des Uebersetzerbaus
// SS 2001"
//
//  EmitCodeVisitor.java
//  emits Jasmin code
//


package node;
import java.util.*;


public class EmitCodeVisitor extends VisitorAdaptor implements Constants{




// 
// visit methods:
// 

  public void visit(BinAusdr binAusdr) {
    String oper; 
    switch ( binAusdr.op ) {   
        case PLUS:   
                  { oper = "iadd"; break; }
        case MINUS: 
                  { oper = "isub"; break; }
        case MULT:
                  { oper = "imul"; break; } 
        case DIV:
                  { oper = "idiv"; break;}
        default: 
          {  oper = "NOP"; break;}
    }
    System.out.println("\t"+oper); 
  }


  public void visit(IntAusdr intAusdr) {
    System.out.println("\tbipush \t" + intAusdr.value );
  }


  public void visit(IdentAusdr identAusdr) { 
    if (identAusdr.deklinfo != null){
        System.out.println("\tiload_" + identAusdr.deklinfo.offset);
    }
  }

}
