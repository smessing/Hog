/**
 * 
 */
package util.ast.node;


import back_end.Visitor;
import util.type.Types;

/**
 * This class is only used as the TypeNode for reserved words with no types
 * in the symbol table. It's localType is Types.Flags.RESERVED_WORD
 * 
 * @author Benjamin Rapaport
 *
 */
public class ReservedWordTypeNode extends TypeNode {

	/** localType field that contains Types.Flags
	 * 
	 */
	protected Types.Flags localType;

	/** Constructor of ReservedWordTypeNode(Types.Flags type)
	 * 
	 * @param type
	 */
	public ReservedWordTypeNode(Types.Flags type) {
		localType = type;
	}
	
	public Types.Flags getType() {
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
	/** Method to Return the name getName()
	 * @return Returns a string with the node's name
	 */
	@Override
	public String getName() {
		return id + "-Reserved Word Type: " + localType.toString();
	}

	@Override
	public boolean isBoolean() {
		return false;
	}

	@Override
	public boolean isNumeric() {
		return false;
	}

	@Override
	public boolean isText() {
		return false;
	}

	@Override
	public boolean isPrimitive() {
		return false;
	}

	@Override
	public boolean isDerived() {
		return false;
	}

	@Override
	public boolean isDict() {
		return false;
	}

	@Override
	public boolean isException() {
		return false;
	}
	
	

}
