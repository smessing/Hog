package back_end;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import util.ast.node.*;
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
