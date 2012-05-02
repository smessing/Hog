package back_end;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import util.FunctionSymbol;
import util.SymbolTable;
import util.VariableSymbol;
import util.ast.AbstractSyntaxTree;
import util.ast.node.*;
import util.type.Types;
import util.type.VariableRedefinedException;
import util.type.VariableUndeclaredException;


/**
 * 
 * @author ben, jason
 *
 */

public class SymbolTableVisitor implements Visitor {
	
	protected AbstractSyntaxTree tree;
	
	public SymbolTableVisitor(AbstractSyntaxTree tree) {
		this.tree = tree;
	}
	
	protected final static Logger LOGGER = Logger
			.getLogger(SymbolTableVisitor.class.getName());
	
	public void walk() {
		
		ProgramNode treeRoot = (ProgramNode) this.tree.getRoot();
		treeRoot.accept(this);
	}
	
	private void openScope(Node node) {
		
		// push new scope
		if(node.isNewScope()) {
			SymbolTable.push();
			
			// map this as representative node
			try {
				SymbolTable.mapNode(node);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}

	}
	
	private void closeScope(Node node) {

		
		// pop if this was a new scope
		if(node.isNewScope()) {
			SymbolTable.pop();
		}
	
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
		LOGGER.info("SymbolTableVistor visiting ArgumentsNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(BiOpNode node) {
		LOGGER.info("SymbolTableVistor visiting BiOpNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(CatchesNode node) {
		LOGGER.info("SymbolTableVistor visiting CatchesNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(ConstantNode node) {
		LOGGER.info("SymbolTableVistor visiting ConstantNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);

	}

	@Override
	public void visit(DerivedTypeNode node) {
		LOGGER.info("SymbolTableVistor visiting DerivedTypeNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);

	}

	@Override
	public void visit(DictTypeNode node) {
		LOGGER.info("SymbolTableVistor visiting DictTypeNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);

	}

	@Override
	public void visit(ElseIfStatementNode node) {
		LOGGER.info("SymbolTableVistor visiting ElseIfStatementNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(ElseStatementNode node) {
		LOGGER.info("SymbolTableVistor visiting ElseStatementNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);

	}

	@Override
	public void visit(ExceptionTypeNode node) {
		LOGGER.info("SymbolTableVistor visiting ExceptionTypeNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);

	}

	@Override
	public void visit(ExpressionNode node) {
		LOGGER.info("SymbolTableVistor visiting ExpressionNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);

	}

	@Override
	public void visit(FunctionNode node) {
		LOGGER.info("SymbolTableVistor visiting FunctionNode");
		
		// add function to symbol table - these need to be visible to entire program
		FunctionSymbol funSym = new FunctionSymbol(node.getType(), node.getParametersNode());
		try {
			SymbolTable.put(node.getIdentifier(), funSym);
		} catch (VariableRedefinedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		// open new scope - these are specific to within the function
		openScope(node);
		
		// add variables and types in the params list to the symbol table
		ParametersNode currParamNode = node.getParametersNode();
		if( currParamNode != null) {
			TypeNode paramType = currParamNode.getType();
			String paramName = currParamNode.getIdentifier();
			try {
				SymbolTable.put(paramName, new VariableSymbol(paramType));
			} catch (VariableRedefinedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// recurse through children, adding variables to the symbol table
			while(currParamNode.hasChildren()) {
				currParamNode = (ParametersNode) currParamNode.getChildren().get(0);
				paramType = currParamNode.getType();
				paramName = currParamNode.getIdentifier();
				try {
					SymbolTable.put(paramName, new VariableSymbol(paramType));
				} catch (VariableRedefinedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.exit(1);
				}
			}
		}
		
		// close scope
		closeScope(node);

	}

	@Override
	public void visit(GuardingStatementNode node) {
		LOGGER.info("SymbolTableVistor visiting GuardingStatementNode");

		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(IdNode node) {
		LOGGER.info("SymbolTableVistor visiting IdNode: " + node.getName());
		openScope(node);
		
		LOGGER.info("SymbolTableVistor after openScope");
		// if it has a type, it is a declaration. Put it in the symbol table
		if(node.getType() != null) {
			try {
				LOGGER.info("before put 1");	
				SymbolTable.put(node.getIdentifier(), new VariableSymbol(node.getType()));
			} catch (VariableRedefinedException e) {
				// TODO Auto-generated catch block
				LOGGER.info("put 1 failed");
				e.printStackTrace();
				System.exit(1);
			}
		} 
		
		//else, it does not have a type, so we ensure it is already declared
		else {
			LOGGER.info("IdNode does not have a type. Before getMappedSymbolTable");
			SymbolTable nodesTable = SymbolTable.getMappedSymbolTable(node);
			LOGGER.info("After getMappedSymbolTable");
			if (nodesTable == null) {
				try {
					throw new VariableUndeclaredException(node.getIdentifier() + " was used before it was declared.");
				} catch (VariableUndeclaredException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.exit(1);
				}
			}
			
		}
		
		LOGGER.info("SymbolTableVistor after SymbolTable.put(...)");

		closeScope(node);
	}

	@Override
	public void visit(IfElseStatementNode node) {
		LOGGER.info("SymbolTableVistor visiting IfElseStatementNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(IterationStatementNode node) {
		LOGGER.info("SymbolTableVistor visiting IterationStatementNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(JumpStatementNode node) {
		LOGGER.info("SymbolTableVistor visiting JumpStatementNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(MockExpressionNode node) {
		LOGGER.info("SymbolTableVistor visiting MockExpressionNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(MockNode node) {
		LOGGER.info("SymbolTableVistor visiting MockNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(Node node) {
		LOGGER.info("SymbolTableVistor visiting Node");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(ParametersNode node) {
		LOGGER.info("SymbolTableVistor visiting ParametersNode");
		openScope(node);
		// we have already recursed through each paramater when visiting the function node
		//visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(PostfixExpressionNode node) {
		LOGGER.info("SymbolTableVistor visiting PostFixExpressionNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(PrimaryExpressionNode node) {
		LOGGER.info("SymbolTableVistor visiting PrimaryExpressionNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(PrimitiveTypeNode node) {
		LOGGER.info("SymbolTableVistor visiting PrimitiveExpressionNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(ProgramNode node) {
		LOGGER.info("SymbolTableVistor visiting ProgramNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(RelationalExpressionNode node) {
		LOGGER.info("SymbolTableVistor visiting RelationalExpressionNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(ReservedWordTypeNode node) {
		LOGGER.info("SymbolTableVistor visiting ReservedWordTypeNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(SectionNode node) {
		LOGGER.info("SymbolTableVistor visiting SectionNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(SectionTypeNode node) {
		LOGGER.info("SymbolTableVistor visiting SectionTypeNode");
		
		openScope(node);
		
		// add emit() with the parameters as specified by the SectionTypeNode
		List<TypeNode> emitParams = new ArrayList<TypeNode>();
		emitParams.add(node.getReturnKey());
		emitParams.add(node.getReturnValue());
		FunctionSymbol funSym = new FunctionSymbol(new PrimitiveTypeNode(Types.Primitive.VOID), emitParams);
		
		// add input key and value
		VariableSymbol inputKeySym = new VariableSymbol(node.getInputKeyIdNode().getType());
		String inputKeyStr = node.getInputKeyIdNode().getIdentifier();
		
		VariableSymbol inputValueSym = new VariableSymbol(node.getInputValueIdNode().getType());
		String inputValStr = node.getInputValueIdNode().getIdentifier();
		
		
		try {
			SymbolTable.put(inputKeyStr, inputKeySym);
			SymbolTable.put(inputValStr, inputValueSym);
			SymbolTable.put("emit", funSym);
		} catch (VariableRedefinedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		

		
		
		closeScope(node);
	}

	@Override
	public void visit(SelectionStatementNode node) {
		LOGGER.info("SymbolTableVistor visiting SelectionStatementNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(StatementListNode node) {
		LOGGER.info("SymbolTableVistor visiting StatementListNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(StatementNode node) {
		LOGGER.info("SymbolTableVistor visiting StatementNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(SwitchStatementNode node) {
		LOGGER.info("SymbolTableVistor visiting SwitchStatementNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(TypeNode node) {
		LOGGER.info("SymbolTableVistor visiting TypeNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(UnOpNode node) {
		LOGGER.info("SymbolTableVistor visiting UnOpNode");
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}
}
