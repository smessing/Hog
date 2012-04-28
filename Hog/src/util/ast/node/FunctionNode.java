package util.ast.node;

import back_end.Visitor;

/**
 * A FunctionNode.
 * 
 * @author ben, sam
 *
 */
public class FunctionNode extends ExpressionNode {

	protected ParametersNode parameters;
	protected String identifier;

	public FunctionNode(TypeNode type, String name,
			ParametersNode parameters, StatementListNode instructions) {
		super(type);
		this.parameters = parameters;
		this.addChild(instructions);
		FunctionNode.LOGGER.fine("Constructing FunctionNode");
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	public String getIdentifier() {
		return identifier;
	}

	@Override
	public String toString() {
		return "FunctionNode-" + identifier;
	}
	
	@Override
	public String getName(){
		return "FunctionNode";
	}
	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
