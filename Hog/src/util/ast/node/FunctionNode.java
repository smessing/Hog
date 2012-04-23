package util.ast.node;

import util.type.Types;
import back_end.Visitor;

public class FunctionNode extends ExpressionNode {

	protected ParametersNode parameters;
	protected String identifier;
	
	public FunctionNode(Types.Type type, String name, ParametersNode parameters, StatementListNode instructions) {
		super(type);
		this.parameters = parameters;
		this.addChild(instructions);
		FunctionNode.LOGGER.info("Constructing FunctionNode");
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
		return "FunctionNode-" + identifier;
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
