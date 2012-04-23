/*
 * This file is part of the Polyglot extensible compiler framework.
 *
 * Copyright (c) 2000-2006 Polyglot project group, Cornell University
 * 
 */


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Stack;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 * SimpleCodeWriter is a simple, fast, bulletproof implementation of the
 * CodeWriter interface. However, it does not try very hard to use vertical
 * space optimally or to stay within the horizontal margins. If aesthetically
 * appealing output is desired, use OptimalCodeWriter.
 */
public class SimpleCodeWriter extends CodeWriter {
    protected PrintWriter output;
    protected int width;
    protected int rmargin;
    protected int lmargin;
    protected Stack<State> lmargins;
    protected int pos;

    public SimpleCodeWriter(OutputStream o, int width_) {
        this(new PrintWriter(new OutputStreamWriter(o)), width_);
    }

    protected class State {
        public int lmargin;

        State(int m) { lmargin = m; }
    }

    public SimpleCodeWriter(PrintWriter o, int width_) {
        output = o;
        width = width_;
        rmargin = width;
        adjustRmargin();
        pos = 0;
        lmargins = new Stack<State>();
    }

    public SimpleCodeWriter(Writer o, int width_) {
        this(new PrintWriter(o), width_);
    }

    private void adjustRmargin() {
        rmargin -= 8;
        if (rmargin < width-24) rmargin = width-24;
    }

    public void write(String s) {
        if (s == null)
            write("null", 4);
        else if (s.length() > 0)
            write(s, s.length());
    }

    public void writeln(String s) {
        write(s);
        newline();
    }

    public void write(String s, int length) {
        output.print(s);
        pos += length;
    }

    public void begin(int n) {
        lmargins.push(new State(lmargin));
        lmargin = pos + n;
    }

    public void end() {
        State s = (State)lmargins.pop();
        lmargin = s.lmargin;
    }

    public void allowBreak(int n, int level, String alt, int altlen) {
        if (pos > width) adjustRmargin();
        if (pos > rmargin) {
            newline(n, 1);
        } else {
            output.print(alt);
            pos += altlen;
        }
    }
    public void unifiedBreak(int n, int level, String alt, int altlen) {
        allowBreak(n, level, alt, altlen);
    }

    private void spaces(int n) {
        for (int i = 0; i < n; i++) {
            output.print(' ');
        }
    }
    public void newline() {
        if (pos != lmargin) {
            output.println();
            pos = lmargin;
            spaces(lmargin);
        }
    }
    public void newline(int n, int level) {
        newline();
        spaces(n);
        pos += n;
    }

    public boolean flush() throws IOException {
        output.flush();
        pos = 0;
        return true;
    }

    public boolean flush(boolean format) throws IOException {
        return flush();
    }

    public void close() throws IOException {
        flush();
        output.close();
    }

    /**
     * toString is not really supported by this implementation.
     */
    public String toString() {
        return "<SimpleCodeWriter>";
    }
    
    public String concatenateStrings(String a, String b){
    	
    	
    	return "";
    }
    
    
    public static void main(String[] args)throws Exception{
		FileOutputStream out; // declare a file output object
       // PrintStream p; // declare a print stream object
        // Create a new file output stream
        // connected to "myfile.txt"
        out = new FileOutputStream("WordCount.java");
        
        
    	SimpleCodeWriter w = new SimpleCodeWriter(out,100);
    	w.writeln("import java.io.IOException;");
    	w.writeln("import java.util.*;");
    	w.writeln("import org.apache.hadoop.fs.Path;");
    	w.writeln("import org.apache.hadoop.conf.*;");
    	w.writeln("import org.apache.hadoop.io.*;");
    	w.writeln("import org.apache.hadoop.mapreduce.*;");
    	w.writeln("import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;");
    	w.writeln("import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;");
    	w.writeln("import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;");
    	w.writeln("import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;");
    	w.writeln("public class WordCount{");
    	ArrayList<Object> list = new ArrayList<Object>();
    	Field[] fields = list.getClass().getDeclaredFields();
    	java.lang.reflect.AccessibleObject.setAccessible(fields, true);
    	String value = "";
    	Method[] methods = value.getClass().getMethods();
    	Method m = value.getClass().getMethod("Main");
    	//Member f = new java.lang.reflect.Member();
    	//Constructor c = new java.lang.reflect.AccessibleObject();
    	
    	
    	
    	for(int i = 0; i < methods.length; i++){
    		System.out.println(m.toString());
    	}
    	/*
	    for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field.getName());
	    }
	    */
    	w.writeln("}");

    	
    	w.flush();
    }
    
}
