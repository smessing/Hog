package util;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * Holds identifier bindings for a particular lexical scope.
 * @author !TODO!
 *
 */
public abstract class SymbolTable {

	public static SymbolTable outer;
	
	static Map<String,Name> symbolTableNameTable = new HashMap<String, Name>;
	public static enum Kind {
        BLOCK("block"),
        CLASS("class"),
        CODE("code"),
        OUTER("outer"),
        SOURCE("source");
        public final String name;
        private Kind(String name) {
            this.name = name;
        }
        @Override public String toString() {
            return name;
        }
        
    protected boolean inLoopHeader;
    protected boolean inAnnotation;
    protected boolean inAnonObjectScope;
    protected boolean inAssignment;
    protected Kind kind;
	    // -------- Section: Query methods --------------------------
    public boolean isBlock() { return kind == BLOCK; }
    public boolean isClass() { return kind == CLASS; }
    public boolean isCode() { return kind == CODE; }
    public boolean isOuter() { return kind == OUTER; }
    public boolean isSource() { return kind == SOURCE; }
    
    
    public static final Kind CODE = Kind.CODE;
    public static final Kind OUTER = Kind.OUTER;
    public static final Kind SOURCE = Kind.SOURCE;
    
    public boolean inDepType();
    public boolean inLoopHeader();
    public boolean inAnnotation();
    public boolean inAnonObjectScope();
    /**
     * Return true if in a method's scope and not in a local class within the
     * innermost method.
     ** Alternatively? Return whether innermost non-block scope is a code scope. */
    abstract boolean inCode();
    abstract boolean inAssignment();
    
        /** 
     * Returns whether the current context is a static context.
     * A statement of expression occurs in a static context if and only if the
     * inner-most method, constructor, instance initializer, static initializer,
     * field initializer, or explicit constructor statement enclosing the 
     * statement or expressions is a static method, static initializer, the 
     * variable initializer of a static variable, or an explicit constructor 
     * invocation statement. (Java Language Spec, 2nd Edition, 8.1.2)
     */
    abstract boolean inStaticContext();
    
    /**
     * Returns whether the particular symbol is defined locally.  If it isn't
     * in this scope, we ask the parent scope, but don't traverse to enclosing
     * classes.
     */
    abstract boolean isLocal(Name name);
    abstract boolean isValInScopeInClass(Name name);
    abstract List<Object> allLocals();
    abstract Object findInThisScope(Name name);
    abstract Object findMethod(Object matcher);
    abstract Object findLocal(Name name);
    abstract Object findField(Name name);
    abstract Object findMemberTypeInThisScropt(Name name, Object container);
    abstract Object findVariableInThisScope(Name name, Object lookupContext);
    
    // -------- Section: Pop and Push methods --------------------------
    /** Pop the context. */
    abstract Object pop();
    abstract Object push();
    abstract Object pushAssignment();
    abstract Object pushBlock();
    abstract Object push();
    abstract Object push();
    
    
    // -------------Section: Setter methods, updating current context--------
    
    abstract void setName(String n);
    abstract void restoreAnonObjectScope(boolean s);
    abstract void setInAssignment();
    abstract void setLoopHeader();
    abstract void setAnnotation();
    abstract void setAnonObjectScope();
    abstract void clearAnnotation();
    abstract void setTypeConstraintWithContextTerms(Object TypeConstraint);
    abstract void setTypeConstraint(Object TypeConstraint);
    abstract void setTypeConstraint(Object Collection);
    /**
     * Adds a symbol to the current scoping level.
     */
    abstract void addVariable(Object VarInstance); 
    
    /**
     * Adds a named type object to the current scoping level.
     */
    abstract void addNamed(Object Type);
    
    abstract void addVariableToThisScope(Object VarInstance);
}
