# To dos

* Parser Tests
* Symbol Table Tests
* Start Final Report 

# LRM Changes
* pg. 19, 8.4.3: no longer supporting the construction `iList = [0, 1, 2, 3...]`, instead, we will have consecutive calls to `iList.get(0)`, etc.
* Currently, array indexing a la `iList[0]` is not supported.
* Not supporting anonymous objects a la `((Foo) foo).foo()`
