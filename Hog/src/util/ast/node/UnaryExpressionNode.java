package util.ast.node;

import back_end.Visitor;

/**
 * A node representing the UnaryExpression nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class UnaryExpressionNode extends UnOpNode {
	
	public UnaryExpressionNode(ExpressionNode child, OpType opType) {
		super(child, opType);
	}

	@Override
	public String getName() {
		return "UnaryExpressionNode<" + this.getTypeName() + ">";
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public int visitorTest(Visitor v){
		v.visit(this);
		return 16;
	}
}
