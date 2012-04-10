package util.ast.node;

public class MultiplicativeExpressionNode extends Node {

	private int compareTo(MultiplicativeExpressionNode that) {
		return (this.getName().compareTo(that.getName()));
	}
	
	@Override
	public int compareTo(Node that) {
		if (that instanceof MultiplicativeExpressionNode) {
			return this.compareTo((MultiplicativeExpressionNode) that);
		}
		return -1;
	}

}
