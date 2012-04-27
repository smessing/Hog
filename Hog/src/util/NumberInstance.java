package util;

public class NumberInstance implements VariableInstance<Object> {

	Identifier id;
	Identifier name;
	String type;
	String value;
	boolean isConstant;
	boolean isLocal;

	public NumberInstance(Identifier name, String type, String value,boolean isConstant){
		this.name = name;
		this.type = type;
		this.value = value;
		this.isConstant = isConstant;
		this.isLocal = true;
	}

	@Override
	public Identifier name() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String type() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public boolean isConstant() {
		// TODO Auto-generated method stub
		return isConstant;
	}

}