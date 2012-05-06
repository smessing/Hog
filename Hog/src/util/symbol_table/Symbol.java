package util.symbol_table;

import util.ast.node.TypeNode;

/**
 * 
 * @author Jason Halpern
 * @author Benjamin Rapaport
 *
 */
public abstract class Symbol{
	
	public TypeNode type;
	
	public Symbol(TypeNode t){
		this.type = t;
	}
	
	public TypeNode getType() {
		return this.type;
	}
	
	public abstract String toString();

}