package back_end;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import util.ast.node.*;
import util.ast.node.PostfixExpressionNode.PostfixType;
import util.type.Types;
import util.ast.AbstractSyntaxTree;

public class TestCodeGeneratingVisitor {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		TypeNode typeNode = new PrimitiveTypeNode(Types.Primitive.INT);
		IdNode idNode = new IdNode(typeNode, "x");
		idNode.setDeclaration();
		ConstantNode constantNode = new ConstantNode(Types.Primitive.INT, "2");
		BiOpNode biOpNode = new BiOpNode(BiOpNode.OpType.ASSIGN, idNode,
				constantNode);
		TypeNode secondTypeNode = new PrimitiveTypeNode(Types.Primitive.BOOL);
		IdNode secondIdNode = new IdNode(secondTypeNode, "y");
		secondIdNode.setDeclaration();
		ConstantNode secondConstantNode = new ConstantNode(
				Types.Primitive.BOOL, "true");
		BiOpNode secondBiOpNode = new BiOpNode(BiOpNode.OpType.ASSIGN,
				secondIdNode, secondConstantNode);
		StatementListNode statementListNode = new StatementListNode(
				new StatementListNode(secondBiOpNode), biOpNode);
		AbstractSyntaxTree ast = new AbstractSyntaxTree(statementListNode);
		CodeGeneratingVisitor v = new CodeGeneratingVisitor(ast);
		v.walk();
		
		PostfixExpressionNode pfe_node_method_no_params = new PostfixExpressionNode(PostfixType.METHOD_NO_PARAMS,new IdNode("list"), new IdNode("getSize"));
		v.visit(pfe_node_method_no_params);
		PostfixExpressionNode pfe_node_method_with_params = new PostfixExpressionNode(PostfixType.METHOD_WITH_PARAMS, new IdNode("line"), new IdNode("tokenize"),new ConstantNode(Types.Primitive.TEXT,"TEXT"));
		v.visit(pfe_node_method_with_params);
		PostfixExpressionNode pfe_node_function_call = new PostfixExpressionNode(PostfixType.FUNCTION_CALL,new IdNode("print"),new ArgumentsNode(new IdNode("i"),new ConstantNode(Types.Primitive.INT, "ONE")));
		v.visit(pfe_node_function_call);
		
		FileWriter fstream = null;

		try {
			fstream = new FileWriter("Hog.java");
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(v.getCode());
			out.close();
			System.out.println(v.getCode());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
