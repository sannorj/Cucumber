@myP1_Regression
Feature: Portfolio Dashboard Visual Portfolio functionality

  Background: Verify Portfolio Dashboard
    Given I am login to the myp1 site
    And System navigate to the dashboard
    When Check data loaded
    
    Scenario: Verify Visual Portfolio button functionality
    Given Click on Visual Portfolio button
    When Verify navigate to Visual Portfolio page