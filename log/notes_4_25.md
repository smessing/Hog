# What was discussed
* `switch` statement currently not implemented, will implement if time
* Compile time exceptions are now called `error`s, and there is no support for catching compile time errors.
* Runtime exceptions are called `exceptions`, we will offer limited support for catching runtime exceptions.
* LOG FORMATS (from most-detailed to least-detailed):
	1. Finest - for use by individual devs
	2. Finer - for use by individual devs
	3. Fine - for use by individual devs
	4. Config - information for whole team to see
	5. Info - user sees
	6. Warning - user sees (will we use this level?)
	7. Sever - reserved for compile-time errors
* No function overloading allowed, **_NEED TO MENTION IN LRM_**

### Type-Checking Visitor:
* Check all operands have right type
* populate & propagate types
* checking vars declared before used

### Error-Checking Visitor:
* Check for dead code (code after `return` statement)
* Jump statements (`break`, `continue`) w/i iteration loops
* non-`void` functions have adequate `return` statements
* `case`, `default` w/i `switch` statements
* functions used with correct args

### Java-Generator Visitor:
* Spits out the source

### Type Equivalence

		boolean CheckEquiv(TypeNode one, TypeNode two) {
			if (one instanceof PrimitiveTypeNode && two instanceof PrimitiveTypeNode) {
				return CheckPrimitiveEquiv(one, two);
			}		
			if (one instanceof DerivedTypeNode && two instanceof DerivedTypeNode) {
				if (one.local == two.local) {
					return CheckEquive(one.inner, two.inner);
				}
			}
			return false;
		}

# Obligations
## Sam, Ben
* JavaDoc for Node Classes

## Sam
* Realphabetize `Parser.cup`
* arbitrarily assign JavaDoc to write to people [`done`]
* line numbers in cup
* Parser tests

## Ben, Jason
* Finish SymbolTable, write tests for SymbolTable, add to Cup productions

## Kurry
* Node Tests
* Java Source

## Kurry, Paul
* Type translation

## Paul
* `WordCount.hog` -> Hadoop equivalent