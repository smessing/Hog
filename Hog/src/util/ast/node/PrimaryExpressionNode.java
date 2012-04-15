package util.ast.node;

import back_end.Visitor;

/**
 * A node representing the PrimaryExpression nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class PrimaryExpressionNode extends ExpressionNode {

	@Override
	public String getName() {
		return "PrimaryExpressionNode<" + this.getTypeName() + ">";
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	
}
