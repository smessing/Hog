package util.ast.node;

import back_end.Visitor;
import util.type.Types;

/**
 * @author ben, paul
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
		return "Primitive Type: " + localType.toString();
	}

}
