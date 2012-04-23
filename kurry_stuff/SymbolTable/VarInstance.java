

public interface VarInstance<T> {

    /**
     * The name of the variable.
     */
    Identifier name();
    //VarInstance<T> name(String name);

    /**
     * The type of the variable.
     */
    String type();
   // VarInstance<T> type(Type type);

    /**
     * The variable's constant value, or null.
     */

    //VarInstance<T> notConstant();

    /**
     * Whether the variable has a constant value.
     */
    boolean isConstant();

   
}
