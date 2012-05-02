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
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(BiOpNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(CatchesNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ConstantNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(DerivedTypeNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(DictTypeNode node) {
		// TODO Auto-generated method stub

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
	public void visit(ExpressionNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(FunctionNode node) {
		
		// add function to symbol table - these need to be visible to entire program
		FunctionSymbol funSym = new FunctionSymbol(node.getType(), node.getParametersNode());
		try {
			SymbolTable.put(node.getIdentifier(), funSym);
		} catch (VariableRedefinedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				}
			}
					
		}
		
		// close scope
		closeScope(node);

	}

	@Override
	public void visit(GuardingStatementNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IdNode node) {
		openScope(node);
		
		// if it has a type, it is a declaration. Put it in the symbol table
		if(node.getType() != null) {
			try {
				SymbolTable.put(node.getIdentifier(), new VariableSymbol(node.getType()));
			} catch (VariableRedefinedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		//else, it does not have a type, so we ensure it is already declared
		else {
			SymbolTable nodesTable = SymbolTable.getMappedSymbolTable(node);
			if (nodesTable == null) {
				throw new VariableUndeclaredException(node.getIdentifier() + " was used before it was declared.");
			}
			
		}

		closeScope(node);
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
	public void visit(MockExpressionNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(MockNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Node node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ParametersNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(PostfixExpressionNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(PrimaryExpressionNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(PrimitiveTypeNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ProgramNode node) {
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(RelationalExpressionNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ReservedWordTypeNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(SectionNode node) {
		
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
		
	}

	@Override
	public void visit(SectionTypeNode node) {
		
		openScope(node);
		
		// add emit() with the parameters as specified by the SectionTypeNode
		List<TypeNode> emitParams = new ArrayList<TypeNode>();
		emitParams.add(node.getReturnKey());
		emitParams.add(node.getReturnValue());
		FunctionSymbol funSym = new FunctionSymbol(new PrimitiveTypeNode(Types.Primitive.VOID), emitParams);
		
		try {
			SymbolTable.put("emit", funSym);
		} catch (VariableRedefinedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeScope(node);
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
		openScope(node);
		visitAllChildrenStandard(node);
		closeScope(node);
	}

	@Override
	public void visit(SwitchStatementNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(TypeNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(UnOpNode node) {
		// TODO Auto-generated method stub

	}
	
	

}
