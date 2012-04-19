package util.ast.node;

import java.util.ArrayList;

import util.type.Types;

import back_end.Visitor;

/**
 * This node is for the @Functions, @Map, @Reduce and @Main sections
 * 
 * @author sam (commented by ben)
 *
 */
public class SectionNode extends Node {

	// Used to defined key-value pair types for input and ouput
	protected SectionTypeNode type;

	// use this constructor for @functions and @Main sections
	public SectionNode(StatementNode list) {
		this(new SectionTypeNode(null, null,
				Types.Type.NONE, Types.Type.NONE), list);
	}

	// use this constructor for @map and @reduce sections
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
