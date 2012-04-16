package back_end;

import util.ast.node.*;

public abstract class Visitor {
	
	public abstract void visit(BiOpNode node);
	public abstract void visit(CastExpressionNode node);
	public abstract void visit(ConstantNode node);
	public abstract void visit(ExpressionNode node);
	public abstract void visit(IdNode node);
	public abstract void visit(MockExpressionNode node);
	public abstract void visit(MockNode node);
	public abstract void visit(Node node);
	public abstract void visit(ParametersNode node);
	public abstract void visit(PostfixExpressionNode node);
	public abstract void visit(PrimaryExpressionNode node);
	public abstract void visit(RelationalExpressionNode node);
	public abstract void visit(UnaryExpressionNode node);
	public abstract void visit(UnOpNode node);

}
