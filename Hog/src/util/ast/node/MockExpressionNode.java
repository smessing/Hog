package util.ast.node;

public class MockExpressionNode extends ExpressionNode {

	/*public MockExpressionNode() {
		super();
	}*/
	
	@Override
	public String getName() {
		return "MockExpressionNode<" + this.getTypeName() + ">";
	}
	
}
