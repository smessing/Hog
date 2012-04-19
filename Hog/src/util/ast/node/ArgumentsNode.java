package util.ast.node;

import back_end.Visitor;

/**
 * Represents the ArgumentExpressionList production
 * 
 * @author ben
 *
 */
public class ArgumentsNode extends ExpressionNode {
	
	public ArgumentsNode(ExpressionNode args, ExpressionNode exp) {
		super();
		this.addChild(args);
		this.addChild(exp);
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public String getName() {
		return "ExpressionNode";
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
