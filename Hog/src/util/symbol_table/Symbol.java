package util.symbol_table;

import util.ast.node.TypeNode;

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