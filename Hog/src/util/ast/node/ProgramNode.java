package util.ast.node;

import java.util.ArrayList;

import back_end.Visitor;

public class ProgramNode extends Node {

	protected SectionNode functions;
	protected SectionNode map;
	protected SectionNode reduce;
	protected SectionNode main;

	public ProgramNode(SectionNode functions, SectionNode map,
			SectionNode reduce, SectionNode main) {
		this.functions = functions;
		this.map = map;
		this.reduce = reduce;
		this.main = main;
		this.children = new ArrayList<Node>();
		children.add(functions);
		children.add(map);
		children.add(reduce);
		children.add(main);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);

	}

	@Override
	public String getName() {
		return "ProgramNode";
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
