package util.ast.node;

import java.util.HashSet;
import java.util.Set;

import back_end.Visitor;

public class ReturnExpressionNode extends UnOpNode {

	/**
	 * Define acceptable BiOpNode.OpType's for this node
	 */
	private static final Set<UnOpNode.OpType> acceptedOpTypes;

	static {
		acceptedOpTypes = new HashSet<UnOpNode.OpType>();
		acceptedOpTypes.add(OpType.RETURN);
	}

	public ReturnExpressionNode(ExpressionNode child, OpType opType) {
		super(child, opType);

		// check if OpType is allowable
		if (!acceptedOpTypes.contains(type))
			throw new IllegalArgumentException(
					"AdditiveExpressionNode initialized with unacceptable OpType: "
							+ type.toString());
	}
	
	@Override 
	public String getName() {
		return "ReturnExpressionNode<" + this.getType() + ">";
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public int visitorTest(Visitor v) {
		return 0;
	}
	

}
