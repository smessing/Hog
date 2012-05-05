package back_end;

import java.util.List;
import java.util.logging.Logger;

import util.ast.AbstractSyntaxTree;
import util.ast.node.*;
import util.error.TypeMismatchError;
import util.symbol_table.FunctionSymbol;
import util.symbol_table.SymbolTable;
import util.type.Types;

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
 * @author Jason Halpern
 * @author Benjamin Rapaport
 * 
 */
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
	
	public TypeNode getExpectedReturnType(Node node) {
		// TODO Auto-generated method stub
		
		Node tempNode;
		
		while(node.hasParent()){
			tempNode = node.getParent();
			if(tempNode instanceof FunctionNode){
				return ((FunctionNode) tempNode).getType();
			}
			node = tempNode;
		}
		
		return null;
	}

	private void visitAllChildrenStandard(Node node) {
		// visit all children
		List<Node> children = node.getChildren();
		for (Node n : children) {
			n.accept(this);
		}
	}

	@Override
	public void visit(ArgumentsNode node) {
		LOGGER.finer("Type Check visit(ArgumentsNode node) called on "
				+ node.getName());
		node.getExpressionNode().accept(this);
		// set the type to the type of its child expressionNode
		node.setType(node.getExpressionNode().getType());
		if (node.getArgumentsNode() != null) {
			node.getArgumentsNode().accept(this);
		}

	}

	@Override
	public void visit(BiOpNode node) {
		LOGGER.finer("Type Check visit(BiOpNode node) called on "
				+ node.getName());

		// call on left and right node
		ExpressionNode leftNode = node.getLeftNode();
		ExpressionNode rightNode = node.getRightNode();
		leftNode.accept(this);
		rightNode.accept(this);

		// check if they are compatible
		Types.isCompatible(node.getOpType(), leftNode.getType(),
				rightNode.getType());

		// get return type
		node.setType(Types.getResult(node.getOpType(), leftNode.getType(),
				rightNode.getType()));

	}

	@Override
	public void visit(CatchesNode node) {
		LOGGER.finer("Type Check visit(CatchesNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(ConstantNode node) {
		LOGGER.finer("Type Check visit(ConstantNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(DerivedTypeNode node) {
		LOGGER.finer("Type Check visit(DerivedTypeNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(DictTypeNode node) {
		LOGGER.finer("Type Check visit(DictTypeNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(ElseIfStatementNode node) {
		LOGGER.finer("Type Check visit(ElseIfStatementNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(ElseStatementNode node) {
		LOGGER.finer("Type Check visit(ElseStatementNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(ExceptionTypeNode node) {
		LOGGER.finer("Type Check visit(ExceptionTypeNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(ExpressionNode node) {
		LOGGER.finer("Type Check visit(ExpressionNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(FunctionNode node) {
		LOGGER.finer("Type Check visit(FunctionNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(GuardingStatementNode node) {
		LOGGER.finer("Type Check visit(GuardingStatementNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(IdNode node) {
		LOGGER.finer("Type Check visit(IdNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(IfElseStatementNode node) {
		LOGGER.finer("Type Check visit(IfElseStatementNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(IterationStatementNode node) {
		LOGGER.finer("Type Check visit(IterationStatementNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(JumpStatementNode node) {
		LOGGER.finer("Type Check visit(JumpStatementNode node) called on "
				+ node.getName());
		
		//System.out.println("type check jump statement node");
		visitAllChildrenStandard(node);
		
		TypeNode expectedReturnType;
		if(node.getJumpType() == JumpStatementNode.JumpType.RETURN){
			//System.out.println("cehcking return");
			expectedReturnType = this.getExpectedReturnType(node);
			//System.out.println("EXPECTED: " + expectedReturnType + " ACTUAL:" + node.getExpressionNode().getType());
			if(!Types.isSameType(node.getExpressionNode().getType(), expectedReturnType)){
				throw new TypeMismatchError("Return statement " + node.getExpressionNode().getType() + "does not match the expected return type of "+
						expectedReturnType);
			}
		}
	}

	@Override
	public void visit(MockExpressionNode node) {
		LOGGER.finer("" +
				" visit(MockExpressionNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(MockNode node) {
		LOGGER.finer("Type Check visit(MockNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(Node node) {
		LOGGER.finer("Type Check visit(Node node) called on " + node.getName());

		visitAllChildrenStandard(node);
	}

	@Override
	public void visit(ParametersNode node) {
		LOGGER.finer("Type Check visit(ParametersNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(PostfixExpressionNode node) {
		

		LOGGER.finer("Type Check visit(PostfixExpressionNode node) called on "
				+ node.getName());

		
		// visit all children
		visitAllChildrenStandard(node);

		// make all checks on function call
		Types.checkValidFunctionCall(node);
		
		// get the symbol for this function
		FunctionSymbol funSym = SymbolTable.getSymbolForPostFixExpressionNode(node);

		// set type to return type given in symbol table
		// if it is a reservedWordTypeNode
		if( funSym.getType() instanceof ReservedWordTypeNode) {
			
			// if it is check inner type, set type accordingly
			if(((ReservedWordTypeNode) funSym.getType()).getType() == Types.Flags.CHECK_INNER_TYPE) {
				TypeNode innerType = (((DerivedTypeNode) node.getObjectOfMethod().getType()).getInnerTypeNode());
				node.setType(innerType);
			}
			
			// if it is a check entire type, the return type is the typenode of the object the method is called on
			else if(((ReservedWordTypeNode) funSym.getType()).getType() == Types.Flags.CHECK_ENTIRE_TYPE) {
				node.setType(node.getObjectOfMethod().getType());
			}
			
			else {
				node.setType(funSym.getType());
			}
		}
		
		// otherwise, set the type to what is indicated in the symbol table
		else {
			node.setType(funSym.getType());
		}
	}

	@Override
	public void visit(PrimaryExpressionNode node) {
		LOGGER.finer("Type Check visit(PrimaryExpressionNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(PrimitiveTypeNode node) {
		LOGGER.finer("Type Check visit(PrimitiveTypeNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(ProgramNode node) {
		LOGGER.finer("Type Check visit(ProgramNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(RelationalExpressionNode node) {
		LOGGER.finer("Type Check visit(RelationalExpressionNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);
		node.setType(Types.getResult(node.getOpType(), node.getLeftNode().getType(), node.getRightNode().getType()));
		

	}

	@Override
	public void visit(ReservedWordTypeNode node) {
		LOGGER.finer("Type Check visit(ReservedWordTypeNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(SectionNode node) {
		LOGGER.finer("Type Check visit(SectionNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(SectionTypeNode node) {
		LOGGER.finer("Type Check visit(SectionTypeNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(SelectionStatementNode node) {
		LOGGER.finer("Type Check visit(SelectionStatementNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(StatementListNode node) {
		LOGGER.finer("Type Check visit(StatementListNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(StatementNode node) {
		LOGGER.finer("Type Check visit(StatementNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(SwitchStatementNode node) {
		LOGGER.finer("Type Check visit(SwitchStatementNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	public void visit(TypeNode node) {
		LOGGER.finer("Type Check visit(TypeNode node) called on "
				+ node.getName());
		visitAllChildrenStandard(node);

	}

	@Override
	/**
	 * This will visit the UnOpNode's child first, and then set the type of this node
	 * based on the opType and the type of the child
	 */
	public void visit(UnOpNode node) {
		LOGGER.finer("Type Check visit(UnOpNode node) called on "
				+ node.getName());

		// call on children - only one child
		visitAllChildrenStandard(node);

		// check if they are compatible
		Types.isCompatible(node.getOpType(), node.getChild().getType());

		// set type of this UnOpNode
		node.setType(Types.getResult(node.getOpType(), node.getChild()
				.getType()));

	}

}