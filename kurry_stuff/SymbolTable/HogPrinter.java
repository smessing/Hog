import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.io.*;
import java.lang.reflect.*;

public class HogPrinter {

	/**
	 * @param args
	 */
	private static final Set<String> JAVA_KEYWORDS = new HashSet(
	        Arrays.asList(new String[]{
	                "abstract", "default",  "if",         "private",    "this",
	                "boolean",  "do",       "implements", "protected",  "throw",
	                "break",    "double",   "import",     "public",     "throws",
	                "byte",     "else",     "instanceof", "return",     "transient",
	                "case",     "extends",  "int",        "short",      "try",
	                "catch",    "final",    "interface",  "static",     "void",
	                "char",     "finally",  "long",       "strictfp",   "volatile",
	                "class",    "float",    "native",     "super",      "while",
	                "const",    "for",      "new",        "switch",
	                "continue", "goto",     "package",    "synchronized",
	                "null",     "true",     "false",
	                "serialVersionUID",
	                "java",
	        }
	        )
	);
	
	public static void findMethod(String name, Object o)throws Exception{
		Method m = o.getClass().getMethod(name);
		System.out.println(m.invoke("Hello Kurry Tran", (Object[])null));
	}
	public static void main(String[] args) {
		//// TODO Auto-generated method stub
    	//ArrayList<Object> list = new ArrayList<Object>();
    	//Field[] fields = list.getClass().getDeclaredFields();
    	//java.lang.reflect.AccessibleObject.setAccessible(fields, true);
		//FastMethod m = new FastMethod(list.type, 0);
		//FastClass f = new FastClass();
		
	}

}
