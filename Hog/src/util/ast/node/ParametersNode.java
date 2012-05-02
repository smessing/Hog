package util.ast.node;

import back_end.Visitor;

/**
 * A node representing the Parameters nonterminal in a parse tree.
 * 
 * @author sam & ben
 * 
 * 
 */
public class ParametersNode extends ExpressionNode {

	protected String identifier;

	public ParametersNode(TypeNode type, String identifier) {
		super(type);
		this.identifier = identifier;
		ParametersNode.LOGGER
				.fine("Constructing ParametersNode with one param");
	}

	// deepest node in this chain is the first parameter in the list
	public ParametersNode(TypeNode type, String identifier,
			ParametersNode child) {
		super(type);
		this.addChild(child);
		this.identifier = identifier;
		ParametersNode.LOGGER
				.fine("Constructing ParametersNode with multiple params");
	}

	public String getIdentifier() {
		return identifier;
	}
	/** Method to Return the name getName()
	 * @return Returns a string with the node's name
	 */
	@Override
	public String getName() {
		return id + "-ParemetersNode<" + this.getTypeName() + " "
				+ this.getIdentifier() + "> newscope: " + isNewScope();
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public int visitorTest(Visitor v) {
		v.visit(this);
		return 12;
	}
}
