package util.ast.node;

import java.util.ArrayList;

import back_end.Visitor;

public class SectionNode extends Node {
	
	protected SectionTypeNode type;
	
	public SectionNode(SectionTypeNode type, StatementNode list) {
		this.children = new ArrayList<Node>();
		this.addChild(list);
		this.type = type;
	}
	
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
