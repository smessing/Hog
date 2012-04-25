package util;

import util.type.Types;

/*
 * 
 * 
 * 
 */

public class Identifier{

	Types type;
	String value;

	//private int line;
	//private int column;
	//private int offset;

	public Identifier(Types type, String value){
		this.type = type;
		this.value = value;
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
		return type.toString() + " " + value;
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