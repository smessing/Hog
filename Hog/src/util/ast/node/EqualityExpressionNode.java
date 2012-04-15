package util.ast.node;

import java.util.HashSet;
import java.util.Set;
import back_end.Visitor;

/**
 * A node representing an EqualityExpression nonterminal
 * 
 * @author ben
 *
 */
public class EqualityExpressionNode extends BiOpNode {

	/**
	 * Define acceptable BiOpNode.OpType's for this node
	 */
	private static final Set<BiOpNode.OpType> acceptedOpTypes;
	
	static {
		acceptedOpTypes = new HashSet<BiOpNode.OpType>();
		acceptedOpTypes.add(OpType.DBL_EQLS);
		acceptedOpTypes.add(OpType.NOT_EQLS);
	}

	public EqualityExpressionNode(OpType type, ExpressionNode left, ExpressionNode right) {
		super(type, left, right);
		
		// check if OpType is allowable
		if(!acceptedOpTypes.contains(type))
			throw new IllegalArgumentException("EqualityExpressionNode initialized with unacceptable OpType: " + type.toString());
	}

	@Override
	public String getName() {
		return "EqualityExpressionNode<" + this.getTypeName() + ","
				+ this.opType.toString() + ">";
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
