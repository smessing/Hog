package util.ast.node;

import java.util.ArrayList;
import java.util.List;

import back_end.Visitor;

import util.type.Types;
import util.type.Types.Type;

/**
 * A node representing a primitive constant in a parse tree.
 * 
 * @author sam
 */
public class ConstantNode extends ExpressionNode {

	protected String value;
	
	public ConstantNode(Types.Type type, String value) {
		super(null, type);
		this.value = value;
		ConstantNode.LOGGER.info("Constructing ConstantNode");
	}
	
	public String getValue() {
		return this.value;
	}
		
	@Override
	public String getName() {
		return "ConstantNode<" + this.getTypeName() + ">";
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public int visitorTest(Visitor v){
		v.visit(this);
		System.out.println("in constant node");
		return 3;
	}
}
