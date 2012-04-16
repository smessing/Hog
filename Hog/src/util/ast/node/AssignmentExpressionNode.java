package util.ast.node;

import java.util.HashSet;
import java.util.Set;

import back_end.Visitor;

public class AssignmentExpressionNode extends BiOpNode {
	
	/**
	 * Define acceptable BiOpNode.OpType's for this node
	 */
	private static final Set<BiOpNode.OpType> acceptedOpTypes;
	
	static {
		acceptedOpTypes = new HashSet<BiOpNode.OpType>();
		acceptedOpTypes.add(OpType.ASSIGN);
	}

	public AssignmentExpressionNode(OpType type, ExpressionNode left,
			ExpressionNode right) {
		super(type, left, right);
		
		// check if OpType is allowable
		if(!acceptedOpTypes.contains(type))
			throw new IllegalArgumentException("AdditiveExpressionNode initialized with unacceptable OpType: " + type.toString());
	}
	
	@Override
	public String getName() {
		return "AssignmentExpressionNode";
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);

	}
	
	@Override
	public int visitorTest(Visitor v){
		v.visit(this);
		return 1;
	}

	
	
}
