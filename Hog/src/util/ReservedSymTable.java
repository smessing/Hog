package util;

import java.util.Hashtable;

import front_end.sym;

public final class ReservedSymTable{
	
	public static Hashtable<String, Word> reservedSymTable = new Hashtable<String, Word>();
	
	public static Hashtable<String, Word> getReservedSymTable(){
		if(reservedSymTable.isEmpty()){
			ReservedSymTable.reserveWords();
		}
		return reservedSymTable;
	
	}
	
	public static void reserve(Word w){ 
		reservedSymTable.put(w.lexeme, w); 
	}
	
	public static boolean containsWord(String name){ 
		if(reservedSymTable.containsKey(name))
			return true;
		else
			return false;
	}
	
	public static void reserveWords(){
		reserve(new Word("and", sym.AND));
		reserve(new Word("or", sym.OR));
		reserve(new Word("if", sym.IF));
		reserve(new Word("else", sym.ELSE));
		reserve(new Word("elseif", sym.ELSEIF));
		reserve(new Word("Map", sym.MAP));
		reserve(new Word("Reduce", sym.REDUCE));
		reserve(new Word("Main", sym.MAIN));
		reserve(new Word("Functions", sym.FUNCTIONS));
		//reserve(new Word("emit", sym.EMIT));
		reserve(new Word("for", sym.FOR));
		reserve(new Word("not", sym.NOT));
		reserve(new Word("in", sym.IN));
		reserve(new Word("return", sym.RETURN));
		reserve(new Word("break", sym.BREAK));
		reserve(new Word("case", sym.CASE));
		reserve(new Word("switch", sym.SWITCH));
		reserve(new Word("void", sym.VOID));
		reserve(new Word("while", sym.WHILE));
		reserve(new Word("foreach", sym.FOREACH));
		reserve(new Word("list", sym.LIST));
		reserve(new Word("continue", sym.CONTINUE));
		reserve(new Word("int", sym.INT));
		reserve(new Word("real", sym.REAL));
		reserve(new Word("bool", sym.BOOL));
		reserve(new Word("text", sym.TEXT));
		reserve(new Word("default", sym.DEFAULT));
		reserve(new Word("set", sym.SET));
		reserve(new Word("dict", sym.DICT));
		reserve(new Word("iter", sym.ITER));
		
		reserve(new Word("==", sym.DBL_EQLS));
		reserve(new Word("!=", sym.NOT_EQLS));
		reserve(new Word(">=", sym.GRTR_EQL));
		reserve(new Word("<=", sym.LESS_EQL));
		//reserve(new Word("true", sym.TRUE));
		//reserve(new Word("false", sym.FALSE));
		//reserve(new Word("try", sym.TRY));
		//reserve(new Word("catch", sym.CATCH));
	}
	
}




