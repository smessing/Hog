package back_end;

/*
 * Visitor class for type checking
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

public class TypeCheckingVisitor extends Visitor{
	
	protected final static Logger LOGGER = Logger.getLogger(TypeCheckingVisitor.class
            .getName());
	
	@Override
	public void visit(BiOpNode node){
		//node specific type checking operations here
		LOGGER.fine("Type-checking BiOpNode");
	}
	
	@Override
	public void visit(ConstantNode node){
		//node specific type checking operations here
		LOGGER.fine("Type-checking ConstantNode");
	}
	
	@Override
	public void visit(ExpressionNode node){
		//node specific type checking operations here
		LOGGER.fine("Type-checking ExpressionNode");
	}
	
	@Override
	public void visit(IdNode node){
		//node specific type checking operations here
		LOGGER.fine("Type-checking IdNode");
	}
	
	@Override
	public void visit(MockNode node){
		//node specific type checking operations here
		LOGGER.fine("Type-checking MockNode");
	}
	
	@Override
	public void visit(MockExpressionNode node){
		//node specific type checking operations here
		LOGGER.fine("Type-checking MockExpressionNode");
	}
	
	@Override
	public void visit(Node node){
		//node specific type checking operations here
		LOGGER.fine("Type-checking Node");
	}
	
	@Override
	public void visit(ParametersNode node){
		//node specific type checking operations here
		LOGGER.fine("Type-checking ParametersNode");
	}
	
	@Override
	public void visit(PrimaryExpressionNode node){
		//node specific type checking operations here
		LOGGER.fine("Type-checking PrimaryExpressionNode");
	}
	
	@Override
	public void visit(RelationalExpressionNode node){
		//node specific type checking operations here
		LOGGER.fine("Type-checking RelationalExpressionNode");
	}
	
	@Override
	public void visit(UnOpNode node){
		//node specific type checking operations here
		LOGGER.fine("Type-checking UnOpNode");
	}

	@Override
	public void visit(ArgumentsNode node) {
	    //node specific type checking operations here
		LOGGER.fine("Type-checking ArgumentsNode");
	}

	@Override
	public void visit(CatchesNode node) {
		//node specific type checking operations here
		LOGGER.fine("Type-checking CatchesNode");
	}

	@Override
	public void visit(DerivedTypeNode node) {
		//node specific type checking operations here
		LOGGER.fine("Type-checking DerivedTypeNode");
	}

	@Override
	public void visit(ElseIfStatementNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ElseStatementNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ExceptionTypeNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FunctionNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(GuardingStatementNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IfElseStatementNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IterationStatementNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(JumpStatementNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PostfixExpressionNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PrimitiveTypeNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ProgramNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(SectionNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(SectionTypeNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(SelectionStatementNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StatementListNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StatementNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(SwitchStatementNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(TypeNode node) {
		// TODO Auto-generated method stub
		
	}
	
}