package util.ast.node;

import java.util.ArrayList;

import util.type.Types;

import back_end.Visitor;

public class SectionNode extends Node {

	protected SectionTypeNode type;

	public SectionNode(StatementNode list) {
		this(new SectionTypeNode(Types.Type.NONE, Types.Type.NONE,
				Types.Type.NONE, Types.Type.NONE), list);
	}

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
