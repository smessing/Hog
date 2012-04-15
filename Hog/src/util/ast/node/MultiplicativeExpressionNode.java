package util.ast.node;

import java.util.HashSet;
import java.util.Set;

import back_end.Visitor;

/**
 * A node representing the MultiplicativeExpression nonterminal in a parse tree.
 * 
 * @author sam & ben
 * 
 */
public class MultiplicativeExpressionNode extends BiOpNode {
	
	/**
	 * Define acceptable BiOpNode.OpType's for this node
	 */
	private static final Set<BiOpNode.OpType> acceptedOpTypes;
	
	static {
		acceptedOpTypes = new HashSet<BiOpNode.OpType>();
		acceptedOpTypes.add(OpType.TIMES);
		acceptedOpTypes.add(OpType.DIVIDE);
		acceptedOpTypes.add(OpType.MOD);
	}

	public MultiplicativeExpressionNode(OpType type, ExpressionNode left, ExpressionNode right) {
		super(type, left, right);
		
		// check if OpType is allowable
		if(!acceptedOpTypes.contains(type))
			throw new IllegalArgumentException("MultiplicativeExpressionNode initialized with unacceptable OpType: " + type.toString());
	}

	@Override
	public String getName() {
		return "MultiplicativeExpressionNode<" + this.getTypeName() + ","
				+ this.opType.toString() + ">";
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public int visitorTest(Visitor v){
		v.visit(this);
		return 11;
	}
}
