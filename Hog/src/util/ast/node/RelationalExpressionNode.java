package util.ast.node;

import java.util.HashSet;
import java.util.Set;
import back_end.Visitor;

/**
 * A node representing a RelationalExpression nonterminal
 *  
 * @author ben
 *
 */
public class RelationalExpressionNode extends BiOpNode {
	
	/**
	 * Define acceptable BiOpNode.OpType's for this node
	 */
	private static final Set<BiOpNode.OpType> acceptedOpTypes;
	
	static {
		acceptedOpTypes = new HashSet<BiOpNode.OpType>();
		acceptedOpTypes.add(OpType.LESS);
		acceptedOpTypes.add(OpType.GRTR);
		acceptedOpTypes.add(OpType.LESS_EQL);
		acceptedOpTypes.add(OpType.GRTR_EQL);
	}

	public RelationalExpressionNode(OpType type, ExpressionNode left, ExpressionNode right) {
		super(type, left, right);
		
		// check if OpType is allowable
		if(!acceptedOpTypes.contains(type))
			throw new IllegalArgumentException("RelationalExpressionNode initialized with unacceptable OpType: " + type.toString());
	}

	@Override
	public String getName() {
		return "RelationalExpressionNode<" + this.getTypeName() + ","
				+ this.opType.toString() + ">";
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public int visitorTest(Visitor v){
		v.visit(this);
		return 15;
	}
}