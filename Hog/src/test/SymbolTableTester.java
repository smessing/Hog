package test;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import util.SymbolTable;

public class SymbolTableTester {

	@Test
	public void reservedSymbolTableTest() {
		/* 
		 * create a new symbol table, this should be root 
		 * and should be populated with all reserved words and functions
		 */
		SymbolTable sym = new SymbolTable(null);
		Set<String> reservedSet = sym.table.keySet();
		for(String s : reservedSet){
			System.out.println("KEY: "+ s + " VALUE: " + sym.get(s).type);
		}
	}

}
