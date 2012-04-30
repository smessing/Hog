/**
 * 
 */
package util.ast.node;

import java.util.List;

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
	public abstract boolean isSameType(TypeNode that);
	
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

}
