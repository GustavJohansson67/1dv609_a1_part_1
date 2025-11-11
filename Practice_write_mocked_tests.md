# Practice Writing and Running Tests with mocks

## Goals
* Testing classes with dependencies
* Run tests with mocks
* Test the Helper and Password classes independently of each other
    * Tests for Password should only fail if the bug is in Password class
    * Tests for Helper should only fail if the bug is in Helper class

## Task 2: Write an optimized test suite for two classes 

Most of the assignment works as the previous practice "run test" but now we have two classes with a dependency. We want to test these classes independently.

SwedishSecurityNumber depends on the class SSNHelper who holds all the validation methods. A test for SwedishSecurityNumber should only test functionality in the SwedishSecurityNumber class and not rely on SSNHelper. To accomplish this we can make use of "mocks". A mock is a configurable class instance that acts as a object of SSNHelper but we can control its output in the test.

* Write a test suite for SwedishSecurityNumber class and another for the SSNHelper class
A bug in the SwedishSecurityNumber must not fail due to a bug in SSNHelper. 
* None of the tests in SwedishSecurityNumber should use objects of the SSNHelper class.
* Only one expect/assert per test
* Show tests and bug fail matrix as in previous task

* Artifacts to show during examination
  * Table below
  




### Table for checking test suite bug coverage
| Version | Correct | Buggy Password 1 | Buggy Helper 2 | ... | |
| --- | ---| --- | --- | --- | --- |
| SwedishSecurityNumber Test name 1 | ✅ | ❌ | ✅ | ✅ | |
| SSNHelper Test name 3 | ✅ | ✅ | ❌ | ✅ | |
| Coverage | 100% | 100% | 100% | 100% | |



### Reflection Questions
* What is the purpose of mocks?


```
//Version 2 Buggy Password, does not trim

//Version 3 Buggy Password, does not check password with isToShort
//Version 3 Buggy Helper, allows too short passwords

//Version 4 Buggy Password, throws the wrong exception message for short passwords

//Version 5 Buggy Password, does not throw and exception for short passwords

//Version 6 Buggy, does not throw an exception if the password does not contain a number

//Version 7 Buggy, isPasswordSame returns true for all passwords

```