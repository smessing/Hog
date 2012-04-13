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
		this(null, null, value);
	}
	
	public ConstantNode(List<Node> children, Type type, E value) {
		super(children, type);
		this.value = value;
	}
	
	public E getValue() {
		return this.value;
	}
	
	public Types.Type getValueType() {
		if (value instanceof Integer) {
			return Types.Type.INT;
		}
		return Types.Type.UNKNOWN;
	}
	
	@Override
	public String getName() {
		return "ConstantNode<" + this.getTypeName() + ">";
	}
	
	
	
}
