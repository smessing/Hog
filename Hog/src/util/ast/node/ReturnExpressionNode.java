package util.ast.node;

import java.util.HashSet;
import java.util.Set;

import util.ast.node.BiOpNode.OpType;

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

}
