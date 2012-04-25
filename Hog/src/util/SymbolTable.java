package util;


import java.util.Map;
import java.util.HashMap;


public class SymbolTable implements Cloneable{

	   //protected Map<Name, Identifier> variables;
	   protected Map<String,Identifier> table;
	   protected SymbolTable outer;
	   protected Identifier Identifier = null;

	   /*
	    * Note From Wikipedia: Not only do type classes permit multiple type
	    * parameters, they also permit functional dependencies between those
	    * type parameters. That is, a programmer can assert that a given
	    * assignment of some subset of the type parameters uniquely determines
	    * the remaining type parameters. 
	    * 
	    */

    public SymbolTable(SymbolTable prev){
    	this.table = new HashMap<String, Identifier>();
    	this.outer = prev;
    }
    
    public SymbolTable moveToOuterScope(){
    	return this.outer;
    }
    
    /*
     * Adds a symbol to the current scoping level.
     * 
     */
    public void addVariable(String name, util.type.Types t, String value){
    	if(!ReservedSymTable.getReservedSymTable().containsKey(name)){
    		Identifier token = new Identifier(t, value);
    		this.table.put(name, token);
    	}
    }
    

    /*
     * Returns whether the particular symbol is defined locally. If it isn't
     * in this scope, we ask the parent scope, but don't traverse to enclosing 
     * blocks.
     * 
     */
    public boolean isDefinedInScope(String name){
       	if(this.table.containsKey(name)){
    		return true;
       	}
       	
       	SymbolTable temp = outer;
       	while(temp != null){
       		if(this.table.containsKey(name)){
        		return true;
           	}
       		temp = this.moveToOuterScope();
       	}
       	return false;
    }
    
    public Identifier get(String name){
       	for(SymbolTable st = this; st != null; st = st.outer){
       		Identifier found = st.table.get(name);
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