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
	public void accept(Visitor v) {
		// do nothing
	}
	
	@Override
	public int visitorTest(Visitor v){
		v.visit(this);
		return 9;
	}
}
