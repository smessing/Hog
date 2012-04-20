package util.ast.node;

import java.util.ArrayList;
import java.util.List;

import back_end.Visitor;

/**
 * This node is used for the StatementList productions
 * 
 * @author ben
 *
 */
public class StatementNode extends Node {
	
	public StatementNode() {
		this(new ArrayList<Node>());
	}

	public StatementNode(List<Node> children) {
		super(children);
	}
	
//	// for production StatementList -> StatementList Statement
//	public StatementNode(StatementNode s1, StatementNode s2) {
//		super();
//		StatementNode.LOGGER.info("Before adding StatementNode s1 to StatementNode Children list");
//		this.addChild(s1);
//		StatementNode.LOGGER.info("Before adding StatementNode s2 to StatementNode Children list");
//		this.addChild(s2);
//	}
	
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
