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

public class TypeCheckingVisitor implements Visitor {

	protected final static Logger LOGGER = Logger
			.getLogger(TypeCheckingVisitor.class.getName());
	
	protected AbstractSyntaxTree tree;
	
	public TypeCheckingVisitor(AbstractSyntaxTree tree) {
		this.tree = tree;
	}
	
	@Override
	public void walk() {
		// TODO Auto-generated method stub
		ProgramNode treeRoot = (ProgramNode) this.tree.getRoot();
		treeRoot.accept(this);
	}
	
	private void visitAllChildrenStandard(Node node) {
		// visit all children
		List<Node> children = node.getChildren();
		for (Node n : children) {
			n.accept(this);
		}
	}
	
	@Override
	public void visit(ArgumentsNode node){
		
	}
	
	@Override
	public void visit(BiOpNode node){
		
	}
	
	@Override
	public void visit(CatchesNode node){
		
	}
	
	@Override
	public void visit(ConstantNode node){
		
	}
	
	@Override
	public void visit(DerivedTypeNode node){
		
	}
	
	@Override
	public void visit(DictTypeNode node){
		
	}
	
	@Override
	public void visit(ElseIfStatementNode node){
		
	}
	
	@Override
	public void visit(ElseStatementNode node){
		
	}
	
	@Override
	public void visit(ExceptionTypeNode node){
		
	}
	
	@Override
	public void visit(ExpressionNode node){
		
	}
	
	@Override
	public void visit(FunctionNode node){
		
	}
	
	@Override
	public void visit(GuardingStatementNode node){}
	
	@Override
	public void visit(IdNode node){
		
	}
	@Override
	public void visit(IfElseStatementNode node){
		
	}
	
	@Override
	public void visit(IterationStatementNode node){
		
	}
	
	@Override
	public void visit(JumpStatementNode node){
		
	}
	
	@Override
	public void visit(MockExpressionNode node){
		
	}
	
	@Override
	public void visit(MockNode node){
		
	}
	
	@Override
	public void visit(Node node){
		
	}
	
	@Override
	public void visit(ParametersNode node)
	{
		
	}
	
	@Override
	public void visit(PostfixExpressionNode node){
		
	}
	
	@Override
	public void visit(PrimaryExpressionNode node){
		
	}
	
	@Override
	public void visit(PrimitiveTypeNode node){
		
	}
	
	@Override
	public void visit(ProgramNode node){
		
	}
	
	@Override
	public void visit(RelationalExpressionNode node){
		
	}
	
	@Override
	public void visit(ReservedWordTypeNode node){
		
	}
	
	@Override
	public void visit(SectionNode node){
		
	}
	
	@Override
	public void visit(SectionTypeNode node){
		
	}
	
	@Override
	public void visit(SelectionStatementNode node){
		
	}
	
	@Override
	public void visit(StatementListNode node){
		
	}
	
	@Override
	public void visit(StatementNode node){
		
	}
	
	@Override
	public void visit(SwitchStatementNode node){
		
	}
	
	@Override
	public void visit(TypeNode node){
		
	}
	
	@Override
	public void visit(UnOpNode node){
		
	}

	

}