package util.ast.node;

import util.type.Types;

/**
 * @author ben
 *
 */
public class PrimitiveTypeNode extends TypeNode {
	
	protected Types.Primitive localType;
	
	public PrimitiveTypeNode(Types.Primitive type) {
		localType = type;
	}
	
	public Types.Primitive getType() {
		return localType;
	}

}
