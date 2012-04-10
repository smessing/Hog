package util.ast.node;

/**
 * A node representing the ID terminal in a parse tree.
 * 
 * @author sam
 *
 */
public class IdNode extends ExpressionNode {

	private String identifier;
	
	public IdNode() {
		this(null);
	}
	
	public IdNode(Node parent) {
		this(parent, "none");
	}
	
	public IdNode(Node parent, String id) {
		this(parent, id, null);
	}
	
	public IdNode(Node parent, String id, Type type) {
		super(parent, type);
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
