/**
 * 
 */
package util.ast.node;

import back_end.Visitor;
import util.type.Types;

/**
 * @author ben
 *
 */
public class ExceptionType extends TypeNode {

	protected Types.Exception localType;
	
	public ExceptionType(Types.Exception localType) {
		this.localType = localType;
	}
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
	}

	@Override
	public int visitorTest(Visitor v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Exception Type: " + localType.toString();
	}
}
