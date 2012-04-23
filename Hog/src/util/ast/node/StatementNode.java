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
public class StatementNode extends StatementListNode {
	
	public StatementNode() {
		this(new ArrayList<Node>());
	}

	public StatementNode(List<Node> children) {
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
