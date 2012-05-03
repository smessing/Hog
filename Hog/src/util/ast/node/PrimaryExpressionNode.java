package util.ast.node;

import back_end.Visitor;

/**
 * A node representing the PrimaryExpression nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class PrimaryExpressionNode extends ExpressionNode {
	/** Method to Return the name getName()
	 * @return Returns a string with the node's name
	 */
	@Override
	public String getName() {
		return id + "-PrimaryExpressionNode<" + this.getTypeName() + "> newscope: " + isNewScope();
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public int visitorTest(Visitor v){
		v.visit(this);
		return 14;
	}
}
