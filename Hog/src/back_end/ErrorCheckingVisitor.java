/**
 * 
 */
package back_end;

import java.util.List;

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
 * Performs the following validations:
 * - no dead code (statements after a return statement in the same basic block)
 * - no break/continue statements outside of iteration loops
 * - non-void functions have adequate number of return statements
 * - no case/default statements outside of immediate switch statement
 * 
 * @author paul
 *
 */
public class ErrorCheckingVisitor implements Visitor {

    protected AbstractSyntaxTree tree;
    
    private boolean returnFlag;
    
    private void setReturnFlag() {
		this.returnFlag = true;
	}
    
    private void unsetReturnFlag(){
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
			if(n.isNewScope()){
				this.unsetReturnFlag();
			}
			else{
				if(this.isReturnFlagSet()){
					throw new UnreachableCodeError("The following statement is unreachable: " + n.toSource());
				}
			}
		}
	}
	
	
	@Override
	public void visit(ArgumentsNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(BiOpNode node) {
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(CatchesNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(ConstantNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(DerivedTypeNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(ElseIfStatementNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ElseStatementNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(ExceptionTypeNode node) {
		visitAllChildrenStandard(node);
	}

	public void visit(ExpressionNode node) {
		visitAllChildrenStandard(node);
	}

	public void visit(FunctionNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(GuardingStatementNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(IdNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(IfElseStatementNode node) {
         visitAllChildrenStandard(node);
	}

	@Override
	public void visit(IterationStatementNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(JumpStatementNode node) {
		node.accept(this);
		if(node.getJumpType()==JumpType.RETURN){
			this.setReturnFlag();
		}
		else{
			if(this.isReturnFlagSet()){
				throw new UnreachableCodeError("The following statement is unreachable: " + node.toSource());
			}
		}
	}

	@Override
	public void visit(MockExpressionNode node) {
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(MockNode node) {
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(Node node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(ParametersNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(PostfixExpressionNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(PrimaryExpressionNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(PrimitiveTypeNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(ProgramNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(RelationalExpressionNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(SectionNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(SectionTypeNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(SelectionStatementNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(StatementListNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(StatementNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(SwitchStatementNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(TypeNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(UnOpNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(DictTypeNode node) {
		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(ReservedWordTypeNode node) {
		visitAllChildrenStandard(node);
	}

}
