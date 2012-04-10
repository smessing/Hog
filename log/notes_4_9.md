# What we discussed:
* Overall architecture
* Agreed we should meet twice a week until we're done.
* Looked over Final Report outline for a sense of what's to come.
* Discussed major responsibilities for individual classes. What's decided so far:

	* Ben: CUP File 
	* Sam: AST(s) / Node implementations
	* Kurry: SymbolTable(s) / Identifier(s) / IdentifierAttributes(es)
	* Paul: `none yet`
	* Jason: Automated Tests
* **Sam suggests Jason and Paul get first dibs of what's left**
* **Next meeting: Friday**
* **Meeting with Aho sometime next week. Do enough work to have substantive questions/progress for him.** 

# For Next Time (Friday, April 13th).

## All

## Ben
* Setup github permissions (may need to be Sam...) so that Ben is administrator of master branch.
* Work on CUP file, goal: working parse trees of going from MultiplicativeExpression (root) to all possible leaves (i.e. all strings derviable from there).


## Paul
* Get Ubuntu/Eclipse installed ASAP.
* Add DerivedType productions to grammar (CUP file).
* Make edits to LRM/Tutorial based on Aho and Melanie's comments.
* Choose a class in our codebase to be in charge of.

## Kurry
* Implement SymbolTable and related classes (Identifier, IdentifierAttributes and their implementations), goal: rough draft by meeting.

## Jason
* Finish automated Lexer tests.
* Flesh out AST tree tests (write some failing ones for things not yet implemented).

## Sam
* Schedule Aho meeting for next week.
* Implement AST classes and traversal iterators.
* Implement MockNode class for testing.
* Work on Node types.
* Figure out how to handle `return` from C grammar.
* Dump White paper, Tutorial and LRM into Final Report documentation.