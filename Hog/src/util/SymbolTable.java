package util;


import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import front_end.sym;

import util.ast.node.*;


public class SymbolTable implements Cloneable{

	   //protected Map<Name, Identifier> variables;
	   static SymbolTable root = null;
	   static SymbolTable top = root;
	   protected Map<String,Symbol> table;
	   protected SymbolTable outer;

	   /*
	    * Note From Wikipedia: Not only do type classes permit multiple type
	    * parameters, they also permit functional dependencies between those
	    * type parameters. That is, a programmer can assert that a given
	    * assignment of some subset of the type parameters uniquely determines
	    * the remaining type parameters. 
	    */

    public SymbolTable(SymbolTable prev){
    	if(root == null){
    		this.table = new HashMap<String, Symbol>();
    		this.fillReservedTable();
    		this.outer = null;
    		root = this;
    	}
   
    	else{
    		this.table = new HashMap<String, Symbol>();
        	this.outer = prev;
    	}
    }
    
    public void reserveWord(String word){ 
    	ReservedWordTypeNode typeNode = new ReservedWordTypeNode(Types.Flags.RESERVED_WORD);
		this.table.put(word, new ReservedWordSymbol(typeNode));  
	}
    
    public void reserveFunction(String word){ 
    	ReservedWordTypeNode typeNode = new ReservedWordTypeNode(Types.Flags.RESERVED_WORD);
		this.table.put(word, new FunctionSymbol(typeNode));  
	}
	
    
    public void fillReservedTable(){
    	reserveWord("and");
    	reserveWord("or");
    	reserveWord("if");
    	reserveWord("else");
    	reserveWord("elseif");
    	reserveWord("Map");
    	reserveWord("Reduce");
		reserveWord("Main");
		reserveWord("Functions");
		//reserveWord(new Word("emit", sym.EMIT));
		reserveWord("for");
		reserveWord("not");
		reserveWord("in");
		reserveWord("return");
		reserveWord("break");
		reserveWord("case");
		reserveWord("switch");
		reserveWord("void");
		reserveWord("while");
		reserveWord("for");
		reserveWord("foreach");
		reserveWord("list");
		reserveWord("continue");
		reserveWord("int");
		reserveWord("real");
		reserveWord("bool");
		reserveWord("text");
		reserveWord("default");
		reserveWord("set");
		reserveWord("dict");
		reserveWord("iter");
		reserveWord("==");
		reserveWord("!=");
		reserveWord(">=");
		reserveWord("<=");
		reserveFunction("list.add");
		reserveFunction("list.clear");
		reserveFunction("list.get");
		reserveFunction("list.iterator");
		reserveFunction("list.size");
		reserveFunction("list.sort");
		reserveFunction("iter.next");
		reserveFunction("iter.hasNext");
		reserveFunction("iter.peek");
		reserveFunction("set.add");
		reserveFunction("set.clear");
		reserveFunction("set.contains");
		reserveFunction("set.containsAll");
		reserveFunction("set.isEmpty");
		reserveFunction("set.iterator");
		reserveFunction("set.remove");
		reserveFunction("set.removeAll");
		reserveFunction("set.size");
		reserveFunction("multiSet.add");
		reserveFunction("multiSet.clear");
		reserveFunction("multiSet.contains");
		reserveFunction("multiSet.count");
		reserveFunction("multiSet.entrySet");
		reserveFunction("multiSet.isEmpty");
		reserveFunction("multiSet.iterator");
		reserveFunction("multiSet.removeAll");
		reserveFunction("multiSet.removeOne");
		reserveFunction("multiSet.size");
		reserveFunction("text.length");
		reserveFunction("text.replace");
		reserveFunction("text.tokenize");
		reserveFunction("dict.clear");
		reserveFunction("dict.containsKey");
		reserveFunction("dict.get");
		reserveFunction("dict.keySet");
		reserveFunction("dict.put");
		reserveFunction("dict.size");
		reserveFunction("dict.reverseDict");

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
    public static boolean put(String name, Symbol type){
    	if(!root.table.containsKey(name)){
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
    public Symbol get(String name){
       	for(SymbolTable st = top; st != null; st = st.outer){
       		Symbol found = st.table.get(name);
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