package util.ast.node;

import back_end.Visitor;

public class MockExpressionNode extends ExpressionNode {

	/*public MockExpressionNode() {
		super();
	}*/
	
	@Override
	public String getName() {
		return "MockExpressionNode<" + this.getTypeName() + ">";
	}
	
	@Override
	public void visit(Visitor v) {
		// do nothing
	}
	
	
}
