package util.ast.node;

import java.util.ArrayList;
import java.util.List;

import back_end.Visitor;

/**
 * A node representing the Parameters nonterminal in a parse tree.
 * 
 * @author Samuel Messing
 * @author Benjamin Rapaport
 * 
 * 
 */
public class ParametersNode extends ExpressionNode {

	protected String identifier;
	protected ParametersNode paramChild;
	
	public ParametersNode(TypeNode paramType) {
		super(paramType);
	}

	public ParametersNode(TypeNode type, String identifier) {
		super(type);
		this.identifier = identifier;
		ParametersNode.LOGGER
				.fine("Constructing ParametersNode with one param");
	}

	// deepest node in this chain is the first parameter in the list
	public ParametersNode(TypeNode type, String identifier,
			ParametersNode paramChild) {
		super(type);
		this.addChild(paramChild);
		this.identifier = identifier;
		this.paramChild = paramChild;
		ParametersNode.LOGGER
				.fine("Constructing ParametersNode with multiple params");
	}
	
	public boolean hasParamChild() {
		return this.paramChild != null;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String printForSymbolTable(){
		
		StringBuffer strBuff = new StringBuffer();
		
		return this.printForSymbolTableHelper(strBuff).toString();
	}
	

	public StringBuffer printForSymbolTableHelper(StringBuffer buff){
		
		if(this.hasParamChild()) 
			this.getParamChild().printForSymbolTableHelper(buff);
		
		buff.append(this.getTypeName());
		
		return buff;
	}
	
	/** Method to Return the name getName()
	 * @return Returns a string with the node's name
	 */
	@Override
	public String getName() {
		return id + "-ParemetersNode<" + this.getTypeName() + " "
				+ this.getIdentifier() + "> newscope: " + isNewScope();
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public int visitorTest(Visitor v) {
		v.visit(this);
		return 12;
	}
	
	public ParametersNode getParamChild() {
		return this.paramChild;
	}
	
	public void setParamChild(ParametersNode child) {
		this.paramChild = child;
		this.addChild(child);
	}

	/**
	 * 
	 * @return the number of parameters the node represents
	 */
	public int getNumParams() {
		return getNumParamsHelper(1);
	}
	
	/**
	 * Helper function to get number of parameters
	 * @param numParams
	 * @return
	 */
	private int getNumParamsHelper(int numParams) {
		if (this.getParamChild() == null) {
			return numParams;
		}
		else {
			return this.getParamChild().getNumParamsHelper(numParams + 1);
		}
	}
}
