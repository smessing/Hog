/**
 * 
 */
package back_end;

import java.util.List;
import java.util.logging.Logger;

import util.ast.AbstractSyntaxTree;
import util.ast.node.ArgumentsNode;
import util.ast.node.BiOpNode;
import util.ast.node.CatchesNode;
import util.ast.node.ConstantNode;
import util.ast.node.DerivedTypeNode;
import util.ast.node.DictTypeNode;
import util.ast.node.ElseIfStatementNode;
import util.ast.node.ElseStatementNode;
import util.ast.node.ExceptionTypeNode;
import util.ast.node.ExpressionNode;
import util.ast.node.FunctionNode;
import util.ast.node.GuardingStatementNode;
import util.ast.node.IdNode;
import util.ast.node.IfElseStatementNode;
import util.ast.node.IterationStatementNode;
import util.ast.node.JumpStatementNode;
import util.ast.node.JumpStatementNode.JumpType;
import util.ast.node.MockExpressionNode;
import util.ast.node.MockNode;
import util.ast.node.Node;
import util.ast.node.ParametersNode;
import util.ast.node.PostfixExpressionNode;
import util.ast.node.PrimaryExpressionNode;
import util.ast.node.PrimitiveTypeNode;
import util.ast.node.ProgramNode;
import util.ast.node.RelationalExpressionNode;
import util.ast.node.ReservedWordTypeNode;
import util.ast.node.SectionNode;
import util.ast.node.SectionTypeNode;
import util.ast.node.SelectionStatementNode;
import util.ast.node.StatementListNode;
import util.ast.node.StatementNode;
import util.ast.node.SwitchStatementNode;
import util.ast.node.TypeNode;
import util.ast.node.UnOpNode;
import util.error.UnreachableCodeError;

/**
 * Visitor class for error checking.
 * 
 * This is the second walk performed after construction of the AST from source.
 * 
 * Performs the following validations: - no dead code (statements after a return
 * statement in the same basic block) - no break/continue statements outside of
 * iteration loops - non-void functions have adequate number of return
 * statements - no case/default statements outside of immediate switch statement
 * 
 * @author paul
 * 
 */
public class ErrorCheckingVisitor implements Visitor {

	protected AbstractSyntaxTree tree;

	protected final static Logger LOGGER = Logger
			.getLogger(ErrorCheckingVisitor.class.getName());

	private boolean returnFlag;

	private void setReturnFlag() {
		this.returnFlag = true;
	}

	private void unsetReturnFlag() {
		this.returnFlag = false;
	}

	public boolean isReturnFlagSet() {
		return this.returnFlag;
	}

	public ErrorCheckingVisitor(AbstractSyntaxTree tree) {
		this.tree = tree;
	}

	public void walk() {

		ProgramNode treeRoot = (ProgramNode) this.tree.getRoot();
		treeRoot.accept(this);
	}

	private void visitAllChildrenStandard(Node node) {
		// visit all children of a given node
		List<Node> children = node.getChildren();
		for (Node n : children) {
			n.accept(this);
			if (!(n instanceof JumpStatementNode)) {
				if (n.isNewScope()) {
					LOGGER.finer("We are in a new scope now in node " + node);
					this.unsetReturnFlag();
				} else {
					if (this.isReturnFlagSet()) {
						throw new UnreachableCodeError(
								"The following statement is unreachable: "
										+ n.toSource());
					}
				}
			}
		}
	}

	@Override
	public void visit(ArgumentsNode node) {
		LOGGER.finer("visit(ArgumentsNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
		
	}

	@Override
	public void visit(BiOpNode node) {
		LOGGER.finer("visit(BiOpNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(CatchesNode node) {
		LOGGER.finer("visit(CatchesNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(ConstantNode node) {
		LOGGER.finer("visit(ConstantNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(DerivedTypeNode node) {
		LOGGER.finer("visit(DerivedTypeNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(ElseIfStatementNode node) {
		LOGGER.finer("visit(ElseIfStatementNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(ElseStatementNode node) {
		LOGGER.finer("visit(ElseStatementNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(ExceptionTypeNode node) {
		LOGGER.finer("visit(ExceptionTypeNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	public void visit(ExpressionNode node) {
		LOGGER.finer("visit(ExpressionNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	public void visit(FunctionNode node) {
		LOGGER.finer("visit(FunctionNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(GuardingStatementNode node) {
		LOGGER.finer("visit(GuardingStatementNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(IdNode node) {
		LOGGER.finer("visit(IdNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(IfElseStatementNode node) {
		LOGGER.finer("visit(IfElseStatementNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(IterationStatementNode node) {
		LOGGER.finer("visit(IterationStatementNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(JumpStatementNode node) {
		LOGGER.finer("visit(JumpStatementNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		if (node.getJumpType() == JumpType.RETURN) {
			this.setReturnFlag();
		} else {
			if (this.isReturnFlagSet()) {
				throw new UnreachableCodeError(
						"The following statement is unreachable: "
								+ node.toSource());
			}
		}
	}

	@Override
	public void visit(MockExpressionNode node) {
		LOGGER.finer("visit(MockExpressionNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(MockNode node) {
		LOGGER.finer("visit(MockNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(Node node) {
		LOGGER.finer("visit(Node node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(ParametersNode node) {
		LOGGER.finer("visit(ParametersNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(PostfixExpressionNode node) {
		LOGGER.finer("visit(PostfixExpressionNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(PrimaryExpressionNode node) {
		LOGGER.finer("visit(PrimaryExpressionNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(PrimitiveTypeNode node) {
		LOGGER.finer("visit(PrimitiveTypeNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(ProgramNode node) {
		LOGGER.finer("visit(ProgramNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(RelationalExpressionNode node) {
		LOGGER.finer("visit(RelationalExpressionNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(SectionNode node) {
		LOGGER.finer("visit(SectionNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(SectionTypeNode node) {
		LOGGER.finer("visit(SectionTypeNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(SelectionStatementNode node) {
		LOGGER.finer("visit(SelectionStatementNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(StatementListNode node) {
		LOGGER.finer("visit(StatementListNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(StatementNode node) {
		LOGGER.finer("visit(StatementNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(SwitchStatementNode node) {
		LOGGER.finer("visit(SwitchStatementNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(TypeNode node) {
		LOGGER.finer("visit(TypeNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(UnOpNode node) {
		LOGGER.finer("visit(UnOpNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(DictTypeNode node) {
		LOGGER.finer("visit(DictTypeNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(ReservedWordTypeNode node) {
		LOGGER.finer("visit(ReservedWordTypeNode node) called on " + node);
		LOGGER.finer("Return Flag Value is " + this.isReturnFlagSet());
		visitAllChildrenStandard(node);
	}

}
