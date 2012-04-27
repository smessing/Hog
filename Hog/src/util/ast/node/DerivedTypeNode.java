package util.ast.node;

import back_end.Visitor;
import util.type.Types;

/**
 * A DerivedTypeNode represents a derived type 
 * which contains a local type, and an inner type.
 * 
 * @author ben
 *
 */
public class DerivedTypeNode extends TypeNode {
	
	protected Types.Derived localType;
	protected TypeNode innerTypeNode;
	
	public DerivedTypeNode() {
		// empty method to satisfy java
	}
	
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
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Derived Type: " + localType.toString();
	}

}
