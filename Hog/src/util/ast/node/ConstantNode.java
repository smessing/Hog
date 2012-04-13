package util.ast.node;

import java.util.ArrayList;
import java.util.List;

import util.type.Types;
import util.type.Types.Type;

/**
 * A node representing a primitive constant in a parse tree.
 * 
 * @author sam
 */
public class ConstantNode<E> extends ExpressionNode {

	private E value;
	
	public ConstantNode(E value) {
		super(null, null);
		this.value = value;
		this.setType(this.getValueType());
	}
	
	public E getValue() {
		return this.value;
	}
	
	private Types.Type getValueType() {
		if (value instanceof Integer) {
			return Types.Type.INT;
		} else if (value instanceof Boolean) {
			return Types.Type.BOOL;
		} else if (value instanceof String) {
			return Types.Type.TEXT;
		} else if (value instanceof Double) {
			return Types.Type.REAL;
		}
		return Types.Type.UNKNOWN;
	}
	
	@Override
	public String getName() {
		return "ConstantNode<" + this.getTypeName() + ">";
	}
	
	
	
}
