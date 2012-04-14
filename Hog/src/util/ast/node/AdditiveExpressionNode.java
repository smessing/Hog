package util.ast.node;

import java.util.HashSet;
import java.util.Set;

import back_end.Visitor;

/**
 * A node representing the AdditiveExpression nonterminal in a parse tree.
 * 
 * @author ben
 *
 */
public class AdditiveExpressionNode extends BiOpNode {
	
	/**
	 * Define acceptable BiOpNode.OpType's for this node
	 */
	private static final Set<BiOpNode.OpType> acceptedOpTypes;
	
	static {
		acceptedOpTypes = new HashSet<BiOpNode.OpType>();
		acceptedOpTypes.add(OpType.PLUS);
		acceptedOpTypes.add(OpType.MINUS);
	}

	public AdditiveExpressionNode(OpType type, ExpressionNode left, ExpressionNode right) {
		super(type, left, right);
		
		// check if OpType is allowable
		if(!acceptedOpTypes.contains(type))
			throw new IllegalArgumentException("AdditiveExpressionNode initialized with unacceptable OpType: " + type.toString());
	}
	
	@Override
	public String getName() {
		return "AdditiveExpressionNode<" + this.getTypeName() + ","
				+ this.opType.toString() + ">";
	}
	
	@Override
	public void visit(Visitor v) {
		// TODO Auto-generated method stub

	}

}
