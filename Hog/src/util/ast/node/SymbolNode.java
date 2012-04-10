package util.ast.node;

/**
 * A node representing all pure-syntax terminals in a parse tree.
 * 
 * TODO: is this class necessary?? Do we need these nodes in the parse tree?
 * 
 * @author sam
 *
 */
public class SymbolNode extends Node {

	public static enum SymType {
		ARROW, DOT, COMMA, SEMICOl, L_PAREN, R_PAREN 
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
