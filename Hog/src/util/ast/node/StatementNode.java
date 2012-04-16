package util.ast.node;

import java.util.List;

import back_end.Visitor;

public class StatementNode extends Node {

	StatementNode(List<Node> children) {
		super(children);
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public String getName() {
		return "StatementNode";
	}

	@Override
	public int visitorTest(Visitor v) {
		return 0;
	}

}
