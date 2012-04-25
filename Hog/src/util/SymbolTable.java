package util;


import java.util.Map;
import java.util.HashMap;

import util.ast.node.TypeNode;


public class SymbolTable implements Cloneable{

	   //protected Map<Name, Identifier> variables;
	   static SymbolTable root = new SymbolTable(null);
	   static SymbolTable top = root;
	   protected Map<String,TypeNode> table;
	   protected SymbolTable outer;

	   /*
	    * Note From Wikipedia: Not only do type classes permit multiple type
	    * parameters, they also permit functional dependencies between those
	    * type parameters. That is, a programmer can assert that a given
	    * assignment of some subset of the type parameters uniquely determines
	    * the remaining type parameters. 
	    * 
	    */

    public SymbolTable(SymbolTable prev){
    	this.table = new HashMap<String, TypeNode>();
    	this.outer = prev;
    }
    
    //move to symbol table in outer scope
    public SymbolTable pop(){
    	top = top.outer;
    	return top;
    }
    
    /*
     * Adds a variable to the symbol table. 
     * First checks to make sure it is not a reserved word by
     * looking the name up in the reserved word symbol table and
     * makes sure this table doesn't already have the symbol
     * 
     */
    public static boolean addVariable(String name, TypeNode type){
    	if(!ReservedSymTable.getReservedWordSymTable().containsKey(name)){
    		if(!top.table.containsKey(name)){
        		top.table.put(name, type);
        		return true;
    		}
    	}
    	return false;
    }
    
    public static void push() {
    	top = new SymbolTable(top); 
      }
    

    /*
     * Returns whether the particular symbol is defined in this scope. If it isn't
     * in this direct local scope, we ask the parent scope, but don't traverse to enclosing 
     * blocks.
     * 
     */
    public static boolean isDefinedInScope(String name){
       	if(top.table.containsKey(name)){
    		return true;
       	}
       	
       	//hold a pointer to this table before moving outward
       	SymbolTable topTable = top;
       	
       	//search all tables in this scope for this variable
       	SymbolTable temp = top.outer;
       	while(temp != null){
       		if(top.table.containsKey(name)){
        		return true;
           	}
       		temp = top.pop();
       	}
       	
       	//reset
       	top = topTable;
       	return false;
    }
    
    //look for a specific variable in this scope
    public TypeNode get(String name){
       	for(SymbolTable st = top; st != null; st = st.outer){
       		TypeNode found = st.table.get(name);
       		if(found != null) return found;
       	}
       	return null;
    }
    
 
    
    public static void main(String[] args){
    	SymbolTable s = new SymbolTable(null);
    	SymbolTable next = new SymbolTable(s);
    	/*
    	NumberInstance n1 = new NumberInstance("a", "REAL", "1.00000", false);
    	NumberInstance n2 = new NumberInstance("b", "REAL", "2.00000", false);
    	s.addVariableToThisScope(n1);
    	s.addVariableToThisScope(n2);
    	if(s.isLocal(n1.name)){
    		System.out.println("Variable Is Local: "+n1.name());
    	}
    	
    	if(s.isLocal(n2.name)){
    		System.out.println("Variable Is Local: "+n2.name());
    	}
    	
    	s = s.pushBlock();
    	s.name = "first";
    	if(!s.isLocal(n1.name)){
    		System.out.println("Variable Is Not Local: "+n1.name());
    	}
    	
    	
    	s = s.pushBlock();
    	s.name = "second";
    	
    	
    	s = s.pushBlock();
    	s.name = "third";
    	
    	
    	System.out.println(s.name);
    	
    	
    	
    	SymbolTable me = s;
    	while(me != null){
    		System.out.println(me.name);
    		me = me.pop();
    	}
    	

    }
    
    */
    	
    	
    	
    }
    
}