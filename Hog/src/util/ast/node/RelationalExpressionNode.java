package util.ast.node;

import java.util.HashSet;
import java.util.Set;
import back_end.Visitor;

/**
 * [deprecated]
 * A node representing a RelationalExpression nonterminal
 *  
 * @author Benjamin Rapaport 
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

	/** Constructor of RelationalExpressionNode(OpType type, ExpressionNode left,
	 * 													ExpressionNode right)
	 *
	 * @param type
	 * @param left
	 * @param right
	 */
	public RelationalExpressionNode(OpType type, ExpressionNode left, ExpressionNode right) {
		super(type, left, right);
		
		// check if OpType is allowable
		if(!acceptedOpTypes.contains(type))
			throw new IllegalArgumentException("RelationalExpressionNode initialized with unacceptable OpType: " + type.toString());
	}
	/** Method to Return the name getName()
	 * @return Returns a string with the node's name
	 */
	@Override
	public String getName() {
		return id + "-RelationalExpressionNode<" + this.getTypeName() + ","
				+ this.opType.toString() + "> newscope: " + isNewScope();
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
