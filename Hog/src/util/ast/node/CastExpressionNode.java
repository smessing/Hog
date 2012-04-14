package util.ast.node;

import back_end.Visitor;
import util.type.Types.Type;

/**
 * A node representing the CastExpression nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class CastExpressionNode extends UnOpNode {

	protected Type castType;
	
	public CastExpressionNode(ExpressionNode node,Type type) {
		super(node, UnOpNode.OpType.CAST);
		this.type = type;
	}
	
	public Type getChildType() {
		throw new UnsupportedOperationException("TODO");
	}
	
	@Override
	public String getName() {
		return "CastExpressionNode<" + this.getTypeName() + ">";
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	

}
