package util.ast.node;

import back_end.Visitor;

/**
 * Represents the ArgumentExpressionList production. An ArgumentsNode contains a
 * list of IdNodes which specify the arguments for the function, method, or
 * constructor.
 * 
 * @author ben
 * 
 */
public class ArgumentsNode extends ExpressionNode {

	/**
	 * 
	 * @param args
	 *            - a (possibly empty) subtree of additional ArgumentsNodes.
	 * @param exp
	 *            - a (not empty) expression representing one actual parameter
	 *            to a function.
	 */
	public ArgumentsNode(ExpressionNode args, ExpressionNode exp) {
		super();
		if (exp == null) {
			throw new UnsupportedOperationException(
					"Attempted to create an ArgumentsNode with a null ExpressionNode!");
		}
		this.addChild(args);
		this.addChild(exp);
		ArgumentsNode.LOGGER.fine("Constructing ArgumentsNode");
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public String getName() {
		return id + "-ArgumentsNode";
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 41;
	}

}
