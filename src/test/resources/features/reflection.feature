@reflection
Feature: Refactor Reflection tests

  Scenario Outline: Verify class name
    Given Class name - <className>
    Then Verify if current Object.getName equals <className>
    Examples:
      | className                  |
      | "reflection.data.SumClass" |

  Scenario Outline: Verify getter returns expected value of field which was set by reflection
    Given Class name - <className>
    And Set value - <value> in private field - <fieldName>
    Then Verify if method - <methodName> return value - <value>
    Examples:
      | className                  | fieldName | value | methodName |
      | "reflection.data.SumClass" | "sum"     | 6     | "getSum"   |

  Scenario Outline: Verify fields values after init object by reflection
    Given Class name - <className>
    Then Verify if field - <fieldName> return value - <value>
    Examples:
      | className                  | fieldName | value |
      | "reflection.data.SumClass" | "sum"     | 0     |

  Scenario Outline: Additional task
    Given Class name - <className>
    Then Verify method = <nameMethod> with annotation field name - <fieldAnnName> and value false  and expected sum = <sum>
    Examples:
      | className                  | nameMethod  | sum | fieldAnnName |
      | "reflection.data.SumClass" | "plusThree" | 3   | "state"      |
      | "reflection.data.SumClass" | "plusOne"   | 5   | "state"      |