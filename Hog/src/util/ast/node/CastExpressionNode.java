package util.ast.node;

import util.type.Types.Type;

/**
 * A node representing the CastExpression nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class CastExpressionNode extends ExpressionNode {

	protected Type castType;
	
	CastExpressionNode(ExpressionNode node, Type castType) {
		this.castType = castType;
		this.addChild(node);
	}
	
	public Type getChildType() {
		throw new UnsupportedOperationException("TODO");
	}
	
	@Override
	public String getName() {
		return "CastExpressionNode<" + this.getTypeName() + ">";
	}

}
