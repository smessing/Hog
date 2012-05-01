/**
 * 
 */
package util.ast.node;

import java.util.List;

import util.type.Types;

import back_end.Visitor;

/**
 * @author ben, paul, sam
 *
 */
public abstract class TypeNode extends Node {
	

	public TypeNode() {
	
	}

	public TypeNode(List<Node> children) {
		super(children);
	}

	/**
	 * Ask if this node is the same type as the passed in node. 
	 * Tests for structural equivalence.
	 * @param that - the node to compare to
	 * @return true if the two nodes are same type, false otherwise.
	 */
	public boolean isSameType(TypeNode that) {
		return Types.isSameType(this, that);
	}
	
	/**
	 * Ask if this node is of type BOOL.
	 * 
	 * @return true if this node is of type BOOL, false otherwise.
	 */
	public abstract boolean isBoolean();
	
	/**
	 * Ask if this node is of type number ({REAL, INT}).
	 * 
	 * @return true if this node is of a numeric type, false otherwise.
	 */
	public abstract boolean isNumeric();
	
	/**
	 * Ask if this node is of type TEXT.
	 * 
	 * @return true if this node is of type TEXT, false otherwise.
	 */
	public abstract boolean isText();
	
	/**
	 * Ask if this node is of primitive type.
	 * 
	 * @return true if this node is a primitive type, false otherwise.
	 */
	public abstract boolean isPrimitive();
	
	/**
	 * Ask if this node is of derived type.
	 * 
	 * @return true if this node is a derived type, false otherwise.
	 */
	public abstract boolean isDerived();
	
	/**
	 * Ask if this node is of dict type.
	 * 
	 * @return true if this node is a dict, false otherwise.
	 */
	public abstract boolean isDict();

	/**
	 * Ask if this node is of exception type.
	 * 
	 * @return true if this node is an exception, false otherwise.
	 */
	public abstract boolean isException();
	
}
