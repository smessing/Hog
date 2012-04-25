package util;

import util.type.Types;

/*
 * 
 * 
 * 
 */

public class DerivedIdentifier extends Identifier{
	
	Types.Derived derivedType;

	//private int line;
	//private int column;
	//private int offset;

	public DerivedIdentifier(Types.Primitive primType, Types.Derived derType, String value){
		super(primType, value);
		this.derivedType = derType;
	}

	public boolean equals(Object o){
		if(o == null){
			return false;
		}
		return this == o;
	}

	//public int hashCode(){
		//return hash;
	//}

	public String toString(){
		return type.toString() + " " + derivedType.toString() + " " + value;
	}

	/*public int line(){
		return line;
	}

	public int column(){
		return column;
	}

	public int offset(){
		return offset;
	}*/

}