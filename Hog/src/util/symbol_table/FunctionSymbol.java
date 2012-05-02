package util.symbol_table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.ast.node.ParametersNode;
import util.ast.node.TypeNode;

public class FunctionSymbol extends Symbol {
	
	List<TypeNode> argumentList;
	
	/**
	 * Constructor for a function with no parameters
	 * 
	 * @param returnType
	 */
	public FunctionSymbol(TypeNode returnType){		
		this(returnType, new ArrayList<TypeNode>());
	}
	
	/**
	 * Constructor takes a parameters node and flattens it into a list of TypeNodes
	 * @param returnType
	 * @param parameterNode
	 */
	public FunctionSymbol(TypeNode returnType, ParametersNode parametersNode) {
		super(returnType);
		// deepest node of parametersNode is first argument in the list
		
		this.argumentList = parametersNodeToTypeNodesList(parametersNode);
	}
	
	/**
	 * Constructor that takes the flat argumentsList - used to populate reserved functions 
	 * and used internally after flattening ParametersNode
	 * 
	 * @param returnType
	 * @param argumentList
	 */
	public FunctionSymbol(TypeNode returnType, List<TypeNode> argumentList){
		super(returnType);
		this.argumentList = argumentList;
	}
	
	/**
	 * Returns a properly ordered list of TypeNodes for the parameters list in the functionsymbol
	 * 
	 * @param parametersNode
	 * @return an ArrayList<TypeNode> that represents the types of the functions parameters in order
	 */
	private ArrayList<TypeNode> parametersNodeToTypeNodesList(ParametersNode parametersNode) {
		ArrayList<TypeNode> paramsTypeNodeList = new ArrayList<TypeNode>();
		
		ParametersNode currNode = parametersNode;
		
		// add type of node passed in
		paramsTypeNodeList.add(currNode.getType());
		
		// recurse through, adding each child to list
		while(currNode.hasChildren()) {
			currNode = (ParametersNode) currNode.getChildren().get(0);
			paramsTypeNodeList.add(currNode.getType());
		}
		
		// children in wrong order
		Collections.reverse(paramsTypeNodeList);
		
		return paramsTypeNodeList;
		
	}
	
	/**
	 * Returns a List of TypeNodes, which represent the types of the parameters to the functions
	 * @return
	 */
	public List<TypeNode> getParametersTypeNodesList() {
		return this.argumentList;
	}
	
	/**
	 * Returns the number of parameters a function takes
	 * @return
	 */
	public int getNumParams() {
		return this.argumentList.size();
	}

	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("function, returns: ");
		strBuff.append(this.type.toString());
		strBuff.append(". ParamList: (");
		for (TypeNode a : this.argumentList) {
			strBuff.append(a.toString());
			strBuff.append(", ");
		}
		strBuff.append(')');
		
		return strBuff.toString();
	}
	
	
}
