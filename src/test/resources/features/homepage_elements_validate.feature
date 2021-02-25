#Author: Amar Lakansani
#Keywords Summary :
#Feature: List of scenarios.

@homepage_validate
Feature: validation of homepage elements
  I want to validate elements in the autotrader.com homepage

  @homepage
  Scenario: Validate if desired elements present in homepage
    Given User entered valid url autotrader.com
    When user landed on homepage
    Then validate desired elements in homepage

