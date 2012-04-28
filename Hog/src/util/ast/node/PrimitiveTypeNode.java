package util.ast.node;

import back_end.Visitor;
import util.type.Types;

/**
 * @author ben, paul
 *
 */
public class PrimitiveTypeNode extends TypeNode {
	
	/** localType field which contains Types.Primitive */
	protected Types.Primitive localType;
	/** Constructor of PrimitiveTypeNode(Types.Primitive type)
	 * 
	 * @param type
	 */
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
	/** Method toString() Returns the string representation of Node
	 * @return Returns a string with the node's name
	 */
	@Override
	public String toString() {
		return "Primitive Type: " + localType.toString();
	}
	
	@Override
	public String getName(){
		return "PrimitiveTypeNode";
	}
	

}
