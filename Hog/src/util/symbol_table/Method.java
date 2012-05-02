package util.symbol_table;

import java.util.ArrayList;

import front_end.sym;


public class Method{
	public String lexeme = "";
	public ArrayList<String> methods = new ArrayList<String>();
	
	public Method(String s, ArrayList<String> methods){
		this.lexeme = s; this.methods = methods;
	}
	
	public String toString(){
		return lexeme;
	}

	
}