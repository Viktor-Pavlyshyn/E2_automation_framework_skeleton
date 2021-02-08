Feature:Google search verification

  Scenario Outline: Verify wikipedia title after searching
    Given open "<url>"
    Then enter "<value>" and search
    Then verify if wikipedia title contains text "<value>"

    Examples:
      | url                     | value |
      | https://www.google.com/ | apple |