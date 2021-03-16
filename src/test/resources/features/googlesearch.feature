Feature:Google search verification

  @skeleton
  Scenario Outline: Verify wikipedia title after searching
    Given open "<url>"
    When enter "<value>" and search
    Then verify text Title Wikipedia contains - "<value>"
    Examples:
      | url                     | value |
      | https://www.google.com/ | Apple |