package util.ast.node;

import java.util.List;

import back_end.Visitor;

/**Represents the production for StatementList
 * 
 * @author ben
 *
 */
public class StatementListNode extends Node {
	
	public StatementListNode(List<Node> children) {
		this.children = children;
	}
	
	public StatementListNode(StatementListNode list, StatementNode statement) {
		super();
		this.addChild(list);
		this.addChild(statement);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		return "StatementListNode";
	}

}
