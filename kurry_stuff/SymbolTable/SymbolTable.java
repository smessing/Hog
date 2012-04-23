import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.HashMap;
import java.util.Stack;
import java.util.List;

public class SymbolTable implements Cloneable{


    
	public static enum Kind {
		BLOCK{
			public String toString(){
			return "block";
			}
		},
		CLASS{
			public String toString(){
				return "class";
				}
		},
		CODE{
			public String toString(){
				return "code";
				}
		},
		OUTER{
			public String toString(){
				return "outer";
				}
		},
		SOURCE{
			public String toString(){
				return "source";
				}
		};
	}
	
	   public static final Kind BLOCK = Kind.BLOCK;
	   public static final Kind CLASS = Kind.CLASS;
	   public static final Kind CODE = Kind.CODE;
	   public static final Kind OUTER = Kind.OUTER;
	   public static final Kind SOURCE = Kind.SOURCE;
    
	   //protected Map<Name, Identifier> variables;
	   protected Map<Identifier,NumberInstance> vars;
	   protected Map<Identifier, Type> types;
	   protected SymbolTable outer;
	   protected String name;
	   protected Kind kind;
	   protected boolean symtabStackUsedUp = false;
	   protected Identifier Identifier = null;

	   /*
	    * Note From Wikipedia: Not only do type classes permit multiple type
	    * parameters, they also permit functional dependencies between those
	    * type parameters. That is, a programmer can assert that a given
	    * assignment of some subset of the type parameters uniquely determines
	    * the remaining type parameters. 
	    * 
	    */
	   
	   protected Map<Identifier,Type> depType = null; 
	   
    public SymbolTable(){
    	this.outer = null;
    	this.name = null;
    	this.kind = OUTER;
    }
    
  public SymbolTable pushBlock(){
	  SymbolTable v = this.shallowCopy();
	  v.outer = this;
	  v.name = "";
	  return v;
  }
    
    public SymbolTable pop(){
    	return outer;
    }
    
    public SymbolTable shallowCopy(){
    	try{
    		SymbolTable res = (SymbolTable)super.clone();
    		res.name = "Copy";
    		return res;
    	}catch(Exception e){
    		return null;
    	}
    }
    
    /*
     * Adds a symbol to the current scoping level.
     * 
     */
    public void addVariable(NumberInstance vi){
    	addVariableToThisScope(vi);
    }
    
    public void addVariableToThisScope(NumberInstance var){
    	if(vars == null) vars = new HashMap<Identifier, NumberInstance>();
    	vars.put(var.name, var);
    }
    
    /*
     * Returns whether the particular symbol is defined locally. If it isn't
     * in this scope, we ask the parent scope, but don't traverse to enclosing 
     * blocks.
     * 
     */
    public boolean isLocal(Identifier name){
    	SymbolTable me = this;
    	
    	if(findVariableInThisScope(name) != null)
			return true;
    	while(me != null){
    		me = me.pop();
    	if(outer == null){
    		return false;
    	}
    		return outer.isLocal(name);
    	}
    	
    	return false;
    }
    
    
    
    public NumberInstance findVariableInThisScope(Identifier name){
    	return findVariableInThisScope(name,this);
    }
    
    public NumberInstance findVariableInThisScope(Identifier name, SymbolTable lookupSymbolTable){
    	boolean fix = true;
    	if(fix) return superFindVariableInThisScope(Identifier,lookupSymbolTable);
    	
    	NumberInstance ni = pop().findVariableInThisScope(name,lookupSymbolTable);
    	
    	if(ni.isLocal) return ni;
 
    	return ni;
    }
    
    public NumberInstance superFindVariableInThisScope(Identifier name, SymbolTable lookupSymbolTable){
    	
    	NumberInstance ni = null;
    	if(vars != null){
    		ni = (NumberInstance)vars.get(name);
    	}
    	//try fields next
    	if(ni == null ){
    		
    	}
    	
    	return ni;
    }
    
    public static void main(String[] args){
    	SymbolTable s = new SymbolTable();
    	s.name = "outer";
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