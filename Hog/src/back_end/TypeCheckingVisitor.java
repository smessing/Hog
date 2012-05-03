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
 * @author jason, ben
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
import util.type.Types;

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
		LOGGER.finer("Type Check visit(BiOpNode node) called on " + node.getName());
		TypeNode leftNode  = node.getLeftNode().getType();
		TypeNode rightNode = node.getRightNode().getType();
		if(leftNode == null && rightNode == null){
			System.out.println("both are null");
		}
		else if(leftNode == null && rightNode != null){
			node.setType(rightNode);
		}
		else if(leftNode != null && rightNode == null){
			node.setType(leftNode);
		}
		else{
			PrimitiveTypeNode typeNode = Types.getHigherNumericType(leftNode, rightNode);
			node.setType(typeNode);
		}
	}
	
	@Override
	public void visit(CatchesNode node){
		LOGGER.finer("Type Check visit(CatchesNode node) called on " + node.getName());

		
	}
	
	@Override
	public void visit(ConstantNode node){
		LOGGER.finer("Type Check visit(ConstantNode node) called on " + node.getName());
		
	}
	
	@Override
	public void visit(DerivedTypeNode node){
		LOGGER.finer("Type Check visit(DerivedTypeNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(DictTypeNode node){
		LOGGER.finer("Type Check visit(DictTypeNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(ElseIfStatementNode node){
		LOGGER.finer("Type Check visit(ElseIfStatementNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(ElseStatementNode node){
		LOGGER.finer("Type Check visit(ElseStatementNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(ExceptionTypeNode node){
		LOGGER.finer("Type Check visit(ExceptionTypeNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(ExpressionNode node){
		LOGGER.finer("Type Check visit(ExpressionNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(FunctionNode node){
		LOGGER.finer("Type Check visit(FunctionNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(GuardingStatementNode node){
		LOGGER.finer("Type Check visit(GuardingStatementNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(IdNode node){
		LOGGER.finer("Type Check visit(IdNode node) called on " + node.getName());

	}
	@Override
	public void visit(IfElseStatementNode node){
		LOGGER.finer("Type Check visit(IfElseStatementNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(IterationStatementNode node){
		LOGGER.finer("Type Check visit(IterationStatementNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(JumpStatementNode node){
		LOGGER.finer("Type Check visit(JumpStatementNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(MockExpressionNode node){
		LOGGER.finer("Type Check visit(MockExpressionNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(MockNode node){
		LOGGER.finer("Type Check visit(MockNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(Node node){
		LOGGER.finer("Type Check visit(Node node) called on " + node.getName());

	}
	
	@Override
	public void visit(ParametersNode node){
		LOGGER.finer("Type Check visit(ParametersNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(PostfixExpressionNode node){
		LOGGER.finer("Type Check visit(PostfixExpressionNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(PrimaryExpressionNode node){
		LOGGER.finer("Type Check visit(PrimaryExpressionNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(PrimitiveTypeNode node){
		LOGGER.finer("Type Check visit(PrimitiveTypeNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(ProgramNode node){
		LOGGER.finer("Type Check visit(ProgramNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(RelationalExpressionNode node){
		LOGGER.finer("Type Check visit(RelationalExpressionNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(ReservedWordTypeNode node){
		LOGGER.finer("Type Check visit(ReservedWordTypeNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(SectionNode node){
		LOGGER.finer("Type Check visit(SectionNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(SectionTypeNode node){
		LOGGER.finer("Type Check visit(SectionTypeNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(SelectionStatementNode node){
		LOGGER.finer("Type Check visit(SelectionStatementNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(StatementListNode node){
		LOGGER.finer("Type Check visit(StatementListNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(StatementNode node){
		LOGGER.finer("Type Check visit(StatementNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(SwitchStatementNode node){
		LOGGER.finer("Type Check visit(SwitchStatementNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(TypeNode node){
		LOGGER.finer("Type Check visit(TypeNode node) called on " + node.getName());

	}
	
	@Override
	public void visit(UnOpNode node){
		LOGGER.finer("Type Check visit(UnOpNode node) called on " + node.getName());

	}

	

}