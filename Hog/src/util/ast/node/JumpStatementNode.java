package util.ast.node;

import back_end.Visitor;

/**
 * A JumpStatementNode represents either a Continue, Break,
 * or Return construct, and returns have expression statements.
 * 
 * 
 * @author ben
 * 
 */
public class JumpStatementNode extends StatementNode {

	public static enum JumpType {
		CONTINUE, BREAK, RETURN;
	}

	protected JumpType jumpType;

	public JumpStatementNode(JumpType jumpType, StatementNode e) {
		this(jumpType);
		this.addChild(e);
	}

	public JumpStatementNode(JumpType jumpType) {
		this.jumpType = jumpType;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public String toString() {
		return "JumpStatement: " + jumpType.toString();
	}

	@Override
	public String getName(){
		return "JumpStatementNode";
	}
	
	@Override
	public int visitorTest(Visitor v) {
		return 0;
	}
}
