package util.ast.node;

import util.type.Types;
import back_end.Visitor;

public class SectionTypeNode extends Node {

	protected IdNode inputKeyIdNode;
	protected IdNode inputValueIdNode;
	protected Types.Type returnKey;
	protected Types.Type returnValue;


	public SectionTypeNode(IdNode inputKeyIdNode, IdNode inputValueIdNode, Types.Type returnKey,
			               Types.Type returnValue) {
		this.inputKeyIdNode = inputKeyIdNode;
		this.inputValueIdNode = inputValueIdNode;
		this.returnKey = returnKey;
		this.returnValue = returnValue;
	}
	

	public String getType() {
		return this.inputKeyIdNode.toString() + ", " + this.inputValueIdNode.toString()
				+ " -> " + this.returnKey.toString()
				+ this.returnValue.toString();
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);

	}

	@Override
	public String getName() {
		return "SectionTypeNode<" + this.getType() + ">";
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
