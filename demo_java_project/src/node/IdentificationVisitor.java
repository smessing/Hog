// Technische Universitaet Muenchen 
// Fakultaet fuer Informatik 
// Riitta Hoellerer
//
// Praktikum des Uebersetzerbaus
// SS 2001
//
//
// IdentificationVisitor.java 
//
//  Collects identifiers in symtab and sets istvarParam, istformParam and
//  deklinfo attributes.
//  
//
  

package node;

import java.util.*;


public class IdentificationVisitor extends VisitorAdaptor 
                                   implements Constants, Cloneable {

//private HashMap /* Ident -> DeklInfo */ symtab = new HashMap();
  private Hashtable /* Ident -> DeklInfo */ symtab = new Hashtable();

  private Stack localNames = new Stack();
  private int PST= -1;

  private int offset;

  private void error ( String message ){
    System.out.println( "Fehler: " + message );
  }


// 
// symboltable organisation:
//


   public void initOffset( int i ){
    offset = i;
  }

  public int newOffset(int kind, int length){
    int result = offset; 
    if(kind == VARPAR || kind == VARARRAYPAR ){ 
        offset += 1   ;
    } else {
        offset += length; // length in words
    }
    return result;
  }



// Wird benutzt bei der Ausgabe eines Symboltabellenblocks: 
  private void printKeyValuePair(String name){
    System.out.println( "Ident = " + name + ", Deklinfo: " );
    DeklInfo info = (DeklInfo)symtab.get( name );          
    if ( info == null ){  
       System.out.println( "\t\tnull" );
    } 
    else { 
       System.out.println( info.toString("\t\t") );
    } 

  }

  private void enter (  String name, DeklInfo info ){ 
    localNames.push(name); 
    DeklInfo oldinfo = (DeklInfo)symtab.put( name, info) ;
    if ( oldinfo != null ){
         if (oldinfo.pst == info.pst){
             error(name + " doppelt deklariert");
         }
    }
  }

  private DeklInfo lookup( String name ){
    DeklInfo info = (DeklInfo)symtab.get( name );          
    if ( info == null ){   
         error(name + " nicht deklariet");
    }
    return info; 
  }

 
  private void blockbegin(){
     PST++;
     localNames.push("$$$");
   }

   private void blockend(){
     System.out.println("Symboltabellenblock STB(" + PST + "):" );     
     // scope ends, remove its identifiers from symtab:
     String stacktop = (String)localNames.pop();
     while (stacktop != "$$$") {  
       printKeyValuePair(stacktop);
       symtab.remove(stacktop);
       stacktop = (String)localNames.pop();
     }
     PST--; 
   } 


// 
// visit methods:
// 

  public void visit(Prog prog){
    blockbegin();           // main scope begins here; PST = 0
                            // this scope includes
                            // program name, procedure names and 
                            // local variables of main block
    enter(prog.ident, new DeklInfo(PROGRAM, PST, null, 0));
    prog.proc_Dekl_Seq.accept(this);
    initOffset(0);
    prog.block.accept(this);
    blockend();                   // scope ends here
  }

  public void visit(Proc_Dekl_Seq0 proc_Dekl_Seq){
    proc_Dekl_Seq.childrenAccept(this);    
  }    

     
  public void visit(Proc_Dekl_Seq1 proc_Dekl_Seq){
    proc_Dekl_Seq.childrenAccept(this);    
  }    



  public void visit(Proc_Dekl proc_Dekl){
    enter(proc_Dekl.ident, new DeklInfo(PROCEDURE,PST, null, 0));
    blockbegin();           // procedure scope begins here; PST = 1
                            // this scope includes
                            // procedure parameters and 
                            // local variables of procedure block
    initOffset(0);
    proc_Dekl.form_Par_Seq.accept(this);
    initOffset(0);
    proc_Dekl.block.accept(this);
    blockend();                   // scope ends here

  }    

  public void visit(Form_Par_Seq0 form_Par_Seq){
    form_Par_Seq.form_Par.accept(this);
    form_Par_Seq.form_Par_Seq.accept(this);
  }

  public void visit( Param  param){
    param.var_Dekl.istformParam = true;
    param.var_Dekl.istvarParam  = false;
    param.var_Dekl.accept(this);
  }

  public void visit( Var_Param  param){
    param.var_Dekl.istformParam = true;
    param.var_Dekl.istvarParam  = true;
    param.var_Dekl.accept(this);
   }

  public void visit( Variable  variable){
    int kind;

    if (variable.istformParam){
       if (variable.istvarParam){ kind = VARPAR;}
       else                     { kind = PAR;   }
       }
    else  { kind = VARIABLE;   }
    variable.id_Seq.deklinfo  =  new DeklInfo( kind, variable.typ.typ, PST, 1 );                                                        // default laenge = 1
    variable.id_Seq.accept(this);
   }

  public void visit(Array_Variable array_Variable){
    int kind;
    if (array_Variable.istformParam ){
         if (array_Variable.istvarParam){ kind = VARARRAYPAR;}
         else { kind = ARRAYPAR;   }
    }
    else { kind = ARRAYVAR;   }
    array_Variable.id_Seq.deklinfo  =  
       new DeklInfo( kind, array_Variable.typ.typ, PST, array_Variable.laenge );
     array_Variable.id_Seq.accept(this);
  }

  public void visit(Block block){
    block.childrenAccept(this);
  }    

  public void visit(Dekl_Seq0 dekl_Seq) {
    dekl_Seq.dekl.istformParam  = false ;
    dekl_Seq.dekl.accept(this);
    if (dekl_Seq.dekl_Seq != null) dekl_Seq.dekl_Seq.accept(this);
  }


  public void visit(Id_Seq0 id_Seq){
    id_Seq.deklinfo.offset = 
               newOffset(id_Seq.deklinfo.kind, id_Seq.deklinfo.length);
    enter(id_Seq.ident, id_Seq.deklinfo); 
    id_Seq.id_Seq.deklinfo     = (DeklInfo)id_Seq.deklinfo.clone();
    id_Seq.id_Seq.accept(this);
  }

  public void visit(Id_Seq1 id_Seq){
    id_Seq.deklinfo.offset = 
               newOffset(id_Seq.deklinfo.kind, id_Seq.deklinfo.length);
    enter(id_Seq.ident, id_Seq.deklinfo); 
  }

  public void visit(Anw_Seq1 anw_Seq){
    anw_Seq.childrenAccept(this);
  }

  public void visit(Anw_Seq0 anw_Seq){
    anw_Seq.childrenAccept(this);
  }

  public void visit(Anw anw){
    anw.childrenAccept(this);
  }


  public void visit( BinAusdr binAusdr ) { 
    binAusdr.childrenAccept(this);
  }


  public void visit(VarAusdr varAusdr) { 
   varAusdr.childrenAccept(this);
  }

  public void visit(IdentAusdr identAusdr) { 
    identAusdr.deklinfo = lookup(identAusdr.ident);
  }

}
