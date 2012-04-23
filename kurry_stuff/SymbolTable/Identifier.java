/*
 * 
 * 
 * 
 */

public class Identifier{
	 
	String name;
	int hash;
	
	private int line;
	private int column;
	private int offset;
	
	private Identifier(String name, int hash){
		this.name = name;
		this.hash = hash;
	}
	
	public boolean equals(Object o){
		if(o == null){
			return false;
		}
		return this == o;
	}
	
	public int hashCode(){
		return hash;
	}
	
	public String toString(){
		return name;
	}
	
	public int line(){
		return line;
	}
	
	public int column(){
		return column;
	}
	
	public int offset(){
		return offset;
	}
	
}
