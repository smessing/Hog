package util.ast.node;

public class SymbolNode extends Node {

	public static enum SymType {
		ARROW, DOT, COMMA, SEMICOl
	}

	private SymType symType;
	
	public SymbolNode() {
		this(null);
	}
	
	public SymbolNode(Node parent) {
		this(parent, null);
	}
	
	public SymbolNode(Node parent, SymType type) {
		super(parent);
		this.symType = type;
	}
	
	@Override
	public String getName() {
		return "SymbolNode<" + this.getSymTypeName() + ">";
	}
	
	private String getSymTypeName() {
		if (symType != null) {
			return symType.toString();
		}
		return "none";
	}

}
