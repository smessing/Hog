package util.ast.node;

/**
 * A node representing the Parameters nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class ParametersNode extends ExpressionNode {

	public ParametersNode() {
		this(null);
	}
	
	public ParametersNode(Node parent) {
		super(parent);
	}
	
	@Override
	public String getName() {
		return "ParemetersNode<" + this.getTypeName() + ">";
	}
	
}
