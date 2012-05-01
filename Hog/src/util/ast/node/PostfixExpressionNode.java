package util.ast.node;

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

	// for array indexing, method calls with no params, function calls
	/** Constructor PostfixExpressionNode(PostfixType postfixType, ExpressionNode postfixExpr,
	 * ExpressionNode expr)
	 * 
	 * @param postfixType
	 * @param postfixExpr
	 * @param expr
	 */
	public PostfixExpressionNode(PostfixType postfixType,
			ExpressionNode postfixExpr, ExpressionNode expr) {
		super();
		this.postfixType = postfixType;
		this.addChild(postfixExpr);
		this.addChild(expr);
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