package util.ast.node;

import util.type.Types;
import back_end.Visitor;

public class FunctionNode extends ExpressionNode {

	protected ParametersNode parameters;
	
	public FunctionNode(Types.Type type, ParametersNode parameters, StatementNode instructions) {
		super(type);
		this.parameters = parameters;
		this.addChild(instructions);
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public String getName() {
		return "FunctionNode";
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
