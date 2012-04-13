package util.ast.node;

import java.util.ArrayList;
import java.util.List;

import util.type.Types.Type;

/**
 * A node representing the ID terminal in a parse tree.
 * 
 * @author sam
 * 
 */
public class IdNode extends ExpressionNode {

	private String identifier;

	public IdNode(String id) {
		this(id, null);
	}

	public IdNode(String id, Type type) {
		super(null, type);
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
		return "IdNode<" + this.getTypeName() + "," + this.getIdentifier()
				+ ">";
	}

}
