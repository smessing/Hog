package util.ast.node;

import back_end.Visitor;

public class SectionNode extends Node {
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public String getName() {
		return "SectionNode";
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
