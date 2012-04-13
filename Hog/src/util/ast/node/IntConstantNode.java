package util.ast.node;

public class IntConstantNode extends ExpressionNode {
	
	protected Integer value;
	
	public IntConstantNode(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	@Override
	public String getName() {
		return "IntConstantNode";
	}

}
