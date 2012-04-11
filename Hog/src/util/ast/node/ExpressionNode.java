package util.ast.node;

import util.type.Types;

/**
 * An abstract class inherited by all expression classes, specifying type information.
 * 
 * @author sam
 *
 */
public abstract class ExpressionNode extends Node {
	
	protected Types.Type type;
	
	
	public ExpressionNode() {
		this(null);
	}
	
	public ExpressionNode(Node parent) {
		this(parent, null);
	}
	
	public ExpressionNode(Node parent, Types.Type type) {
		super(parent);
		this.type = type;
	}
	
	public Types.Type getType() {
		return type;
	}
	
	protected void computeType() {
		throw new UnsupportedOperationException("TODO");
	}
	
	public void setType(Types.Type type) {
		this.type = type;
	}
	
	@Override
	public String getName() {
		return "ExpressionNode<" + this.getTypeName() + ">";
	}
	
	public String getTypeName() {
		if (type != null) {
			return type.toString();
		}
		return "unknown";
	}

}
