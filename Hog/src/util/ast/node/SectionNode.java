package util.ast.node;

import java.util.ArrayList;

import util.type.Types;

import back_end.Visitor;

/**
 * This node is for the @Functions, @Map, @Reduce and @Main sections
 * 
 * @author sam (commented by ben)
 *
 */
public class SectionNode extends Node {

	/** enum SectionName
	 * name of section, ie, main, map, reduce, functions 
	 */
	public static enum SectionName {
		FUNCTIONS, MAP, REDUCE, MAIN;
		}
	
	/** sectionName field with type SectionName 
	 * name of section, ie, main, map, reduce, functions
	 * */
	protected SectionName sectionName;
	
	/** type field which has type SectionTypeNode 
	 * Used to defined key-value pair types for input and ouput
	 * */
	protected SectionTypeNode type;

	/** Constructor SectionNode(StatementListNode list, SectionName sectionName)
	 * use this constructor for @functions and @Main sections
	 * @param list
	 * @param sectionName
	 */
	public SectionNode(StatementListNode list, SectionName sectionName) {
		SectionNode.LOGGER.fine("adding list child to @Functions or @Main SectionNode");
		this.addChild(list);
		this.sectionName = sectionName;
	}

	/** Constructor SectionNode(SectionTypeNode type, StatementListNode list, SectionName sectionName)
	 * Use this constructor for @map and @reduce sections
	 * @param type
	 * @param list
	 * @param sectionName
	 */
	public SectionNode(SectionTypeNode type, StatementListNode list, SectionName sectionName) {
		this.children = new ArrayList<Node>();
		SectionNode.LOGGER.fine("adding list child to @Map or @Reduce SectionNode");
		this.addChild(type);
		this.addChild(list);
		this.sectionName = sectionName;
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
		return "SectionNode: " + sectionName;
	}
	
	public SectionName getSectionName() {
		return sectionName;
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
