package util.ast.node;

import java.util.ArrayList;

import back_end.Visitor;

import util.type.Types;
import util.type.Types.Type;

/**
 * A node representing the Unary Operator terminals in a parse tree.
 * 
 * @author sam
 *
 */
public class UnOpNode extends ExpressionNode {
	
	// note: NONE means no unary operator applied.
	public static enum OpType {
		UMINUS, NOT, RETURN, INCR, DECR, CAST, NONE
	}
	
	protected OpType opType;
	
	public UnOpNode(OpType opType, ExpressionNode child) {
		this(opType, child, Type.UNKNOWN);
	}
	
	public UnOpNode(OpType opType, ExpressionNode child, Type type) {
		super(type);
		// note implicitly sets child.parent = this
		this.addChild(child);
		this.opType = opType;
	}
	
	
	public OpType getOpType() {
		return opType;
	}

	@Override
	public String getName() {
		return opType.toString() + "<" + this.getTypeName() + ">";
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public int visitorTest(Visitor v){
		v.visit(this);
		return 17;
	}
}
