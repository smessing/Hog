package util;

import util.ast.node.TypeNode;

public abstract class Symbol{
	
	protected TypeNode type;
	
	public Symbol(TypeNode t){
		this.type = t;
	}

}