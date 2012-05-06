package util.symbol_table;

/**
 * [deprecated]
 * Jason Halpern
 * 
 */
import java.util.ArrayList;
import java.util.Hashtable;

import front_end.sym;

public final class ReservedSymTable{
	
	public static Hashtable<String, Word> reservedWordSymTable = new Hashtable<String, Word>();
	public static Hashtable<String, ArrayList<String>> methodsSymTable = new Hashtable<String, ArrayList<String>>();
	
	public static Hashtable<String, Word> getReservedWordSymTable(){
		if(reservedWordSymTable.isEmpty()){
			ReservedSymTable.reserveWords();
		}
		return reservedWordSymTable;

	}
	
	public static Hashtable<String, ArrayList<String>> getMethodsSymTable(){
		if(methodsSymTable.isEmpty()){
			ReservedSymTable.reserveWords();
		}
		return methodsSymTable;

	}
	
	public static void reserve(Word w){ 
		reservedWordSymTable.put(w.lexeme, w); 
	}
	
	public static void reserve(Method w){ 
		methodsSymTable.put(w.lexeme, w.methods); 
	}
	
	//check if the reserved word symbol table contains this name
	public static boolean containsWord(String name){ 
		if(reservedWordSymTable.containsKey(name))
			return true;
		else
			return false;
	}
	
	//check if this method is valid for this derived type
	public static boolean containsMethod(String derivedType, String method){ 
		if(methodsSymTable.containsKey(derivedType)){
			if(methodsSymTable.get(derivedType).contains(method)){
				return true;
			}
			return false;
		}
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
		reserve(new Word("iter", sym.ITER));
		reserve(new Word("==", sym.DBL_EQLS));
		reserve(new Word("!=", sym.NOT_EQLS));
		reserve(new Word(">=", sym.GRTR_EQL));
		reserve(new Word("<=", sym.LESS_EQL));
		//reserve(new Word("true", sym.TRUE));
		//reserve(new Word("false", sym.FALSE));
		//reserve(new Word("try", sym.TRY));
		//reserve(new Word("catch", sym.CATCH));
		
		/* add methods for all derived type methods */
		ArrayList<String> listMethods = new ArrayList<String>();
		listMethods.add("add");
		listMethods.add("clear");
		listMethods.add("get");
		listMethods.add("iterator");
		listMethods.add("sort");
		listMethods.add("size");
		
		ArrayList<String> iterMethods = new ArrayList<String>();
		iterMethods.add("next");
		iterMethods.add("hasNext");
		iterMethods.add("peek");
		
		ArrayList<String> setMethods = new ArrayList<String>();
		setMethods.add("add");
		setMethods.add("clear");
		setMethods.add("contains");
		setMethods.add("containsAll");
		setMethods.add("isEmpty");
		setMethods.add("iterator");
		setMethods.add("remove");
		setMethods.add("removeAll");
		setMethods.add("size");
		
		ArrayList<String> multiSetMethods = new ArrayList<String>();
		multiSetMethods.add("add");
		multiSetMethods.add("clear");
		multiSetMethods.add("contains");
		multiSetMethods.add("count");
		multiSetMethods.add("entrySet");
		multiSetMethods.add("isEmpty");
		multiSetMethods.add("iterator");
		multiSetMethods.add("removeAll");
		multiSetMethods.add("removeOne");
		multiSetMethods.add("size");
		
		ArrayList<String> textMethods = new ArrayList<String>();
		textMethods.add("length");
		textMethods.add("replace");
		textMethods.add("tokenize");
		
		ArrayList<String> dictMethods = new ArrayList<String>();
		dictMethods.add("clear");
		dictMethods.add("containsKey");
		dictMethods.add("get");
		dictMethods.add("keySet");
		dictMethods.add("put");
		dictMethods.add("size");
		dictMethods.add("reverseDict");

		reserve(new Method("list", listMethods));
		reserve(new Method("dict", dictMethods));
		reserve(new Method("set", setMethods));
		reserve(new Method("multiset", multiSetMethods));
		reserve(new Method("text", textMethods));
		reserve(new Method("iter", iterMethods));
		

	}
	
}




