#Author: Amar Lakansani


@advancesearch_validate
Feature: validation of advance search
  I want to validate user able to successfully review results of BMW cars performing advance search in the autotrader.com

  @tc001_advancesearch_launched
  Scenario: Validate if user able to launch advance search page
    Given User is in homepage
    When user clicked on Advance Search link
    Then Validate Advance Search page is displayed

  @tc002_advancesearch_enter_search_criteria
  Scenario: Validate if user able to enter data in advance search page
    Given User is in Advance Search page
    When user entered valid data in desired fields
    And clicked on Search button
    Then Validate Search results meeting the search criteria or not

