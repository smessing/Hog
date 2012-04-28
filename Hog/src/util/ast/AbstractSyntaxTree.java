package util.ast;

import java.util.Iterator;

import util.ast.node.Node;

/**
 * Abstract class for specifying common behavior for ASTs.
 * 
 * @author sam
 * 
 */
public class AbstractSyntaxTree {

	/** root field of type Node */
	protected Node root;
	/** Constructor AbstractSyntabTree(Node root)
	 * 
	 * @param root Node
	 */
	public AbstractSyntaxTree(Node root) {
		this.root = root;
	}
	/** Method preOrderTraversal()
	 * Returns an Iterator<\Node> of AbstractSyntax Tree in PreOrder
	 * @return Iterator<\Node>
	 */
	public Iterator<Node> preOrderTraversal() {

		return TreeTraversalBuilder.buildTraversalIterator(root,
				TreeTraversalBuilder.traversalOrder.PREORDER);

	}
	/** Method postOrderTraversal()
	 * Returns an Iterator<\Node> of AbstractSyntax Tree in PostOrder
	 * @return Iterator<\Node>
	 */
	public Iterator<Node> postOrderTraversal() {

		return TreeTraversalBuilder.buildTraversalIterator(root,
				TreeTraversalBuilder.traversalOrder.POSTORDER);

	}
	/** Method toLatex()
	 *  Returns a String representation of the program in Latex format
	 *  @return string String 
	 */
	public String toLatex() {
		
		if (root.getChildren() == null || root.getChildren().size() == 0) {
			return "[.{" + root.getName() + "} ]";
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\\documentclass{article}\n");
		sb.append("\\usepackage{graphicx, pdflscape}\n");
		sb.append("\\usepackage{qtree}\n");
		sb.append("\\begin{document}\n");
		sb.append("\\begin{landscape}\n");
		sb.append("\\thispagestyle{empty}\n");
		sb.append("\\hspace*{-0.1\\linewidth}\\resizebox{1.2\\linewidth}{!}{%\n");
		
		sb.append("\\Tree[.{" + root.getName() + "}");
		
		for (Node child : root.getChildren()) {
			sb.append(toLatexAux(child));
		}
		
		sb.append(" ]\n}\n");
		
		sb.append("\\end{landscape}\n");
		sb.append("\\end{document}\n");
		
		return sb.toString().replaceAll("<", "\\$<\\$").replaceAll(">", "\\$>\\$").replaceAll("_", "-");
	}

	private String toLatexAux(Node node) {
		
		// base case
		if (node.getChildren() == null || node.getChildren().size() == 0) {
			return " [.{" + node.getName() + "} ]";
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(" [.{" + node.getName() + "}");
		
		for (Node child : node.getChildren()) {
			sb.append(toLatexAux(child));
		}
		
		sb.append(" ]");
		
		return sb.toString();
		
	}

}
