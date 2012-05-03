package util.ast.node;

import java.util.ArrayList;

import back_end.Visitor;

public class ProgramNode extends Node {

	/** functions field of type SectionNode */
	protected SectionNode functions;
	/** map field of type SectionNode */
	protected SectionNode map;
	/** reduce field of type SectionNode  */
	protected SectionNode reduce;
	/** main field of type SectionNode*/
	protected SectionNode main;
	
	/** Constructor of ProgramNode(SectionNode map, SectionNode return, SectionNode main)
	 * 
	 * @param map
	 * @param reduce
	 * @param main
	 */
	public ProgramNode(SectionNode map, SectionNode reduce, SectionNode main) {
		this(null, map, reduce, main);
	}
	/** Constructor ProgramNode(SectionNode functions, SectionNode map, SectionNode reduce, SectionNode main)
	 * 
	 * @param functions
	 * @param map
	 * @param reduce
	 * @param main
	 */
	public ProgramNode(SectionNode functions, SectionNode map,
			SectionNode reduce, SectionNode main) {
		super();
		this.functions = functions;
		this.map = map;
		this.reduce = reduce;
		this.main = main;
		// protect against adding a null child
		if (this.hasFunctions()) children.add(functions);
		children.add(map);
		children.add(reduce);
		children.add(main);
	}
	
	public boolean hasFunctions() {
		return (functions != null);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);

	}
	/** Method to Return the name getName()
	 * @return Returns a string with the node's name
	 */
	@Override
	public String getName() {
		return id + "-ProgramNode newscope: " + isNewScope();
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
