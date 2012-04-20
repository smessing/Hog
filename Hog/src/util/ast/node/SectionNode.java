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
	public SectionNode(Node list) {
		super();
		SectionNode.LOGGER.info("adding list child to @Functions or @Main SectionNode");
		this.addChild(list);
	}

	// use this constructor for @map and @reduce sections
	public SectionNode(SectionTypeNode type, StatementListNode list) {
		this.children = new ArrayList<Node>();
		SectionNode.LOGGER.info("adding list child to @Map or @Reduce SectionNode");
		this.addChild(type);
		this.addChild(list);
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
