package util.ast.node;

import java.util.ArrayList;

import back_end.Visitor;

/**
 * Represents PostFixExpression productions for the following types of postfix
 * expressions: array indexing, method calls with no params, method calls with
 * params, function calls
 * 
 * Can check which it represents by calling getPostFixType
 * 
 * @author ben
 * 
 */
public class PostfixExpressionNode extends ExpressionNode {
	
	public static enum PostfixType {
		METHOD_NO_PARAMS, METHOD_WITH_PARAMS, FUNCTION_CALL
	}
	/** postfixType field which is of type PostfixType */
	protected PostfixType postfixType;

	/** boolean field to indicate whether PostfixExpression Has Arguments */
	protected boolean hasArguments;
	
	protected IdNode functionName;
	protected IdNode objectName;
	protected IdNode methodName;
	protected IdNode objectOfMethod;
	
	protected ExpressionNode argsList;
	
	/**
	 * Constructor for method calls with no parameters
	 * 
	 * @param objectOfMethod
	 * @param methodName
	 */
	public PostfixExpressionNode(IdNode objectOfMethod, IdNode methodName) {
		super();
		postfixType = PostfixType.METHOD_NO_PARAMS;
		this.objectOfMethod = objectOfMethod;
		this.objectName = objectOfMethod; // sorry for this disgusting fix to a ridiculous problem
		this.methodName = methodName;
		this.addChild(objectOfMethod);
		this.addChild(methodName);
	}
	
	/**
	 * Constructor for function calls
	 * If there are no arguments passed in, this will not have the argsList child, since it won't be added successfully
	 * 
	 * @param postfixType - must be PostfixType.FUNCTION_CALL
	 * @param functionName
	 * @param argsList
	 */
	public PostfixExpressionNode(PostfixType postfixType, IdNode functionName, ExpressionNode argsList) {
		super();
		this.postfixType = postfixType;
		this.functionName = functionName;
		this.addChild(functionName);
		this.addChild(argsList);
		
		if(argsList != null){
			this.hasArguments = true;
			this.argsList = argsList;
		}
		
		
	}	


	/**
	 * Constructor for method calls with params
	 * @param postFixType - must be PostfixType.METHOD_WITH_PARAMS
	 * @param objectName
	 * @param methodName
	 * @param argsList
	 */
	public PostfixExpressionNode(PostfixType postFixType,
			IdNode objectName, IdNode methodName,
			ExpressionNode argsList) {
		super();
		this.postfixType = postFixType;
		this.objectName = objectName;
		this.objectOfMethod = objectName; // sorry for this disgusting fix to a ridiculous problem
		this.methodName = methodName;
		this.addChild(objectName);
		this.addChild(methodName);
		this.addChild(argsList);
		if(argsList != null){
			this.hasArguments = true;
			this.argsList = argsList;
		}
	}

	public PostfixType getPostfixType() {
		return postfixType;
	}
	/** Method to Return the name getName()
	 * @return Returns a string with the node's name
	 */
	@Override
	public String getName() {
		StringBuilder sb = new StringBuilder();
		for (Node n : this.getChildren()) {
			sb.append(n.getName() + "' ");
		}
		return id + "-" + postfixType.toString() + "<" + this.getTypeName() + ">" + sb.toString() +
				"newscope: "+ isNewScope();
	}

	public boolean hasArguments(){
		return this.hasArguments;
	}
	
	public IdNode getFunctionName(){
		return this.functionName;
	}
	
	public ExpressionNode getArgsList(){
		return this.argsList;
	}
	
	public IdNode getMethodName(){
		return this.methodName;
	}
	
	public IdNode getObjectName(){
		return this.objectName;
	}
	
	public IdNode getObjectOfMethod(){
		return this.objectOfMethod;
	}
	
	/**
	 * returns true if this is a function call (as opposed to a method call)
	 * @return
	 */
	public boolean isFunction() {
		return (this.postfixType == PostfixType.FUNCTION_CALL);
	}
	
	/**
	 * returns true if this is a method call with or without params
	 * as opposed to a function call
	 * @return
	 */
	public boolean isMethod() {
		return (this.postfixType == PostfixType.METHOD_NO_PARAMS  || 
				this.postfixType == PostfixType.METHOD_WITH_PARAMS);
	}
	/**
	 * Regardless of whether this is a function call or a method call, this
	 * will return the name of the function.
	 * eg. myList.add() would return the IdNode for add
	 *     emit(1, 2) would return the IdNode for emit
	 * @return
	 */
	public IdNode getNameOfFunctionOrMethod() {
		if (this.isFunction())
			return this.getFunctionName();
		else
			return this.getMethodName();
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}