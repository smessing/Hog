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

	public CodeGeneratingVisitor(AbstractSyntaxTree root) {

		this.tree = root;
		this.code = new StringBuilder();

	}

	@Override
	public void visit(BiOpNode node) {
		LOGGER.finer("visit(BiOpNode node) called on " + node);
		
		StringBuilder line = new StringBuilder();
		switch (node.getOpType()) {
		case ASSIGN:
			line.append(node.getLeftNode().toSource());
			line.append(" = ");
			line.append(node.getRightNode().toSource());

		}

		LOGGER.fine("Writing to java source: " + line.toString());
		code.append(line.toString());
		
	}

	@Override
	public void visit(ConstantNode node) {
		// node specific code generation operations here
		try {
			// out.write(node.getName() + " "+node.getValue() + ";");
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(ExpressionNode node) {
		// node specific code generation operations here
		try {
			// out.write("Expression Node: "+node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(IdNode node) {
		// node specific code generation operations here
		try {
			// out.write(node.getIdentifier());
			// out.write("Visit ID NODE: "+node.getTypeName());
		} catch (Exception e) {

		}
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
	public void visit(ElseIfStatementNode node) {
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(ElseStatementNode node) {
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
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
		// TODO Auto-generated method stub
		try {
			out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(GuardingStatementNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IfElseStatementNode node) {
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
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
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

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
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
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
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
	}

	@Override
	public void visit(StatementNode node) {
		// TODO Auto-generated method stub
		try {
			// out.write(node.getName());
		} catch (Exception e) {

		}
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
	public void walk()  {

		writeHeader();
		
		// start recursive walk:

		walk(tree.getRoot());

	}
	
	public String getCode() {
		return code.toString();
	}
	
	private void writeHeader() {
		
		LOGGER.fine("Writing header to code");
		
		code.append("import java.io.IOException;");
		code.append("import java.util.*;");

		code.append("import org.apache.hadoop.fs.Path;");
		code.append("import org.apache.hadoop.conf.*;");
		code.append("import org.apache.hadoop.io.*;");
		code.append("import org.apache.hadoop.mapreduce.*;");
		code.append("import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;");
		code.append("import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;");
		code.append("import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;");
		code.append("import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;");
		
	}

	public void walk(Node node) {

		// base cases (else, recurse):

		if (node instanceof BiOpNode) {
			node.accept(this);
			appendNewline();
		} else {
			for (Node child : node.getChildren()) {
				walk(child);
			}
		}

	}

	private void appendNewline() {

		try {
			out.newLine();
		} catch (IOException ioe) {
			ioe.printStackTrace();
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