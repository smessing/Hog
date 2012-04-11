package util.ast.node;

import java.util.List;

/**
 * A node representing the ID terminal in a parse tree.
 * 
 * @author sam
 *
 */
public class IdNode extends ExpressionNode {

	private String identifier;
	
	public IdNode(List<Node> children, String id) {
		this(children, id, null);
	}
	
	public IdNode(List<Node> children, String id, Type type) {
		super(children, type);
		this.setIdentifier(id);
		this.type = type;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}
	
	@Override
	public String getName() {
		return "IdNode<" + this.getTypeName() + "> " + this.getIdentifier();
	}

}
