package util.ast.node;

import util.type.Types;
import back_end.Visitor;

public class FunctionNode extends ExpressionNode {

	protected ParametersNode parameters;
	protected String name;
	
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

	@Override
	public String getName() {
		return "FunctionNode-" + name;
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
