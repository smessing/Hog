/**
 * 
 */
package util.ast.node;

import java.util.List;

import back_end.Visitor;

/**
 * @author ben, paul
 *
 */
public abstract class TypeNode extends Node {

	public TypeNode() {
		// TODO Auto-generated constructor stub
	}

	public TypeNode(List<Node> children) {
		super(children);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}


}
