package util;

import util.ast.node.TypeNode;

public abstract class Symbol{
	
	public TypeNode type;
	
	public Symbol(TypeNode t){
		this.type = t;
	}
	
	public abstract String toString();

}