package util.ast.node;

public class IdNode extends ExpressionNode {

	private String identifier;
	
	public IdNode() {
		this(null);
	}
	
	public IdNode(Node parent) {
		super(parent);
		this.setIdentifier("none");
	}
	
	public IdNode(Node parent, String id) {
		this(parent);
		this.setIdentifier(id);
	}
	
	public IdNode(Node parent, String id, Type type) {
		this(parent, id);
		this.type = type;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}
	
	public String getName() {
		return "IdNode<" + this.getTypeName() + "> " + this.getIdentifier();
	}

}
