package util.ast.node;

import java.util.List;

import back_end.Visitor;

/**
 * This node is used for the StatementList productions
 * 
 * @author ben
 *
 */
public class StatementNode extends Node {

	public StatementNode(List<Node> children) {
		super(children);
	}
	
	// used for production
	public StatementNode(StatementNode s1, StatementNode s2) {
		super();
		this.addChild(s1);
		this.addChild(s2);
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
