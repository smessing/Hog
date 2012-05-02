package back_end;

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

import util.ast.AbstractSyntaxTree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Visitor class for generating Java source.
 * 
 * This is the third (and final) walk performed after construction of the AST
 * from source. CodeGeneratingVisitor generates a massive String representing
 * the translated Hog program.
 * 
 * 
 * @author kurry, sam
 * 
 */
public class CodeGeneratingVisitor implements Visitor {

	protected final static Logger LOGGER = Logger
			.getLogger(CodeGeneratingVisitor.class.getName());

	protected AbstractSyntaxTree tree;
	protected StringBuilder code;
	protected StringBuilder line;

	public CodeGeneratingVisitor(AbstractSyntaxTree root) {

		this.tree = root;
		this.code = new StringBuilder();
		this.line = new StringBuilder();

	}

	public String getCode() {
		return code.toString();
	}

	@Override
	public void walk() {

		writeHeader();

		// start recursive walk:

		walk(tree.getRoot());

	}

	public void walk(Node node) {

		node.accept(this);

		// base cases (sometimes recursion needs to go through visit methods
		// as with If Else statements).

		boolean baseCase = false;

		if (node instanceof IfElseStatementNode) {
			baseCase = true;
		} else if (node instanceof FunctionNode) {
			baseCase = true;
		} else if (node.getChildren().isEmpty()) {
			baseCase = true;
		}

		// continue recursion if not base case:

		if (!baseCase) {
			for (Node child : node.getChildren()) {
				walk(child);
			}
		}

	}

	private void writeHeader() {

		LOGGER.fine("Writing header to code");

		code.append("import java.io.IOException;\n");
		code.append("import java.util.*;\n");
		code.append("import org.apache.hadoop.fs.Path;\n");
		code.append("import org.apache.hadoop.conf.*;\n");
		code.append("import org.apache.hadoop.io.*;\n");
		code.append("import org.apache.hadoop.mapreduce.*;\n");
		code
				.append("import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;\n");
		code
				.append("import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;\n");
		code
				.append("import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;\n");
		code
				.append("import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;\n");

	}

	private void writeFunctions() {
		line.append("}\n");
		code.append(line.toString());
		// reset line
		line = new StringBuilder();
	}

	private void writeStatement() {
		code.append(line.toString());
		// reset line
		line = new StringBuilder();
		code.append(";\n");
	}

	@Override
	public void visit(BiOpNode node) {
		LOGGER.finer("visit(BiOpNode node) called on " + node);

		walk(node.getLeftNode());

		switch (node.getOpType()) {
		case ASSIGN:
			line.append(" = ");
			break;
		case DBL_EQLS:
			line.append(" == ");
			break;
		case PLUS:
			line.append(" + ");
			break;
		case OR:
			line.append(" || ");
			break;
		case TIMES:
			line.append(" * ");
			break;
		case MINUS:
			line.append(" - ");
			break;
		}

		walk(node.getRightNode());

		if (line.toString().length() == 0) {
			throw new UnsupportedOperationException("BiOpType: "
					+ node.getOpType() + " not supported yet.");
		}

		LOGGER.fine("Writing to java source: " + line.toString() + ";");/**/

	}

	@Override
	public void visit(ConstantNode node) {
		LOGGER.finer("visit(ConstantNode node) called on " + node);
		line.append(node.toSource());

	}

	@Override
	public void visit(ExpressionNode node) {
		LOGGER.finer("visit(ExpressionNode node) called on " + node);
	}

	@Override
	public void visit(IdNode node) {
		LOGGER.finer("visit(IdNode node) called on " + node);
		line.append(node.toSource());

	}

	@Override
	public void visit(MockNode node) {
		// node specific code generation operations here
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(MockExpressionNode node) {
		// node specific code generation operations here
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(Node node) {
		// node specific code generation operations here
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(ParametersNode node) {
		// node specific code generation operations here
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(PrimaryExpressionNode node) {
		// node specific code generation operations here
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(RelationalExpressionNode node) {
		// node specific code generation operations here
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(UnOpNode node) {
		// node specific code generation operations here
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(ArgumentsNode node) {
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}

	}

	@Override
	public void visit(CatchesNode node) {
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}

	}

	@Override
	public void visit(DerivedTypeNode node) {
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}

	}

	@Override
	public void visit(IfElseStatementNode node) {
		LOGGER.finer("visit(IfElseStatementNode node) called on " + node);

		line.append("if ( ");
		line.append(node.getCondition().toSource());
		line.append(" ) {\n");
		walk(node.getIfCondTrue());
		if (node.getCheckNext() != null) {
			walk(node.getCheckNext());
		}
		if (node.getIfCondFalse() != null) {
			walk(node.getIfCondFalse());
		}
		line.append("\n}\n");
	}

	@Override
	public void visit(ElseIfStatementNode node) {
		LOGGER.finer("visit(ElseIfStatementNode node) called on " + node);

		line.append("\n} else if ( ");
		line.append(node.getCondition().toSource());
		line.append(" ) {\n");
		walk(node.getIfCondTrue());
		if (node.getIfCondFalse() != null) {
			walk(node.getIfCondFalse());
		}
		line.append("\n}\n");

	}

	@Override
	public void visit(ElseStatementNode node) {
		LOGGER.finer("visit(ElseStatementNode node) called on " + node);

		line.append("else {\n");
		walk(node.getBlock());
		line.append("\n}\n");

	}

	@Override
	public void visit(ExceptionTypeNode node) {
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(FunctionNode node) {

			line.append("public static " + node.getType().toSource() + " "
					+ node.getIdentifier());

			ParametersNode params = node.getParametersNode();
			line.append("(");
			line.append(params.getType().toSource());
			line.append(" " + params.getIdentifier());
			line.append(")");
			line.append(" {\n");
			walk(node.getInstructions());
			
			writeFunctions();


	}

	@Override
	public void visit(GuardingStatementNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IterationStatementNode node) {
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(JumpStatementNode node) {
		switch(node.getJumpType()) {
		case RETURN:
			line.append("return ");
			break;
		case BREAK:
			line.append("break;");
			break;
		case CONTINUE:
			line.append("continue;");
			break;
		}
		
		if (node.getExpressionNode() != null) {
			walk(node.getExpressionNode());
		}
	}

	@Override
	public void visit(PostfixExpressionNode node) {
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(PrimitiveTypeNode node) {
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(ProgramNode node) {
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(SectionNode node) {

		SectionNode.SectionName sectionKind = node.getSectionName();

		switch (sectionKind) {
		case FUNCTIONS:
			line.append("public static class Functions {\n");

			return;
		case MAP:
			code
					.append("public static class Map extends Mapper<LongWritable, Text, Text, IntWritable> {");

			code.append("}\n");
			return;
		case REDUCE:
			code
					.append("public static class Reduce extends Reducer<Text, IntWritable, Text, IntWritable> {");

			code.append("}\n");
			return;
		case MAIN:
			code
					.append("public static void main(String[] args) throws Exception {");

			code.append("}\n");
			return;
		}

		throw new UnsupportedOperationException("Section kind: " + sectionKind
				+ " not supported yet.");
	}

	@Override
	public void visit(SectionTypeNode node) {
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(SelectionStatementNode node) {
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(StatementListNode node) {

		for (Node child : node.getChildren()) {
			child.accept(this);
		}

		writeStatement();

	}

	@Override
	public void visit(StatementNode node) {

		LOGGER.finer("visit(StatementNode node) called on " + node);

		for (Node child : node.getChildren()) {
			child.accept(this);
		}

		writeFunctions();

	}

	@Override
	public void visit(SwitchStatementNode node) {
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(TypeNode node) {
		// TODO Auto-generated method stub

		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(DictTypeNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ReservedWordTypeNode node) {
		// TODO Auto-generated method stub

	}

}