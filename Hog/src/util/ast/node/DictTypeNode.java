package util.ast.node;

import back_end.Visitor;
import util.type.Types.Primitive;

public class DictTypeNode extends DerivedTypeNode {

	protected Primitive key;
	protected TypeNode value;
	
	public DictTypeNode(Primitive key, TypeNode value) {
		this.key = key;
		this.value = value;
	}

	public Primitive getKey() {
		return key;
	}
	
	public TypeNode getValue() {
		return value;
	}
	
	@Override
	public String getName() {
		return "DictTypeNode";
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
}
