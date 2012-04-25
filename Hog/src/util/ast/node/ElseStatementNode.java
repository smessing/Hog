package util.ast.node;

public class ElseStatementNode extends StatementNode {

	public ElseStatementNode(StatementListNode child) {
		this.addChild(child);
	}

	@Override
	public String getName() {
		return "ElseStatementNode";
	}
}
