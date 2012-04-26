package util.ast.node;

import back_end.Visitor;

/**
 * Represents the ArgumentExpressionList production.
 * An ArgumentsNode contains a list of IdNodes which
 * specify the arguments for the function, method, or
 * constructor.
 * 
 * @author ben
 *
 */
public class ArgumentsNode extends ExpressionNode {
	
	public ArgumentsNode(ExpressionNode arg, ExpressionNode exp) {
		super();
		this.addChild(arg);
		this.addChild(exp);
		ArgumentsNode.LOGGER.fine("Constructing ArgumentsNode");
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public String getName() {
		return "ArgumentsNode";
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 41;
	}

}
