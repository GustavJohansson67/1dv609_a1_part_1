# Practice Writing and Running Tests

For this assignment you may select programming language, test framework, and code coverage tool. 
We provide Java and .js code. 


## Goals
- Practice your ability to write simple unit tests in a framework.
  - You should know how to writing unit tests
  - You should know how to run tests and evaluate results
  
- Write minimal simple test-suites that accuratly pinpoints bugs
- Practice running code coverage tool, and assess code coverage.
    - Find code not run during testing
- Name tests to document requirements in the SUT
  - Follow the pattern [Function]Should[Expected behaviour]For[Stimuli] 
    - Java junit: constructorShouldThrowExceptionForShortPasswords()
    - Jest:       "constructor Should Thow Exception For Short Passwords"

## Course material to support
* Developer Testing - Chapter 7 - 10
* Testing framework/tool online manuals for your framework/tools
* Course materials week 1-2

## Task 1: Write an optimized test suite
Write a test suite for the Password class provided. 

 * There are correct and buggy versions of the Password class. 
   * The correct version is defined as correct, and should not be changed.
   * The buggy versions should not be changed.
   * None of the tests you write may fail for the correct version. 
   * For each buggy version your test suite should have at least one test that failes. 
   * Each test should fail for at least one buggy version which no other test fails, no redundant tests!
   * Add a new buggy version that pass all your tests
  
 * Artifacts to show during examination
   * Test suite as one file 
   * One assert/expect per test ( unless strong reasons )
   * You should be able to run all your tests against any of the correct, or buggy versions. 
   * You should be able to run code coverage 
   * As close to 100% test coverage for all versions of the Password as possible, (note may not always be possible)
   * Show summary as a table as below, showing coverage and pass/fail for all combinations of tests & correct and buggy versions.
   * Orally be able to answer questions about your code. All code must be fully understood.
   * Orally the reflection questions.
   * Show the buggy version that pass all your tests

### Table for checking test suite bug coverage
Create a table like this one for all the bugs and Tests, showing which test fails or succeeds for each test and the coverage. Use the table to remove tests that are redundant.

| Version | Correct | BugDoesNotHash | BugDoesNotTrim |  ... | MyCustomBug |
| --- | ---| --- | --- | --- | --- |
| Test name 1 | ✅ | ❌ | ✅ | ✅ | ✅ |
| Test name 2 | ✅ | ✅ | ❌ | ✅ | ✅ |
| Test name 3 | ✅ | ✅ | ❌ | ❌ | ✅ |
| Coverage | 100% | 100% | 100% | 100% | 100% |


### Reflection Questions

During Examination you may be asked these or related questions. You should be able to answer these questions in depth. 

- How many tests are needed to find all bugs in the example?
- What are the missing tests you think would be good to add?
- What is **good test data** for this example and why?
- Can we and should we test private methods?
- Can all code be covered by code coverage? Why not?
- What kind of "asserts"/"expects" can be done in your testing framework? Make a summary.
- What kind(s) of Code Coverage is shown in your code coverage tool? What does it mean?

