package util;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.logging.Logger;

import util.ast.node.*;
import util.type.Types;


public class SymbolTable implements Cloneable{

	   //protected Map<Name, Identifier> variables;
	   static SymbolTable root = null;
	   static SymbolTable top = root;
	   protected Map<String,Symbol> table;
	   protected SymbolTable outer;
	   
	   static Map<Node, SymbolTable> nodeToSymbolTableMap = new HashMap<Node, SymbolTable>();
	   
	   private final static Logger LOGGER = Logger.getLogger(SymbolTable.class.getName());

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
    		this.outer = null;
    		SymbolTable.top = this;
    		this.fillReservedTable();
    		root = this;
    	}
   
    	else{
    		this.table = new HashMap<String, Symbol>();
        	this.outer = prev;
    	}
    }
    
    /**
     * mapNode adds a representative node and its corresponding symbol table to the nodeToSymbolTableMap
     * 
     * @param node is the representative node
     * @throws Exception - when node has already been mapped to a symbol table
     */
    public void mapNode(Node node) throws Exception {
    	// map argument node to this symbol table
    	if (SymbolTable.nodeToSymbolTableMap.put(node, top) != null) {
    		// if its not null, this node has already been mapped, throw an exception
    		throw new Exception("Representative Node has already been mapped to a symbol table.");
    	}
    }
    

    //move to symbol table in outer scope
    public SymbolTable pop(){
    	top = top.outer;
    	return top;
    }
    
    /**
     * Adds a variable to the symbol table. 
     * First checks to make sure it is not a reserved word by
     * looking the name up in the reserved word symbol table and
     * makes sure this table doesn't already have the symbol
     * 
     * @param name
     * @param type
     * @return true for successful puts
     */
    public boolean put(String name, Symbol symbol){
    	// if not in reserve table
    	if(!root.table.containsKey(name)){
    		// if not in current table
    		if(!top.table.containsKey(name)){
            	top.table.put(name, symbol);
            	return true;
        	}
    		
    	}
    	return false;
    }
    
    public void push() {
    	top = new SymbolTable(top); 
      }
    

    /**
     * Returns whether the particular symbol is defined in this scope. If it isn't
     * in this direct local scope, we ask the parent scope, but don't traverse to enclosing 
     * blocks.
     * 
     * @param name
     * @return true if the identifier is defined in this scope
     */
    public boolean isDefinedInScope(String name){
       	if(this.table.containsKey(name)){
    		return true;
       	} else if (this.outer == null ){
       		return false;
       	} else {
       		return this.outer.isDefinedInScope(name);
       	}
    }
    
    /**
     * look for a specific identifier in this scope
     * 
     * @param name
     * @return the Symbol if found, null otherwise
     */
    public Symbol get(String name){
       	for(SymbolTable st = this; st != null; st = st.outer){
       		Symbol found = st.table.get(name);
       		if(found != null) return found;
       	}
       	return null;
    }
    
    public void reserveWord(String word){ 
    	ReservedWordTypeNode typeNode = new ReservedWordTypeNode(util.type.Types.Flags.RESERVED_WORD);
		this.table.put(word, new ReservedWordSymbol(typeNode));  
	}
    
    public void reserveFunction(String word, TypeNode returnType, List<TypeNode> argumentList){ 
		this.table.put(word, new FunctionSymbol(returnType, argumentList));  
	}
    
    public void reserveFunction(String word, TypeNode returnType){ 
		this.table.put(word, new FunctionSymbol(returnType));  
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
		
		/* add built-in list methods */
		ArrayList<TypeNode> listAddArguments = new ArrayList<TypeNode>();
		listAddArguments.add(new ReservedWordTypeNode(Types.Flags.CHECK_INNER_TYPE));
		reserveFunction("list.add", new PrimitiveTypeNode(Types.Primitive.VOID), listAddArguments);
		reserveFunction("list.clear", new PrimitiveTypeNode(Types.Primitive.VOID));
		ArrayList<TypeNode> listGetArguments = new ArrayList<TypeNode>();
		listGetArguments.add(new ReservedWordTypeNode(Types.Flags.INT));
		reserveFunction("list.get", new PrimitiveTypeNode(Types.Primitive.CHECK_INNER_TYPE), listGetArguments);
		reserveFunction("list.iterator", new PrimitiveTypeNode(Types.Primitive.CHECK_INNER_TYPE));
		reserveFunction("list.size", new PrimitiveTypeNode(Types.Primitive.INT));
		reserveFunction("list.sort", new PrimitiveTypeNode(Types.Primitive.VOID));
		
		/* add built-in iter methods */
		reserveFunction("iter.next", new PrimitiveTypeNode(Types.Primitive.CHECK_INNER_TYPE));
		reserveFunction("iter.hasNext", new PrimitiveTypeNode(Types.Primitive.BOOL));
		reserveFunction("iter.peek", new PrimitiveTypeNode(Types.Primitive.CHECK_INNER_TYPE));
		
		/* add built-in set methods */
		ArrayList<TypeNode> setAddArguments = new ArrayList<TypeNode>();
		setAddArguments.add(new ReservedWordTypeNode(Types.Flags.CHECK_INNER_TYPE));
		reserveFunction("set.add", new PrimitiveTypeNode(Types.Primitive.BOOL), setAddArguments);
		reserveFunction("set.clear", new PrimitiveTypeNode(Types.Primitive.VOID));
		ArrayList<TypeNode> setContainsArguments = new ArrayList<TypeNode>();
		setContainsArguments.add(new ReservedWordTypeNode(Types.Flags.CHECK_INNER_TYPE));
		reserveFunction("set.contains", new PrimitiveTypeNode(Types.Primitive.BOOL), setContainsArguments);
		ArrayList<TypeNode> setContainsAllArguments = new ArrayList<TypeNode>();
		setContainsAllArguments.add(new ReservedWordTypeNode(Types.Flags.CHECK_INNER_TYPE));
		reserveFunction("set.containsAll", new PrimitiveTypeNode(Types.Primitive.BOOL), setContainsAllArguments);
		reserveFunction("set.isEmpty", new PrimitiveTypeNode(Types.Primitive.BOOL));
		reserveFunction("set.iterator", new PrimitiveTypeNode(Types.Primitive.CHECK_INNER_TYPE));
		ArrayList<TypeNode> setRemoveArguments = new ArrayList<TypeNode>();
		setRemoveArguments.add(new ReservedWordTypeNode(Types.Flags.CHECK_INNER_TYPE));
		reserveFunction("set.remove", new PrimitiveTypeNode(Types.Primitive.BOOL), setRemoveArguments);
		ArrayList<TypeNode> setRemoveAllArguments = new ArrayList<TypeNode>();
		setRemoveAllArguments.add(new ReservedWordTypeNode(Types.Flags.CHECK_INNER_TYPE));
		reserveFunction("set.removeAll", new PrimitiveTypeNode(Types.Primitive.BOOL), setRemoveAllArguments);
		reserveFunction("set.size", new PrimitiveTypeNode(Types.Primitive.INT));

		/* add built-in multiset methods */
		ArrayList<TypeNode> multiSetAddArguments = new ArrayList<TypeNode>();
		multiSetAddArguments.add(new ReservedWordTypeNode(Types.Flags.CHECK_INNER_TYPE));
		reserveFunction("multiSet.add", new PrimitiveTypeNode(Types.Primitive.BOOL), multiSetAddArguments);
		reserveFunction("multiSet.clear", new PrimitiveTypeNode(Types.Primitive.VOID));
		ArrayList<TypeNode> multiSetContainArguments = new ArrayList<TypeNode>();
		multiSetContainArguments.add(new ReservedWordTypeNode(Types.Flags.CHECK_INNER_TYPE));
		reserveFunction("multiSet.contains", new PrimitiveTypeNode(Types.Primitive.BOOL), multiSetContainArguments);
		ArrayList<TypeNode> multiSetCountArguments = new ArrayList<TypeNode>();
		multiSetCountArguments.add(new ReservedWordTypeNode(Types.Flags.CHECK_INNER_TYPE));
		reserveFunction("multiSet.count", new PrimitiveTypeNode(Types.Primitive.INT), multiSetCountArguments);
		reserveFunction("multiSet.entrySet", new PrimitiveTypeNode(Types.Primitive.CHECK_INNER_TYPE));
		reserveFunction("multiSet.isEmpty", new PrimitiveTypeNode(Types.Primitive.BOOL));
		reserveFunction("multiSet.iterator", new PrimitiveTypeNode(Types.Primitive.CHECK_INNER_TYPE));
		ArrayList<TypeNode> multiSetRemoveAllArguments = new ArrayList<TypeNode>();
		multiSetRemoveAllArguments.add(new ReservedWordTypeNode(Types.Flags.CHECK_INNER_TYPE));
		reserveFunction("multiSet.removeAll", new PrimitiveTypeNode(Types.Primitive.BOOL), multiSetRemoveAllArguments);
		ArrayList<TypeNode> multiSetRemoveOneArguments = new ArrayList<TypeNode>();
		multiSetRemoveOneArguments.add(new ReservedWordTypeNode(Types.Flags.CHECK_INNER_TYPE));
		reserveFunction("multiSet.removeOne", new PrimitiveTypeNode(Types.Primitive.BOOL), multiSetRemoveOneArguments);
		reserveFunction("multiSet.size", new PrimitiveTypeNode(Types.Primitive.INT));
		
		/* add built-in text functions */
		reserveFunction("text.length", new PrimitiveTypeNode(Types.Primitive.INT));
		ArrayList<TypeNode> textReplaceArguments = new ArrayList<TypeNode>();
		textReplaceArguments.add(new ReservedWordTypeNode(Types.Flags.TEXT));
		reserveFunction("text.replace", new PrimitiveTypeNode(Types.Primitive.TEXT), textReplaceArguments);
		reserveFunction("text.tokenize", null);
		
		/* add built-in dict types */
		reserveFunction("dict.clear", new PrimitiveTypeNode(Types.Primitive.VOID));
		ArrayList<TypeNode> dictContainsKeyArguments = new ArrayList<TypeNode>();
		dictContainsKeyArguments.add(new ReservedWordTypeNode(Types.Flags.CHECK_INNER_TYPE));
		reserveFunction("dict.containsKey", new PrimitiveTypeNode(Types.Primitive.BOOL), dictContainsKeyArguments);
		ArrayList<TypeNode> dictGetArguments = new ArrayList<TypeNode>();
		dictGetArguments.add(new ReservedWordTypeNode(Types.Flags.CHECK_INNER_TYPE));
		reserveFunction("dict.get", new PrimitiveTypeNode(Types.Primitive.CHECK_INNER_TYPE), dictGetArguments);
		reserveFunction("dict.keySet", new PrimitiveTypeNode(Types.Primitive.CHECK_INNER_TYPE));
		ArrayList<TypeNode> dictPutArguments = new ArrayList<TypeNode>();
		dictPutArguments.add(new ReservedWordTypeNode(Types.Flags.CHECK_INNER_TYPE));
		reserveFunction("dict.put", new PrimitiveTypeNode(Types.Primitive.VOID), dictPutArguments);
		reserveFunction("dict.size", new PrimitiveTypeNode(Types.Primitive.INT));
		reserveFunction("dict.reverseDict", new PrimitiveTypeNode(Types.Primitive.CHECK_INNER_TYPE));

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