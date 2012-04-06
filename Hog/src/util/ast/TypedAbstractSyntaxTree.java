package util.ast;

import java.util.Map;

import util.SymbolTable;

/**
 * An AST including type information.
 * @author !TODO!
 *
 */
public class TypedAbstractSyntaxTree extends AbstractSyntaxTree {
	
	private Map<Node, SymbolTable> scopeStack;

}
