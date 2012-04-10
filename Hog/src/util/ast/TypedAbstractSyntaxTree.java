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
	
	protected Map<Node, SymbolTable> scope;
	
	protected TypedAbstractSyntaxTree(Node root) {
		super(root);
	}

}
