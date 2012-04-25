package util.ast.node;

import back_end.Visitor;
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
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Primitive Type: " + localType.toString();
	}

}
