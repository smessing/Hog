package util.symbol_table;

import util.ast.node.TypeNode;

public class ReservedWordSymbol extends Symbol {
	
	public ReservedWordSymbol(TypeNode n){
		super(n);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.type.toString();
	}	
}
