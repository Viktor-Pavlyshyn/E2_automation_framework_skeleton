Feature: TODO Refactor Reflection tests

# TODO Refactor Reflection tests
#  Create real test. Get rid off println
#  1. Verify class name
#  2. Verify getter returns expected value of field which was set by reflection
#  3. Verify method returns expected value invoked by reflection
#  4. Verify fields values after init object by reflection
#  5. Verify default and specific annotation value. Set annotation for 2 methods and using example table parametrize test
#
#  Additional task:
#    1. Create annotation @Invoke(status = boolean) by default true.
#    2. Create new class and add several methods which will increment object field by specific int value plusOne(), plusTwo(), plusThree() etc.
#    3. Mark all this methods with @Invoke annotation by default
#    4. Create method which can update annotation value for methods by name
#    5. Create method which can invoke all methods in object verifying value of @Invoke annotation and return calculated value
#    6. Create parametrized test which will set @ignore value and verify calculated value
#
#    Practise naming Scenarios and Given/When/Then


# TODO Refactor Reflection tests
#  Create real test. Get rid off println
#  1. Verify class name
#  2. Verify getter returns expected value of field which was set by reflection
#  3. Verify method returns expected value invoked by reflection
#  4. Verify fields values after init object by reflection
#  5. Verify default and specific annotation value. Set annotation for 2 methods and using example table parametrize test
#
#  Additional task:
#    1. Create annotation @Invoke(status = boolean) by default true.
#    2. Create new class and add several methods which will increment object field by specific int value plusOne(), plusTwo(), plusThree() etc.
#    3. Mark all this methods with @Invoke annotation by default
#    4. Create method which can update annotation value for methods by name
#    5. Create method which can invoke all methods in object verifying value of @Invoke annotation and return calculated value
#    6. Create parametrized test which will set @ignore value and verify calculated value
#
#    Practise naming Scenarios and Given/When/Then


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