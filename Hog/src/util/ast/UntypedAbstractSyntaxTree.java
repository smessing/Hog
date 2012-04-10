package util.ast;

import util.ast.node.Node;

/**
 * An AST that doesn't include type or scope information.
 * @author !TODO!
 *
 */
public class UntypedAbstractSyntaxTree extends AbstractSyntaxTree {
	
	public UntypedAbstractSyntaxTree(Node root) {
		super(root);
	}

}
