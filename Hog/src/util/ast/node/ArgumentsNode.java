package util.ast.node;

import back_end.Visitor;

/**
 * Represents the ArgumentExpressionList production. An ArgumentsNode contains a
 * list of IdNodes which specify the arguments for the function, method, or
 * constructor.
 * 
 * @author Benjamin Rapaport
 * 
 */
public class ArgumentsNode extends ExpressionNode {

	protected ExpressionNode argList;
	protected ExpressionNode arg;
	
	/**
	 * 
	 * @param args
	 *            - a (possibly empty) subtree of additional ArgumentsNodes.
	 * @param exp
	 *            - a (not empty) expression representing one actual parameter
	 *            to a function.
	 */
	public ArgumentsNode(ExpressionNode argList, ExpressionNode arg) {
		super();
		if (arg == null) {
			throw new UnsupportedOperationException(
					"Attempted to create an ArgumentsNode with a null ExpressionNode!");
		}
		this.addChild(argList);
		this.argList = argList;
		this.addChild(arg);
		this.arg = arg;
		ArgumentsNode.LOGGER.fine("Constructing ArgumentsNode");
	}

	public boolean hasMoreArgs() {
		return argList != null;
	}
	
	public ExpressionNode getMoreArgs() {
		return argList;
	}
	
	public ExpressionNode getArg() {
		return arg;
	}
	
	
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public String getName() {
		return id + "-ArgumentsNode. newscope: " + isNewScope();
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 41;
	}

}
