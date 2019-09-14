Feature: Google search
  As a user,
  I would like to find TruNarrative using Google,
  so that I can find the website without remembering the URL.

  Background: Nav to TruNarrative via Google
    Given I am on the Google search page
    When I search for "TruNarrative"
    And I click result number 1

  Scenario: Nav to leadership team
    Given I am on the TruNarrative homepage
    When I click "TruNarrative Team" from the "More" menu
    Then The leadership team is displayed