@selenide
Feature: Wikipedia

  Scenario: Verify wikipedia 1
    Given open page Wikipedia
    And user navigates to the About Wikipedia page
    Then verify About Wikipedia page has title "About"

  Scenario: Verify wikipedia 2
    Given open page Wikipedia
    And user navigates to the Community Portal page
    Then verify Community Portal page has title "Community"

  Scenario: Verify wikipedia 3
    Given open page Wikipedia
    And user navigates to the About Help page
    Then verify About Help Page Portal page has title "Help"

  Scenario: Verify wikipedia 4
    Given open page Wikipedia
    And user navigates to the About Talk Main page
    Then verify About Talk Main page has title "Talk"

  Scenario: Verify wikipedia 5
    Given open page Wikipedia
    When user uses search with value - "apple"
    Then verify size 'Contents' item in Search Result page when user searches 'apple'
