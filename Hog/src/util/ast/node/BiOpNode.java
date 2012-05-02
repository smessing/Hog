package util.ast.node;

import back_end.Visitor;

/**
 * A node representing the Binary Operator terminals in a parse tree.
 * 
 * Note: while not prescribed here, it is assumed that all classes that inherit
 * from BiOpNode have a method evaluate() that returns the evaluation of the
 * expression node. The type of this method should be determined by the type of
 * the node (i.e. multiplicativeExpressionNodes return a number type, and
 * booleanExpressionNodes return a boolean type).
 * 
 * @author sam
 * 
 */
public class BiOpNode extends ExpressionNode {

	public static enum OpType {
		ASSIGN, MINUS, PLUS, DIVIDE, TIMES, MOD, LESS, GRTR, LESS_EQL, GRTR_EQL, DBL_EQLS, NOT_EQLS, OR, AND
	}

	protected ExpressionNode left;
	protected ExpressionNode right;
	protected OpType opType;

	/**
	 * Create a new Binary Operator Node.
	 * 
	 * @param type
	 *            - the binary operator (e.g. '-', '+', '=').
	 * @param left
	 *            - the left operand.
	 * @param right
	 *            - the right operand.
	 * @throws UnsupportedOperationException - if the left or right operand is null.
	 */
	public BiOpNode(OpType type, ExpressionNode left, ExpressionNode right) throws UnsupportedOperationException {
		// note implicitly sets children.parent = this
		super();
		if (left == null || right == null) {
			throw new UnsupportedOperationException(
					"Tried to create a BiOpNode with empty operands! OpType: "
							+ type + ", Left: " + left + ", Right: " + right);
		}
		BiOpNode.LOGGER.fine("Constructing BiOpNode");
		this.opType = type;
		this.left = left;
		this.right = right;
		this.addChild(left);
		this.addChild(right);

	}
	
	/** Method returns left child.
	 * 
	 * @return
	 */
	public ExpressionNode getLeftNode(){
		return this.left;
	}
	
	/** Method returns right child.
	 * 
	 * @return
	 */
	public ExpressionNode getRightNode(){
		return this.right;
	}

	/**
	 * Get the OpType of this Binary Operator Node.
	 * 
	 * @return - the OpType of this node.
	 */
	public OpType getOpType() {
		return opType;
	}

	/**
	 * Set the OpType of this Binary Operator Node.
	 * 
	 * @param type - the new type of this node.
	 */
	public void setOpType(OpType type) {
		this.opType = type;
	}

	@Override
	public String getName() {
		return "BiOpNode<" + opType.toString() + ">";
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 42;
	}

	
	
}
