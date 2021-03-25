@selenide
Feature: Wikipedia

  Scenario: Verify wikipedia 1
    Given open browser on url
    When user clicks on About Wikipedia
    Then verify title About Wikipedia

  Scenario: Verify wikipedia 2
    Given open browser on url
    When user clicks on Community Portal
    Then verify title Community Portal

  Scenario: Verify wikipedia 3
    Given open browser on url
    When user clicks on About Help Page
    Then verify title About Help Page

  Scenario: Verify wikipedia 4
    Given open browser on url
    When user clicks on About Talk Main
    Then verify title About Talk Main

  Scenario: Verify wikipedia 5
    Given open browser on url
    When user enters search value - "apple" and clicks on search button
    Then verify Contents of Search Result
