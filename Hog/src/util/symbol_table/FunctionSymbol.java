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
	 * Constructor takes a returnType and a parametersNode
	 * 
	 * @param returnType
	 * @param parameterNode
	 */
	public FunctionSymbol(TypeNode returnType, ParametersNode parametersNode) {
		super(returnType);
		// deepest node of parametersNode is first argument in the list
		
		this.parametersNode = parametersNode;
	}
	
	/**
	 * Constructor takes a returnType and a list of typenodes for parameters in the order they
	 * will need to be passed in by the user, and constructs a parametersNode
	 *
	 * @param returnType
	 * @param listOfTypeNodesAsParams
	 */
	public FunctionSymbol(TypeNode returnType, List<TypeNode> listOfTypeNodesAsParams) {
		super(returnType);
		ParametersNode paramNode = FunctionSymbol.listOfTypeNodesToParametersNode(listOfTypeNodesAsParams);
		this.parametersNode = paramNode;
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
	
	/**
     * This function takes a list of type nodes that represent formal parameters and returns
     * a ParametersNode properly constructed to represent the list
     * 
     * @param listOfTypeNodes
     * @return
     */
    private static ParametersNode listOfTypeNodesToParametersNode(List<TypeNode> listOfTypeNodes) {
    	// if null or empty list
    	if (listOfTypeNodes == null || listOfTypeNodes.isEmpty())
    		return null;
    	
    	// reverse order of list - first node in list will now be root of the tree and represents the last parameter
    	Collections.reverse(listOfTypeNodes);
    	
    	ParametersNode root = new ParametersNode(listOfTypeNodes.get(0));
    	ParametersNode currNode = root;
    	ParametersNode child;
    	
    	for(int i=1; i<listOfTypeNodes.size(); i++) {
    		child = new ParametersNode(listOfTypeNodes.get(i));
    		currNode.setParamChild(child);
    		currNode = child;
    	}
    	
    	return root;
    }
	
	
}
