package util.ast.node;

import util.type.Types.Type;
import back_end.Visitor;

/**
 * Represents PostFixExpression productions for the following types of postfix expressions:
 *   array indexing, 
 *   method calls with no params,
 *   method calls with params 
 *   function calls
 *   
 *  Can check which it represents by calling getPostFixType
 *  
 * @author ben
 *
 */
public class PostFixExpressionNode extends ExpressionNode {
	
	public static enum PostFixType {
		ARRAY_INDEX, METHOD_NO_PARAMS, METHOD_WITH_PARAMS, FUNCTION_CALL
	}
	
	protected PostFixType postFixType;
	
	// for array indexing, method calls with no params, function calls
	public PostFixExpressionNode(PostFixType postFixType, ExpressionNode postFixExpr, 
			                     ExpressionNode expr) {
		super(Type.UNKNOWN);
		this.postFixType = postFixType;
		this.addChild(postFixExpr);
		this.addChild(expr);
	}
	
	// for method calls with params
	public PostFixExpressionNode(PostFixType postFixType, ExpressionNode postFixExpr,
			                     ExpressionNode id, ExpressionNode argsList) {
		super(Type.UNKNOWN);
		this.postFixType = postFixType;
		this.addChild(postFixExpr);
		this.addChild(id);
		this.addChild(argsList);
	}
	
	
	public PostFixType getPostFixType() {
		return postFixType;
	}

	@Override
	public String getName() {
		return postFixType.toString() + "<" + this.getTypeName() + ">";
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
			                     

}
