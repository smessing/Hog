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
	/** enum PostfixType 
	 *  values ARRAY_INDEX,METHOD_NO_PARAMS, METHOD_WITH_PARAMS, FUNCTION_CALL
	 *
	 */
	public static enum PostfixType {
		ARRAY_INDEX, METHOD_NO_PARAMS, METHOD_WITH_PARAMS, FUNCTION_CALL
	}
	/** postfixType field which is of type PostfixType */
	protected PostfixType postfixType;

	/**
	 * Constructor for method calls with no parameters
	 * 
	 * @param objectOfMethod
	 * @param methodName
	 */
	public PostfixExpressionNode(IdNode objectOfMethod, IdNode methodName) {
		super();
		postfixType = PostfixType.METHOD_NO_PARAMS;
		this.addChild(objectOfMethod);
		this.addChild(methodName);
	}
	
	/**
	 * Constructor for function calls
	 * If there are no arguments passed in, this will not have the argsList child
	 * 
	 * @param postfixType - must be PostfixType.FUNCTION_CALL
	 * @param functionName
	 * @param argsList
	 */
	public PostfixExpressionNode(PostfixType postfixType, IdNode functionName, ExpressionNode argsList) {
		super();
		this.postfixType = postfixType;
		this.addChild(functionName);
		this.addChild(argsList);
	}	
	
	

	// for method calls with params
	public PostfixExpressionNode(PostfixType postFixType,
			ExpressionNode postfixExpr, ExpressionNode id,
			ExpressionNode argsList) {
		super();
		this.postfixType = postFixType;
		this.addChild(postfixExpr);
		this.addChild(id);
		this.addChild(argsList);
	}

	public PostfixType getPostfixType() {
		return postfixType;
	}
	/** Method to Return the name getName()
	 * @return Returns a string with the node's name
	 */
	@Override
	public String getName() {
		return postfixType.toString() + "<" + this.getTypeName() + ">";
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}