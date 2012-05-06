package util.symbol_table;

import front_end.sym;

/**
 * [deprecated]
 * @author Jason Halpern
 *
 */
public class Word{
	public String lexeme = "";
	public int tag;
	
	public Word(String s, int tag){
		this.lexeme = s; this.tag = tag;
	}
	
	public String toString(){
		return lexeme;
	}

	
}