package util.ast.node;

import java.util.ArrayList;
import java.util.List;

import util.type.Types.Type;

/**
 * A node representing a primitive constant in a parse tree.
 * 
 * @author sam
 *
 * @param <E>
 */
public class ConstantNode<E> extends ExpressionNode {

	private E value;
	
	public ConstantNode() {
		this(new ArrayList<Node>());
	}
	
	public ConstantNode(List<Node> children) {
		this(children, null);
	}
	
	public ConstantNode(List<Node> children, Type type) {
		this(children, type, null);
	}
	
	public ConstantNode(List<Node> children, Type type, E value) {
		super(children, type);
		this.value = value;
	}
	
	public E getValue() {
		return this.value;
	}
	
	@Override
	public String getName() {
		return "ConstantNode<" + this.getTypeName() + ">";
	}
	
	
	
}
