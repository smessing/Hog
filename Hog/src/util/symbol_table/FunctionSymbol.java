package util.symbol_table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.ast.node.ParametersNode;
import util.ast.node.TypeNode;

public class FunctionSymbol extends Symbol {
	
	ParametersNode parametersNode;
	
	/**
	 * Constructor for a function with no parameters
	 * 
	 * 
	 * @param returnType
	 */
	public FunctionSymbol(TypeNode returnType){	
		super(returnType);
	}
	
	/**
	 * Constructor takes a parameters node and flattens it into a list of TypeNodes
	 * @param returnType
	 * @param parameterNode
	 */
	public FunctionSymbol(TypeNode returnType, ParametersNode parametersNode) {
		super(returnType);
		// deepest node of parametersNode is first argument in the list
		
		this.parametersNode = parametersNode;
	}
	
	/**
	 * 
	 * @return true if the function takes parameters
	 */
	public boolean hasParameters() {
		return (this.getParametersNode() != null);
	}
	
	/**
	 * 
	 * @return the root parametersNode of the function
	 */
	public ParametersNode getParametersNode() {
		return this.parametersNode;
	}
	
	
	/**
	 * Returns the number of parameters a function takes
	 * @return
	 */
	public int getNumParams() {
		if (!this.hasParameters()) 
			return 0;
		else
			return this.getParametersNode().getNumParams();
	}

	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("function, returns: ");
		strBuff.append(this.type.toString());
		strBuff.append(". ParamList: (");
		for (TypeNode a : this.parametersNode) {
			strBuff.append(a.toString());
			strBuff.append(", ");
		}
		strBuff.append(')');
		
		return strBuff.toString();
	}
	
	
}
