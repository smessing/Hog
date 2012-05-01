package back_end;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import util.FunctionSymbol;
import util.SymbolTable;
import util.VariableSymbol;
import util.ast.AbstractSyntaxTree;
import util.ast.node.*;


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

	@Override
	public void visit(ArgumentsNode node) {
		// TODO Auto-generated method stub

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
		SymbolTable.put(node.getIdentifier(), funSym);
		
		// open new scope - these are specific to within the function
		openScope(node);
		
		// add variables and types in the params list to the symbol table
		ParametersNode currParamNode = node.getParametersNode();
		if( currParamNode != null) {
			TypeNode paramType = currParamNode.getType();
			String paramName = currParamNode.getIdentifier();
			SymbolTable.put(paramName, new VariableSymbol(paramType));
			
			// recurse through children, adding variables to the symbol table
			while(currParamNode.hasChildren()) {
				currParamNode = (ParametersNode) currParamNode.getChildren().get(0);
				paramType = currParamNode.getType();
				paramName = currParamNode.getIdentifier();
				SymbolTable.put(paramName, new VariableSymbol(paramType));
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
		
		// visit all children
		List<Node> children = node.getChildren();
		for (Node n : children) {
			n.accept(this);
		}
		
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
		
		// visit all children
		List<Node> children = node.getChildren();
		for (Node n : children) {
			n.accept(this);
		}
		
		closeScope(node);
		
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

	@Override
	public void visit(UnOpNode node) {
		// TODO Auto-generated method stub

	}
	
	

}
