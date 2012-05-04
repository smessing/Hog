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
		return id + "-ConstantNode<" + this.getTypeName() + "> newscope: " + isNewScope();
	}

	public String getTypeShortName() {
		return "Something";
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

	@Override
	public String toSource() {
		Types.Primitive primType = ((PrimitiveTypeNode) type).getType();
		switch (primType) {
		case INT:
		case BOOL:
		case REAL:
		case TEXT:
			return getValue();
		}

		throw new UnsupportedOperationException("Primitive type: " + primType
				+ " not yet supported.");
	}
	
	public String toDeclarationSource() {
		Types.Primitive primType = ((PrimitiveTypeNode) type).getType();
		switch (primType) {
		case INT:
			return "new Integer(" + getValue() + ")";
		case BOOL:
			return "new Boolean(" + getValue() + ")";
		case TEXT:
			return "new String(\"" + getValue() + '"';
		}

		throw new UnsupportedOperationException("Primitive type: " + primType
				+ " not yet supported.");
	}
}
