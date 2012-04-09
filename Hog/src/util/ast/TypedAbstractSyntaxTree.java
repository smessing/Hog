package util.ast;

import java.util.Map;

import util.SymbolTable;
import util.ast.node.Node;

/**
 * An AST including type information.
 * @author !TODO!
 *
 */
public class TypedAbstractSyntaxTree extends AbstractSyntaxTree {
	
	private Map<Node, SymbolTable> scope;

}
