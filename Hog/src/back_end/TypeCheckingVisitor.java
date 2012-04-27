package back_end;

/**
 * Visitor class for type checking. 
 * 
 * This is the first walk performed after construction of the AST from source.
 * 
 * Performs the following actions:
 * - populates & propagate types through AST.
 * 
 * Performs the following validations:
 * - all operands are of right type for given operator.
 * - variables are declared before they are used.
 * - return statements of functions have right type.
 * - section types of map/reduce are appropriate.
 * - actual parameters to a procedure match formal parameters.
 * 
 * @author paul
 * 
 */
import java.util.logging.Logger;

import util.ast.node.ArgumentsNode;
import util.ast.node.BiOpNode;
import util.ast.node.CatchesNode;
import util.ast.node.ConstantNode;
import util.ast.node.DerivedTypeNode;
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
import util.ast.node.MockExpressionNode;
import util.ast.node.MockNode;
import util.ast.node.Node;
import util.ast.node.ParametersNode;
import util.ast.node.PostfixExpressionNode;
import util.ast.node.PrimaryExpressionNode;
import util.ast.node.PrimitiveTypeNode;
import util.ast.node.ProgramNode;
import util.ast.node.RelationalExpressionNode;
import util.ast.node.SectionNode;
import util.ast.node.SectionTypeNode;
import util.ast.node.SelectionStatementNode;
import util.ast.node.StatementListNode;
import util.ast.node.StatementNode;
import util.ast.node.SwitchStatementNode;
import util.ast.node.TypeNode;
import util.ast.node.UnOpNode;

public class TypeCheckingVisitor extends Visitor {

	protected final static Logger LOGGER = Logger
			.getLogger(TypeCheckingVisitor.class.getName());

	@Override
	public void visit(BiOpNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking BiOpNode");
	}

	@Override
	public void visit(ConstantNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking ConstantNode");
	}

	@Override
	public void visit(ExpressionNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking ExpressionNode");
	}

	@Override
	public void visit(IdNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking IdNode");
	}

	@Override
	public void visit(MockNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking MockNode");
	}

	@Override
	public void visit(MockExpressionNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking MockExpressionNode");
	}

	@Override
	public void visit(Node node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking Node");
	}

	@Override
	public void visit(ParametersNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking ParametersNode");
	}

	@Override
	public void visit(PrimaryExpressionNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking PrimaryExpressionNode");
	}

	@Override
	public void visit(RelationalExpressionNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking RelationalExpressionNode");
	}

	@Override
	public void visit(UnOpNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking UnOpNode");
	}

	@Override
	public void visit(ArgumentsNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking ArgumentsNode");
	}

	@Override
	public void visit(CatchesNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking CatchesNode");
	}

	@Override
	public void visit(DerivedTypeNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking DerivedTypeNode");
	}

	@Override
	public void visit(ElseIfStatementNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking ElseIfStatementNode");
	}

	@Override
	public void visit(ElseStatementNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking ElseStatementNode");
	}

	@Override
	public void visit(ExceptionTypeNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking ExceptionTypeNode");
	}

	@Override
	public void visit(FunctionNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking FunctionNode");
	}

	@Override
	public void visit(GuardingStatementNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking GuardingStatementNode");
	}

	@Override
	public void visit(IfElseStatementNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking IfElseStatementNode");
	}

	@Override
	public void visit(IterationStatementNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking IterationStatementNode");
	}

	@Override
	public void visit(JumpStatementNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking JumpStatementNode");
	}

	@Override
	public void visit(PostfixExpressionNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking PostfixExpressionNode");
	}

	@Override
	public void visit(PrimitiveTypeNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking PrimitiveTypeNode");
	}

	@Override
	public void visit(ProgramNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking ProgramNode");
	}

	@Override
	public void visit(SectionNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking SectionNode");
	}

	@Override
	public void visit(SectionTypeNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking SectionTypeNode");
	}

	@Override
	public void visit(SelectionStatementNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking SelectionStatementNode");
	}

	@Override
	public void visit(StatementListNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking StatementListNode");
	}

	@Override
	public void visit(StatementNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking StatementNode");
	}

	@Override
	public void visit(SwitchStatementNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking SwithStatementNode");
	}

	@Override
	public void visit(TypeNode node) {
		// node specific type checking operations here
		LOGGER.fine("Type-checking TypeNode");
	}

}