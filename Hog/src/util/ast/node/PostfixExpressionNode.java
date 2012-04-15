package util.ast.node;

import back_end.Visitor;

/**
 * A node representing the PostfixExpression nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class PostfixExpressionNode extends UnOpNode {
	
	public PostfixExpressionNode(ExpressionNode child, OpType opType) {
		super(child, opType);
	}

	@Override
	public String getName() {
		return "PostfixExpressionNode<" + this.getTypeName() + ">";
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public int visitorTest(Visitor v){
		v.visit(this);
		return 13;
	}
}
