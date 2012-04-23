package util.ast.node;

import util.type.Types;

/**
 * @author ben
 *
 */
public class DerivedTypeNode extends TypeNode {
	
	protected Types.Derived localType;
	
	protected TypeNode innerTypeNode;
	
	public DerivedTypeNode(Types.Derived localType, TypeNode innerTypeNode) {
		this.localType = localType;
		this.innerTypeNode = innerTypeNode;
	}
	
	public Types.Derived getLocalType() {
		return localType;
	}
	
	public TypeNode getInnerTypeNode() {
		return innerTypeNode;
	}

}
