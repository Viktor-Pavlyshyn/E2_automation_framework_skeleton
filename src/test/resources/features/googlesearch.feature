Feature:Google search verification

  @skeleton
  Scenario Outline: Verify wikipedia title after searching
    Given open "<url>"
    When enter "<value>" and search
    Then verify link on position <position> contains text "<value>"
    Examples:
      | url                     | value | position |
      | https://www.google.com/ | Apple | 1        |
