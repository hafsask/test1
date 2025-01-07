Feature: test
  This is a simple feature to test the search functionality.

Scenario Outline: Basic Search
  Given I open google search page
  When I look up the word <word>
  Then search results display the word <word>
  Examples:
    | word       |
    | "selenium" |
    | "cucumber" |

  Scenario: Basic Search for test
    Given I open google search page
    When I look up the word "test"
    Then search results display the word "fail"
