package util;

import util.ast.node.TypeNode;

public class VariableSymbol extends Symbol{
	
	public VariableSymbol(TypeNode t) {
		super(t);
	}

	@Override
	public String toString() {
		String str = "variable, return: " + this.type.toString();
		return str;
	}

}