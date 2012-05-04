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
	
	protected ExpressionNode expNode;
	protected ExpressionNode argNode;

	protected ExpressionNode argList;
	protected ExpressionNode arg;
	
	/**
	 * 
	 * @param args
	 *            - a (possibly empty) subtree of additional ArgumentsNodes.
	 * @param exp
	 *            - a (not empty) expression representing one actual parameter
	 *            to a function.
	 *            
	 *  Deepest node in the tree is the first argument
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
		this.expNode = arg;
		this.argNode = argList;
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
	
	public ExpressionNode getArgumentsNode() {
		return this.argNode;
	}
	
	public ExpressionNode getExpressionNode() {
		return this.expNode;
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
	
	/**
	 * 
	 * @return the number of arguments the node represents
	 */
	public int getNumArguments() {
		return getNumArgsHelper(0);
	}
	
	/**
	 * Helper function to get number of arguments
	 * @param numArgs
	 * @return
	 */
	private int getNumArgsHelper(int numArgs) {
		if (this.getArgumentsNode() == null) {
			return numArgs + 1;
		}
		else {
			return ((ArgumentsNode) this.argNode).getNumArgsHelper(numArgs + 1);
		}
	}
	
	

}
