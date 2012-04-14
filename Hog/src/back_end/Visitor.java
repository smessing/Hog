package back_end;

public abstract class Visitor {
	
	public abstract void visitBiOpNode();
	public abstract void visitCastExpressionNode();
	public abstract void visitConstantNode();
	public abstract void visitExpressionNode();
	public abstract void visitIdNode();
	public abstract void visitMultiplicativeExpressionNode();
	public abstract void visitNode();
	public abstract void visitParemetersNode();
	public abstract void visitPostfixExpressionNode();
	public abstract void visitPrimaryExpressionNode();
	public abstract void visitUnaryExpressionNode();
	public abstract void visitUnOpNode();

}
