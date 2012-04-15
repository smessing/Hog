package util.ast.node;

import back_end.Visitor;

/**
 * A node representing the Parameters nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class ParametersNode extends ExpressionNode {
	
	@Override
	public String getName() {
		return "ParemetersNode<" + this.getTypeName() + ">";
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	
}
