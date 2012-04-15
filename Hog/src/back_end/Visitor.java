package back_end;

import util.ast.node.AdditiveExpressionNode;
import util.ast.node.BiOpNode;
import util.ast.node.CastExpressionNode;
import util.ast.node.ConstantNode;
import util.ast.node.EqualityExpressionNode;
import util.ast.node.ExpressionNode;
import util.ast.node.IdNode;
import util.ast.node.LogicalExpressionNode;
import util.ast.node.LogicalTermNode;
import util.ast.node.MockExpressionNode;
import util.ast.node.MockNode;
import util.ast.node.MultiplicativeExpressionNode;
import util.ast.node.Node;
import util.ast.node.ParametersNode;
import util.ast.node.PostfixExpressionNode;
import util.ast.node.PrimaryExpressionNode;
import util.ast.node.RelationalExpressionNode;
import util.ast.node.UnOpNode;
import util.ast.node.UnaryExpressionNode;

public abstract class Visitor {
	
	public abstract void visit(AdditiveExpressionNode node);
	public abstract void visit(BiOpNode node);
	public abstract void visit(CastExpressionNode node);
	public abstract void visit(ConstantNode node);
	public abstract void visit(EqualityExpressionNode node);
	public abstract void visit(ExpressionNode node);
	public abstract void visit(IdNode node);
	public abstract void visit(LogicalExpressionNode node);
	public abstract void visit(LogicalTermNode node);
	public abstract void visit(MockExpressionNode node);
	public abstract void visit(MockNode node);
	public abstract void visit(MultiplicativeExpressionNode node);
	public abstract void visit(Node node);
	public abstract void visit(ParametersNode node);
	public abstract void visit(PostfixExpressionNode node);
	public abstract void visit(PrimaryExpressionNode node);
	public abstract void visit(RelationalExpressionNode node);
	public abstract void visit(UnaryExpressionNode node);
	public abstract void visit(UnOpNode node);

}
