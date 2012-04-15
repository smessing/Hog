package util.ast.node;

import back_end.Visitor;

/**
 * A node representing a LogicalTerm nonterminal
 * 
 * @author ben
 *
 */
public class LogicalTermNode extends BiOpNode {


	public LogicalTermNode(ExpressionNode left, ExpressionNode right) {
		super(BiOpNode.OpType.AND, left, right);
	}

	@Override
	public String getName() {
		return "LogicalTermNode<" + this.getTypeName() + ","
				+ this.opType.toString() + ">";
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
