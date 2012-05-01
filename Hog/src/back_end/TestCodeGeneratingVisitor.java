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
		AbstractSyntaxTree ast = new AbstractSyntaxTree(biOpNode);
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
