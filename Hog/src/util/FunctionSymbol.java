package util;

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
	 * Constructor takes a parameters node and flattens it into a list of parameter types
	 * 
	 * @param returnType
	 * @param parameterNode
	 */
	public FunctionSymbol(TypeNode returnType, ParametersNode parametersNode) {
		super(returnType);
		// deepest node of parametersNode is first argument in the list
		
		this.argumentList = getParametersTypeNodesList(parametersNode);
	}
	
	/**
	 * Constructor that takes the flat argumentsList - used to populate reserved functions 
	 * and used internally after flatterning ParametersNode
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
	private ArrayList<TypeNode> getParametersTypeNodesList(ParametersNode parametersNode) {
		ArrayList<TypeNode> paramsTypeNodeList = new ArrayList<TypeNode>();
		
		ParametersNode currNode = parametersNode;
		// add child of node passed in
		paramsTypeNodeList.add((TypeNode) currNode.getChildren().get(0));
		
		// recurse through, adding each child to list
		while(currNode.hasChildren()) {
			currNode = (ParametersNode) currNode.getChildren().get(0);
			paramsTypeNodeList.add(currNode.getType());
		}
		
		// children in wrong order
		Collections.reverse(paramsTypeNodeList);
		
		return paramsTypeNodeList;
		
	}
	
	
}
