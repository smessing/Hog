package back_end;

import util.ast.node.*;

/**
 * Visitor interface
 * All visitors implement this interface
 * 
 * @author jason
 *
 */

public interface Visitor {
	
	public abstract void visit(ArgumentsNode node);
	public abstract void visit(BiOpNode node);
	public abstract void visit(CatchesNode node);
	public abstract void visit(ConstantNode node);
	public abstract void visit(DerivedTypeNode node);
	public abstract void visit(DictTypeNode node);
	public abstract void visit(ElseIfStatementNode node);
	public abstract void visit(ElseStatementNode node);
	public abstract void visit(ExceptionTypeNode node);
	public abstract void visit(ExpressionNode node);
	public abstract void visit(FunctionNode node);
	public abstract void visit(GuardingStatementNode node);
	public abstract void visit(IdNode node);
	public abstract void visit(IfElseStatementNode node);
	public abstract void visit(IterationStatementNode node);
	public abstract void visit(JumpStatementNode node);
	public abstract void visit(MockExpressionNode node);
	public abstract void visit(MockNode node);
	public abstract void visit(Node node);
	public abstract void visit(ParametersNode node);
	public abstract void visit(PostfixExpressionNode node);
	public abstract void visit(PrimaryExpressionNode node);
	public abstract void visit(PrimitiveTypeNode node);
	public abstract void visit(ProgramNode node);
	public abstract void visit(RelationalExpressionNode node);
	public abstract void visit(ReservedWordTypeNode node);
	public abstract void visit(SectionNode node);
	public abstract void visit(SectionTypeNode node);
	public abstract void visit(SelectionStatementNode node);
	public abstract void visit(StatementListNode node);
	public abstract void visit(StatementNode node);
	public abstract void visit(SwitchStatementNode node);
	public abstract void visit(TypeNode node);
	public abstract void visit(UnOpNode node);
	public abstract void walk(ProgramNode node);

}
