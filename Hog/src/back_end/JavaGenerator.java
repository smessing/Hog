package back_end;
import util.ast.node.*;
import java.util.Iterator;
import util.ast.*;

/**
 * Translates annotated AST into Java source.
 * @author !TODO!
 *
 */

public class JavaGenerator {

	AbstractSyntaxTree ast;
	public JavaGenerator(AbstractSyntaxTree ast){
		this.ast = ast;
	}
	
	public void run(){
		Iterator<Node> postOrder = this.ast.postOrderTraversal();
		
		while(postOrder.hasNext()){
			System.out.println(postOrder.next());
		}
		
	}
	
}
