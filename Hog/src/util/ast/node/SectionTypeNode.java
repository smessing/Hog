package util.ast.node;

import util.type.Types;
import back_end.Visitor;

public class SectionTypeNode extends Node {

	protected Types.Type inputKey;
	protected Types.Type inputValue;
	protected Types.Type returnKey;
	protected Types.Type returnValue;

	public SectionTypeNode(Types.Type inputKey, Types.Type inputValue,
			Types.Type returnKey, Types.Type returnValue) {
		this.inputKey = inputKey;
		this.inputValue = inputValue;
		this.returnKey = returnKey;
		this.returnValue = returnValue;
	}

	public String getType() {
		return this.inputKey.toString() + ", " + this.inputValue.toString()
				+ " -> " + this.returnKey.toString()
				+ this.returnValue.toString();
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);

	}

	@Override
	public String getName() {
		return "SectionTypeNode<" + this.getType() + ">";
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
