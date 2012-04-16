package util.ast.node;

import util.type.Types;
import back_end.Visitor;

/**
 * A node representing the Parameters nonterminal in a parse tree.
 * 
 * @author sam
 *
 */
public class ParametersNode extends ExpressionNode {
	
	protected String identifier;
	
	public ParametersNode(Types.Type type, String identifier) {
		super(type);
		this.identifier = identifier;
	}
	
	public ParametersNode(Types.Type type, String identifier, ParametersNode child) {
		super(type);
		this.addChild(child);
		this.identifier = identifier;
	}
	
	@Override
	public String getName() {
		return "ParemetersNode<" + this.getTypeName() + ">";
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public int visitorTest(Visitor v){
		v.visit(this);
		return 12;
	}
}
