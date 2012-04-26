package util;

import java.util.ArrayList;
import java.util.List;

import util.ast.node.TypeNode;

public class FunctionSymbol extends Symbol {
	
	List<TypeNode> argumentList;
	
	/**
	 * 
	 * @param returnType
	 */
	public FunctionSymbol(TypeNode returnType){		
		this(returnType, new ArrayList<TypeNode>());
	}
	
	public FunctionSymbol(TypeNode returnType, List<TypeNode> argumentList){
		super(returnType);
		this.argumentList = argumentList;
	}
	
}
