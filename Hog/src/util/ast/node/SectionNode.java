package util.ast.node;

import java.util.ArrayList;

import util.type.Types;

import back_end.Visitor;

/**
 * This node is for the @Functions, @Map, @Reduce and @Main sections
 * 
 * @author Samuel Messing 
 * @author comments by Benjamin Rapaport
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
	protected SectionTypeNode sectionTypeNode;
	
	protected StatementListNode block;

	/** Constructor SectionNode(StatementListNode list, SectionName sectionName)
	 * use this constructor for @functions and @Main sections
	 * @param list
	 * @param sectionName
	 */
	public SectionNode(StatementListNode list, SectionName sectionName) {
		SectionNode.LOGGER.fine("adding list child to @Functions or @Main SectionNode");
		this.addChild(list);
		this.block = list;
		this.sectionName = sectionName;
	}

	/** Constructor SectionNode(SectionTypeNode type, StatementListNode list, SectionName sectionName)
	 * Use this constructor for @map and @reduce sections
	 * @param type
	 * @param list
	 * @param sectionName
	 */
	public SectionNode(SectionTypeNode sectionTypeNode, StatementListNode list, SectionName sectionName) {
		this.children = new ArrayList<Node>();
		SectionNode.LOGGER.fine("adding list child to @Map or @Reduce SectionNode");
		this.addChild(sectionTypeNode);
		this.addChild(list);
		this.block = list;
		this.sectionName = sectionName;
		this.sectionTypeNode = sectionTypeNode;
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
		return id + "-SectionNode: " + sectionName + "newscope: " + isNewScope();
	}
	
	public SectionName getSectionName() {
		return sectionName;
	}

	public StatementListNode getBlock() {
		return block;
	}
	/** Method Returns SectionTypeNode Field
	 * 
	 * @return
	 */
	public SectionTypeNode getSectionTypeNode(){
		return this.sectionTypeNode;
	}
	
	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
