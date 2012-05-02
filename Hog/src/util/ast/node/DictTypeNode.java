package util.ast.node;

import back_end.Visitor;
import util.type.Types.Primitive;

/**
 * A node representing the dict type.
 * 
 * Dict types take two internal types, a key type and a value type. NOTE:
 * currently only primitive types can be used as the type of the key.
 * 
 * @author sam
 * 
 */
public class DictTypeNode extends DerivedTypeNode {

	protected Primitive key;
	protected TypeNode value;

	/**
	 * Construct a new DictTypeNode.
	 * 
	 * @param key
	 *            - the Primitive type of keys for this dict.
	 * @param value
	 *            - the TypeNode representing the type of the values for this
	 *            dict.
	 */
	public DictTypeNode(Primitive key, TypeNode value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Get the key type of this node.
	 * 
	 * @return - the Primitive type of keys for this dict.
	 */
	public Primitive getKeyType() {
		return key;
	}

	/**
	 * Get the value type of this node.
	 * 
	 * @return - the TypeNode representing the type of values for this dict.
	 */
	public TypeNode getValueType() {
		return value;
	}

	@Override
	public String getName() {
		return id + "-DictTypeNode";
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public boolean isDict() {
		return true;
	}

}
