Feature: TODO Refactor Reflection tests

  @reflection
  Scenario Outline: Create real test. Get rid off println
    Given Verify class name
    Then Verify getter returns expected value of field which was set by reflection
    And Verify method returns expected value invoked by reflection
    Then Verify fields values after init object by reflection
    Then Verify method = <nameMethod> with annotation  false value annotation value and expected sum = <sum>
    Examples:
      | nameMethod | sum |
      | "plusThree"  | 3   |
      | "plusOne"    | 5   |