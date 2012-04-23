/**
 * 
 */
package util.ast.node;

import java.util.List;

import back_end.Visitor;

/**
 * @author ben
 *
 */
public class TypeNode extends Node {

	/**
	 * 
	 */
	public TypeNode() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param children
	 */
	public TypeNode(List<Node> children) {
		super(children);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see util.ast.node.Node#accept(back_end.Visitor)
	 */
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see util.ast.node.Node#visitorTest(back_end.Visitor)
	 */
	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see util.ast.node.Node#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
