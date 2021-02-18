Feature:Google search verification

#  TODO Rewrite step definitions from User perspective

  @skeleton
  Scenario Outline: Verify wikipedia title after searching
    Given open "<url>"
    When enter "<value>" and search
    Then verify if first link contains text "<value>"

    Examples:
      | url                     | value |
      | https://www.google.com/ | Apple |