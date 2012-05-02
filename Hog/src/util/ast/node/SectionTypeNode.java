package util.ast.node;

import util.type.Types;
import back_end.Visitor;

public class SectionTypeNode extends Node {

	protected IdNode inputKeyIdNode;
	protected IdNode inputValueIdNode;
	protected TypeNode returnKey;
	protected TypeNode returnValue;


	/** Constructor SectionTypeNode(IdNode inputKeyIdNode, IdNode inputValueIdNode,
	 * 									TypeNode returnKey, TypeNode returnValue)
	 * 
	 * @param inputKeyIdNode
	 * @param inputValueIdNode
	 * @param returnKey
	 * @param returnValue
	 */
	public SectionTypeNode(IdNode inputKeyIdNode, IdNode inputValueIdNode, TypeNode returnKey,
			               TypeNode returnValue) {
		super();
		this.inputKeyIdNode = inputKeyIdNode;
		this.inputValueIdNode = inputValueIdNode;
		this.returnKey = returnKey;
		this.returnValue = returnValue;
	}
	
	/** Method getType()
	 * 
	 * @return
	 */
	public String getType() {
		return this.inputKeyIdNode.toString() + ", " + this.inputValueIdNode.toString()
				+ " -> " + this.returnKey.toString()
				+ this.returnValue.toString();
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);

	}
	
	public TypeNode getReturnKey() {
		return this.returnKey;
	}
	
	public TypeNode getReturnValue() {
		return this.returnValue;
	}
	
	public IdNode getInputKeyIdNode() {
		return this.inputKeyIdNode;
	}
	
	public IdNode getInputValueIdNode() {
		return this.inputValueIdNode;
	}
	
	
	/** Method to Return the name getName()
	 * @return Returns a string with the node's name
	 */
	@Override
	public String getName() {
		return id + "-SectionTypeNode<" + this.getType() + ">";
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
