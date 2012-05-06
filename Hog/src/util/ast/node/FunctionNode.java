package util.ast.node;

import back_end.Visitor;

/**
 * A FunctionNode.
 * 
 * @author Benjamin Rapaport
 * @author Samuel Messing
 * 
 */
public class FunctionNode extends ExpressionNode {

	protected ParametersNode parameters;
	protected StatementListNode instructions;
	protected String identifier;

	public FunctionNode(TypeNode type, String name, ParametersNode parameters,
			StatementListNode instructions) {
		super(type);
		this.identifier = name;
		this.parameters = parameters;
		if (instructions == null) {
			throw new UnsupportedOperationException(
					"Tried to create a FunctionNode without a body. Something is wrong!");
		}
		this.instructions = instructions;
		this.addChild(instructions);
		FunctionNode.LOGGER.fine("Constructing FunctionNode");
	}

	/**
	 * Method Returns The Parameters Node of Function Node
	 * 
	 * @return ParametersNode
	 */
	public ParametersNode getParametersNode() {
		return parameters;
	}

	public StatementListNode getInstructions() {
		return instructions;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	public String getIdentifier() {
		return identifier;
	}

	@Override
	public String getName() {
		return id + "-FunctionNode-" + identifier + "newscope: " + isNewScope();
	}

	@Override
	public String toSource(){
		return this.parameters.toSource();
	}
	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
