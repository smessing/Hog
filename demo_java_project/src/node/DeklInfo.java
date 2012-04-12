// Technische Universitaet Muenchen 
// Fakultaet fuer Informatik 
// Riitta Hoellerer
//
// Praktikum des Uebersetzerbaus
// SS 2001
//
//
// DeklInfo.java 
//
//
//


package node;
import java.util.*;

public class DeklInfo implements Constants, Cloneable{

  public int kind;         // variable, array, parameter, procedure, program
                                 //   ( s. Constants.java) 
  public int type;         // int or boolean
  public int pst;          // Prozedurschachtelungstiefe
  public int length;       // holding length of arrays and  1 for variables 
  public int offset;       // offset for addressing variables and parameters
  public Vector parinfolist;   // parameter information for procedure
  public int labno ;       // begin label of procedure code


  public DeklInfo(int kind, int type, int pst, int length ){
    this.kind       = kind; 
    this.type       = type;
    this.pst        = pst;
    this.length     = length; // holding length of arrays, 1 for variables and
                              // value for constants
  }

  public DeklInfo( int kind, int pst, Vector parinfolist, int labno ){
    this.kind         = kind;
    this.pst          = pst;
    this.parinfolist  = parinfolist;
    this.labno        = labno;
  }


  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    if ( kind == PROCEDURE ){
         buffer.append(tab); buffer.append("kind = " + kind +"\n");      
         buffer.append(tab); buffer.append("pst = " + pst +"\n");
         buffer.append(tab); buffer.append("labno = " + labno +"\n");
         buffer.append(tab); buffer.append("parinfolist : \n");
            if (parinfolist == null||parinfolist.size()==0){
               buffer.append(tab); buffer.append("\tleer\n");
            }
            else{
                 int size = parinfolist.size();
                 for (int i = 0; i < size; i++) {
                     buffer.append( ((DeklInfo)parinfolist.elementAt(i)).toString(tab +"\t")+"\n" );
                 }
           } 
    }
    else {
       if ( kind == PROGRAM ){
            buffer.append(tab); buffer.append("kind = " + kind +"\n");        
            buffer.append(tab); buffer.append("pst = " + pst +"\n");
            buffer.append(tab); buffer.append("labno = " + labno +"\n");
       } 
       else {
         buffer.append(tab); buffer.append("kind = " + kind +"\n");
         buffer.append(tab); buffer.append("type = " + type +"\n");         
         buffer.append(tab); buffer.append("pst = " + pst +"\n");
         buffer.append(tab); buffer.append("length = " + length +"\n");
         buffer.append(tab); buffer.append("offset = " + offset +"\n");
       }
    }
    return buffer.toString();
  }
    


// clone must be overridden here as public method
  public Object clone(){
    Object o = null;
    try {
      o = super.clone();
    } catch (CloneNotSupportedException e){
      System.out.println("Can't clone");
    }
    return o;
  }


}
  
   
