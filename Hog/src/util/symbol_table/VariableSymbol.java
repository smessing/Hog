package util.symbol_table;

import util.ast.node.TypeNode;

/**
 * 
 * @author Jason Halpern
 * @author Benjamin Rapaport
 *
 */
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