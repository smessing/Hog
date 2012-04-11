package util.ast.node;

/**
 * A node representing the Parameters nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class ParametersNode extends ExpressionNode {
	
	@Override
	public String getName() {
		return "ParemetersNode<" + this.getTypeName() + ">";
	}
	
}
