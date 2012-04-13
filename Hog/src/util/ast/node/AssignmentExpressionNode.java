package util.ast.node;

/**
 * A node representing an Assignment expression
 * 
 * @author ben
 *
 */
public class AssignmentExpressionNode extends ExpressionNode {
	
	public AssignmentExpressionNode(UnaryExpressionNode left, ExpressionNode right) {
		this.addChild(left);
		this.addChild(right);
	}
	
	@Override
	public String getName() {		
		return "AssignmentExpressionNode<" + this.getTypeName() + ">";
	}

}
