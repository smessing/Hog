import java.util.ArrayList;
import java.util.List;




public class DerivedTypeIdentifierAttributes extends IdentifierAttributes {

	
	/*
	 * In a generic type or method, a type parameters is a place holder for 
	 * for a specific type that a client specifies when they instantiate a
	 * variable or the generic type. To Use List<Type>, client code must
	 * declare and instantiate a constructed type by specifying a type 
	 * argument inside the angle brackets.
	 */
	List<Type> typeParameters;
	
	/*
	 * A formal represents a formal parameter to a method or constructor.
	 * It consists of a type and a variable identifier.
	 */
	
	List<Identifier> formals;
	
	List<Type> formalTypes;
	
	/*
	 * Returns a list of MethodInstances for all the methods declared in this.
	 * 
	 */
	
	public List<MethodInstance> methods(){
		return new ArrayList<MethodInstance>();
	}
	
	/*
	 * Returns a list of FieldInstances for all the fields declared in this.
	 * It does not return fields declared in supertypes.
	 * 
	 */
	
	public List<FieldInstance> fields(){
		return null;
		
	}
	
	/*
	 * Get a field of the class by name.
	 * 
	 */
	
	public FieldInstance fieldNamed(Identifier name){
		return null;
	}
	
	/*
	 * Return true if this derived type has a method mi 
	 * 
	 */
	
	public boolean hasMethod(MethodInstance mi, SymbolTable table){	
		return false;
	}
	
	public List<MethodInstance> methodsNamed(Identifier name){	
		List<MethodInstance> l = new ArrayList<MethodInstance>();
		return l;
	}

	@Override
	public Type declType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type type() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier name(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
