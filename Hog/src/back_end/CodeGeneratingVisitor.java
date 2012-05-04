package back_end;

import util.ast.node.*;
import util.ast.AbstractSyntaxTree;
import util.type.Types;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;

/**
 * Visitor class for generating Java source.
 * 
 * This is the fourth (and final) walk performed after construction of the AST
 * from source. CodeGeneratingVisitor generates a massive String representing
 * the translated Hog program.
 * 
 * 
 * @author Samuel Messing
 * @author Kurry Tran
 * 
 */
public class CodeGeneratingVisitor implements Visitor {

	protected final static Logger LOGGER = Logger
			.getLogger(CodeGeneratingVisitor.class.getName());
	/**
	 * The format of the input files to the <code>map</code> class. Currently
	 * Hog only supports text formats, so this doesn't need to be set by the
	 * constructor.
	 */
	protected final String inputFormatClass = "TextInputFormat.class";
	/**
	 * The format of the output files from the <code>reduce</code> class.
	 * See {@link #inputFormatClass inputFormatClass} for more details.
	 */
	protected final String outputFormatClass = "TextInputFormat.class";

	protected AbstractSyntaxTree tree;
	protected StringBuilder code;
	protected StringBuilder line;
	protected String outputKeyClass;
	protected String outputValueClass;
	protected String inputFile = "example.txt";
	protected String outputFile = "example.txt";

	/**
	 * Construct a CodeGeneratingVisitor, but don't specify input file or output file.
	 * <p>
	 * Mainly used for testing/development purposes.
	 * @param root the root of the AST representing the Hog source program.
	 */
	public CodeGeneratingVisitor(AbstractSyntaxTree root) {

		this.tree = root;
		this.code = new StringBuilder();
		this.line = new StringBuilder();

	}

	/**
	 * Construct a CodeGeneratingVisitor, specifying the input file name and the
	 * output file name for the corresponding Hadoop job.
	 * 
	 * <pre>
	 * public {@link CodeGeneratingVisitor}({@link AbstractSyntaxTree} root, {@link String} inputFile, {@link String} outputFile)
	 * </pre>
	 * 
	 * @param root
	 *            The root node of the Hog source program's AST.
	 * @param inputFile
	 *            The inputFile for the <code>map</code> class to read from.
	 * @param outputFile
	 *            The outputFile for the <code>reduce</code>
	 * class to write to.
	 */
	public CodeGeneratingVisitor(AbstractSyntaxTree root, String inputFile,
			String outputFile) {

		this(root);
		this.inputFile = inputFile;
		this.outputFile = outputFile;

	}

	/**
	 * Return the Java source code translated from the AST.
	 * 
	 * @return a string representation (formatted) of the java source code.
	 */
	public String getCode() {
		formatCode();
		return code.toString();
	}

	@Override
	public void walk() {

		writeHeader();

		// start recursive walk:

		walk(tree.getRoot());

		code.append("}");

	}

	private void walk(Node node) {

		node.accept(this);

		if (node.isEndOfLine()) {
			writeStatement();
		}

		// base cases (sometimes recursion needs to go through visit methods
		// as with If Else statements).

		boolean baseCase = false;

		if (node instanceof IfElseStatementNode) {
			baseCase = true;
		} else if (node instanceof SectionNode) {
			baseCase = true;
		} else if (node instanceof FunctionNode) {
			baseCase = true;
		} else if (node instanceof JumpStatementNode) {
			baseCase = true;
		} else if (node instanceof StatementNode) {
			baseCase = true;
		} else if (node instanceof StatementListNode) {
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
		LOGGER.fine("Writing header to code.");
		code.append("import java.io.IOException;");
		code.append("import java.util.*;");
		code.append("import org.apache.hadoop.fs.Path;");
		code.append("import org.apache.hadoop.conf.*;");
		code.append("import org.apache.hadoop.io.*;");
		code.append("import org.apache.hadoop.mapred.*;");
		code.append("public class Hog {");
	}

	private void writeMapReduce() {
		LOGGER.fine("Writing mapReduce initialization code.");
		line.append("JobConf conf = new JobConf(Hog.class);");
		line.append("conf.setJobName(\"hog\");");
		line.append("conf.setOutputKeyClass(" + outputKeyClass + ".class);");
		line
				.append("conf.setOutputValueClass(" + outputValueClass
						+ ".class);");
		line.append("conf.setMapperClass(Map.class);");
		line.append("conf.setCombinerClass(Reduce.class);");
		line.append("conf.setReducerClass(Reduce.class);");
		line.append("conf.setInputFormat(" + inputFormatClass + ");");
		line.append("conf.setOutputFormat(" + outputFormatClass + ");");
		line.append("FileInputFormat.setInputPaths(conf, new Path(\""
				+ inputFile + "\"));");
		line.append("FileOutputFormat.setOutputPath(conf, new Path(\""
				+ outputFile + "\"));");
		line.append("JobClient.runJob(conf);");
	}

	private void writeFunction() {
		line.append("");
		code.append(line.toString());
		LOGGER
				.fine("[writeFunction] Writing to java source:"
						+ line.toString());/**/
		// reset line
		line = new StringBuilder();
	}

	private void writeBlockEnd() {
		line.append("}");
		code.append(line.toString());
		LOGGER.fine("[writeFunctions] Writing to java source:"
				+ line.toString());/**/
		// reset line
		line = new StringBuilder();
	}

	/*
	 * Write the end of a statement.
	 * 
	 * Protects against writing multiple semicolons, as an ease for the
	 * programmer.
	 */
	private void writeStatement() {
		if (!line.toString().endsWith("}") && !line.toString().endsWith(";")
				&& !code.toString().endsWith("}")
				&& !code.toString().endsWith(";")) {
			line.append(";");
		}
		code.append(line.toString());
		LOGGER.fine("[writeStatement] Writing to java source:"
				+ line.toString());
		// reset line
		line = new StringBuilder();
	}

	/*
	 * this.code originally is built as a monolithic string without newlines and
	 * other formatting. formatCode() adds both newlines after statements and
	 * proper indentation based on scope.
	 */
	private void formatCode() {
		int scopeCount = 0;
		StringBuilder indentedCode = new StringBuilder();
		for (int i = 0; i < code.length(); i++) {
			switch (code.charAt(i)) {
			case '{':
				scopeCount++;
				indentedCode.append("{\n");
				indentedCode.append(repeat(' ', 4 * scopeCount));
				break;
			case '}':
				scopeCount--;
				// we're reducing scope, so need to undo the spaces previously
				// written
				indentedCode.delete(indentedCode.length() - 4, indentedCode
						.length());
				indentedCode.append("}\n");
				indentedCode.append(repeat(' ', 4 * scopeCount));
				break;
			case ';':
				indentedCode.append(";\n");
				indentedCode.append(repeat(' ', 4 * scopeCount));
				break;
			default:
				indentedCode.append(code.charAt(i));
			}
		}
		code = indentedCode;
	}

	/**
	 * Repeat a character n times.
	 * 
	 * @param toRepeat
	 *            the character to repeat
	 * @param times
	 *            the number of times to repeat <code>toRepeat</code>
	 * @return the String formed by repeating <code>toRepeat</code> n=
	 *         <code>times</code> times in a row.
	 */
	private String repeat(char toRepeat, int times) {
		StringBuilder repeated = new StringBuilder();
		for (int i = 0; i < times; i++)
			repeated.append(toRepeat);
		return repeated.toString();
	}

	@Override
	public void visit(ArgumentsNode node) {
		LOGGER.finer("visit(ArgumentsNode node) called on " + node);

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
		case NOT_EQLS:
			line.append(" != ");
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
		case LESS:
			line.append(" < ");
			break;
		case LESS_EQL:
			line.append(" <= ");
			break;
		case GRTR:
			line.append(" > ");
			break;
		case GRTR_EQL:
			line.append(" >= ");
			break;
		case DIVIDE:
			line.append(" / ");
			break;
		case MOD:
			line.append(" % ");
			break;
		case AND:
			line.append(" && ");
			break;
		}
		walk(node.getRightNode());

	}

	@Override
	public void visit(CatchesNode node) {
		LOGGER.finer("visit(CatchesNode node) called on " + node);

	}

	@Override
	public void visit(ConstantNode node) {
		LOGGER.finer("visit(ConstantNode node) called on " + node);
		line.append(node.getValue());
	}

	@Override
	public void visit(DerivedTypeNode node) {
		LOGGER.finer("visit(DerivedTypeNode node) called on " + node);

	}

	@Override
	public void visit(DictTypeNode node) {
		LOGGER.finer("visit(DictTypeNode node) called on " + node);

	}

	@Override
	public void visit(ElseIfStatementNode node) {
		LOGGER.finer("visit(ElseIfStatementNode node) called on " + node);
		line.append("} else if ( ");
		walk(node.getCondition());
		line.append(" ) {");
		walk(node.getIfCondTrue());
		if (node.getIfCondFalse() != null) {
			walk(node.getIfCondFalse());
		}

	}

	@Override
	public void visit(ElseStatementNode node) {
		LOGGER.finer("visit(ElseStatementNode node) called on " + node);
		line.append("} else {");
		walk(node.getBlock());
		line.append("}");

	}

	@Override
	public void visit(ExceptionTypeNode node) {
		LOGGER.finer("visit(ExceptionTypeNode node) called on " + node);

	}

	@Override
	public void visit(ExpressionNode node) {
		LOGGER.finer("visit(ExpressionNode node) called on " + node);
		// ExpressionNode is to general, so move to a more specific case:
		node.accept(this);
	}

	@Override
	public void visit(FunctionNode node) {
		LOGGER.finer("visit(FunctionNodeNode node) called on " + node);
		line.append("public static " + node.getType().toSource() + " "
				+ node.getIdentifier());
		ParametersNode params = node.getParametersNode();
		line.append("(");
		line.append(params.getType().toSource());
		line.append(" " + params.getIdentifier());
		line.append(")");
		line.append(" {");
		walk(node.getInstructions());
		writeFunction();

	}

	@Override
	public void visit(GuardingStatementNode node) {
		LOGGER.finer("visit(GuardingStatementNode node) called on " + node);

	}

	@Override
	public void visit(IdNode node) {
		LOGGER.finer("visit(IdNode node) called on " + node);
		line.append(node.toSource());

	}

	@Override
	public void visit(IfElseStatementNode node) {
		LOGGER.finer("visit(IfElseStatementNode node) called on " + node);
		line.append("if ( ");
		walk(node.getCondition());
		line.append(" ) {");
		walk(node.getIfCondTrue());
		// check that buffer cleared
		if (node.getCheckNext() != null) {
			walk(node.getCheckNext());
		}
		if (node.getIfCondFalse() != null) {
			walk(node.getIfCondFalse());
		}
		line.append("}");
	}

	@Override
	public void visit(IterationStatementNode node) {
		LOGGER.finer("visit(IterationStatementNode node) called on " + node);

		switch (node.getIterationType()) {
		case FOR:
			line.append("for ( ");
			walk(node.getInitial());
			line.append("; ");
			walk(node.getCheck());
			line.append("; ");
			walk(node.getIncrement());
			line.append(" ) {");
			walk(node.getBlock());
			writeStatement();
			break;
		case FOREACH:
			line.append("for ( ");
			line.append(Types.getHadoopType((PrimitiveTypeNode) node.getPart()
					.getType()));
			line.append(" ");
			walk(node.getPart());
			line.append(" : ");
			walk(node.getWhole());
			line.append(" ) {");
			walk(node.getBlock());
			writeStatement();
			break;
		case WHILE:
			line.append("while ( ");
			walk(node.getCheck());
			line.append(" ) {");
			walk(node.getBlock());
			writeStatement();
			break;
		}
		writeBlockEnd();
	}

	@Override
	public void visit(JumpStatementNode node) {
		LOGGER.finer("visit(JumpStatementNode node) called on " + node);

		switch (node.getJumpType()) {
		case RETURN:
			line.append("return ");
			break;
		case BREAK:
			line.append("break");
			break;
		case CONTINUE:
			line.append("continue");
			break;
		}

		if (node.getExpressionNode() != null) {
			walk(node.getExpressionNode());
		}

		writeStatement();
	}

	@Override
	public void visit(MockNode node) {
		LOGGER.finer("visit(MockNode node) called on " + node);

	}

	@Override
	public void visit(MockExpressionNode node) {
		LOGGER.finer("visit(MockExpressionNode node) called on " + node);

	}

	@Override
	public void visit(Node node) {
		LOGGER.finer("visit(Node node) called on " + node);

	}

	@Override
	public void visit(ParametersNode node) {
		LOGGER.finer("visit(ParametersNode node) called on " + node);

	}

	@Override
	public void visit(PostfixExpressionNode node) {
		LOGGER.finer("visit(PostfixExpressionNode node) called on " + node);

		switch (node.getPostfixType()) {
		case METHOD_NO_PARAMS:
			IdNode objectOfMethod = node.getObjectOfMethod();
			IdNode methodNameNoParam = node.getMethodName();
			line.append(objectOfMethod.getIdentifier() + "."
					+ methodNameNoParam.getIdentifier() + "()");
			break;
		case METHOD_WITH_PARAMS:
			IdNode objectName = node.getObjectName();
			IdNode methodName = node.getMethodName();
			if (node.hasArguments()) {
				ExpressionNode argsList = node.getArgsList();
				line.append(objectName.getIdentifier() + "."
						+ methodName.getIdentifier() + "("
						+ argsList.toSource() + ")");
			}
			break;
		case FUNCTION_CALL:
			IdNode functionName = node.getFunctionName();
			// check if this is our special mapReduce() call:
			if (functionName.getIdentifier().equals("mapReduce")) {
				writeMapReduce();
				return;
			}
			if (node.hasArguments()) {
				ExpressionNode functionArgsList = node.getArgsList();
				if (functionArgsList.hasChildren()) {
					Iterator<Node> l = functionArgsList.getChildren()
							.iterator();
					String args = "";
					String typeDeclaration = "";
					while (l.hasNext()) {
						Node n = l.next();
						if (n instanceof ConstantNode) {
							ConstantNode cn = (ConstantNode) n;
							args = args + cn.getValue() + ",";
							typeDeclaration = "new IntWritable";
						} else if (n instanceof IdNode) {
							IdNode idNode = (IdNode) n;
							args = args + idNode.getIdentifier() + ",";
							typeDeclaration = "";
						}
					}
					if (args.charAt(args.length() - 1) == ',') {
						args = args.substring(0, args.length() - 1);
					}
					if (functionName.toSource().equalsIgnoreCase("emit")) {
						String[] output = args.split(",");
						// fix this permanently later
						if (output[1].contains("1")) {
							line.append("output.collect" + "(" + output[0]
									+ "," + typeDeclaration + "(" + output[1]
									+ ")" + ")");
						} else
							line.append("output.collect" + "(" + args + ")");
					} else
						line.append(functionName.toSource() + "(" + args + ")");
				}
			} else
				line.append(functionName.toSource() + "()");
			break;
		}
	}

	@Override
	public void visit(PrimaryExpressionNode node) {
		LOGGER.finer("visit(PrimaryExpressionNode node) called on " + node);
		line.append(node.toSource());

	}

	@Override
	public void visit(PrimitiveTypeNode node) {
		LOGGER.finer("visit(PrimitiveTypeNode node) called on " + node);

	}

	@Override
	public void visit(ProgramNode node) {
		LOGGER.finer("visit(ProgramNode node) called on " + node);

	}

	@Override
	public void visit(RelationalExpressionNode node) {
		LOGGER.finer("visit(RelationalNode node) called on " + node);

	}

	@Override
	public void visit(ReservedWordTypeNode node) {
		LOGGER.finer("visit(ReservedWordTypeNode node) called on " + node);

	}

	@Override
	public void visit(SectionNode node) {
		LOGGER.finer("visit(SectionNode node) called on " + node);

		SectionNode.SectionName sectionKind = node.getSectionName();

		switch (sectionKind) {
		case FUNCTIONS:
			line.append("public static class Functions {");
			break;
		case MAP:
			line
					.append("public static class Map extends MapReduceBase implements Mapper");
			walk(node.getSectionTypeNode());
			break;
		case REDUCE:
			line
					.append("public static class Reduce extends MapReduceBase implements Reducer");
			walk(node.getSectionTypeNode());

			break;
		case MAIN:
			line
					.append("public static void main(String[] args) throws Exception {");
			break;
		}
		walk(node.getBlock());
		writeBlockEnd();

		// need to write an additional block for inner methods in reduce and
		// map:

		switch (sectionKind) {
		case MAP:
		case REDUCE:
			writeBlockEnd();
		}

	}

	@Override
	public void visit(SectionTypeNode node) {
		LOGGER.finer("visit(SectionTypeNode node) called on " + node);
		// if we're at @Reduce, need to see output types for main
		if (node.getSectionParent().getSectionName() == SectionNode.SectionName.REDUCE) {
			outputKeyClass = Types.getHadoopType((PrimitiveTypeNode) node
					.getReturnKey());
			outputValueClass = Types.getHadoopType((PrimitiveTypeNode) node
					.getReturnValue());
		}

		line.append("<"
				+ Types.getHadoopType((PrimitiveTypeNode) node
						.getInputKeyIdNode().getType())
				+ ", "
				+ Types.getHadoopType((PrimitiveTypeNode) node
						.getInputValueIdNode().getType())
				+ ", "
				+ Types.getHadoopType((PrimitiveTypeNode) node.getReturnKey())
				+ ", "
				+ Types
						.getHadoopType((PrimitiveTypeNode) node
								.getReturnValue()) + "> {");
		if (node.getSectionParent().getSectionName() == SectionNode.SectionName.REDUCE) {
			line.append("public void reduce(");
			line.append(Types.getHadoopType((PrimitiveTypeNode) node
					.getInputKeyIdNode().getType()));
			line.append(" key, Iterator<");
			line.append(Types.getHadoopType((PrimitiveTypeNode) node
					.getInputValueIdNode().getType()));
			line.append("> values,  OutputCollector<");
			line.append(Types.getHadoopType((PrimitiveTypeNode) node
					.getReturnKey()));
			line.append(", ");
			line.append(Types.getHadoopType((PrimitiveTypeNode) node
					.getReturnValue()));
			line.append("> output, Reporter reporter) throws IOException {");
		} else {
			line.append("public void map(");
			line.append(Types.getHadoopType((PrimitiveTypeNode) node
					.getInputKeyIdNode().getType()));
			line.append(" key, ");
			line.append(Types.getHadoopType((PrimitiveTypeNode) node
					.getInputValueIdNode().getType()));
			line.append(" value,  OutputCollector<");
			line.append(Types.getHadoopType((PrimitiveTypeNode) node
					.getReturnKey()));
			line.append(", ");
			line.append(Types.getHadoopType((PrimitiveTypeNode) node
					.getReturnValue()));
			line.append("> output, Reporter reporter) throws IOException {");
		}
	}

	@Override
	public void visit(SelectionStatementNode node) {
		LOGGER.finer("visit(SelectionStatementNode node) called on " + node);

	}

	@Override
	public void visit(StatementListNode node) {
		LOGGER.finer("visit(StatementListNode node) called on " + node);
		for (Node child : node.getChildren()) {
			walk(child);
			writeStatement();
		}

	}

	@Override
	public void visit(StatementNode node) {
		LOGGER.finer("visit(StatementNode node) called on " + node);
		for (Node child : node.getChildren()) {
			walk(child);
		}
		writeStatement();
	}

	@Override
	public void visit(SwitchStatementNode node) {
		LOGGER.finer("visit(SwitchStatementNode node) called on " + node);
	}

	@Override
	public void visit(TypeNode node) {
		LOGGER.finer("visit(TypeNode node) called on " + node);

	}

	@Override
	public void visit(UnOpNode node) {
		LOGGER.finer("visit(UnOpNode node) called on " + node);

		switch (node.getOpType()) {
		case UMINUS:
			line.append("-");
			walk(node.getChildNode());
			break;
		case NOT:
			line.append("!");
			walk(node.getChildNode());
			break;
		case INCR:
			walk(node.getChildNode());
			line.append("++");
			break;
		case DECR:
			walk(node.getChildNode());
			line.append("--");
			break;
		case CAST:
			throw new UnsupportedOperationException(
					"Cast statements are NOT supported yet!");
		case NONE:
			// none means no unary operator applied.
			walk(node.getChildNode());
			break;
		}

	}

}