package util.ast.node;

import java.util.ArrayList;
import java.util.List;

import back_end.Visitor;

import util.type.Types;

/**
 * A node representing a primitive constant in a parse tree.
 * 
 * @author sam
 */
public class ConstantNode extends ExpressionNode {

	protected String value;

	/**
	 * Construct a new ConstantNode
	 * 
	 * @param type
	 *            - the PrimitiveType of this node.
	 * @param value
	 *            - the actual value (in string form) of this node.
	 */
	public ConstantNode(Types.Primitive type, String value) {
		super(new PrimitiveTypeNode(type), new ArrayList<Node>());
		this.value = value;
		ConstantNode.LOGGER.fine("Constructing ConstantNode");
	}

	/**
	 * Get a String representation of this value.
	 * 
	 * @return the String representation of this value.
	 */
	public String getValue() {
		return this.value;
	}

	@Override
	public String getName() {
		return "ConstantNode<" + this.getTypeName() + ">";
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public int visitorTest(Visitor v) {
		v.visit(this);
		System.out.println("in constant node");
		return 3;
	}
}
