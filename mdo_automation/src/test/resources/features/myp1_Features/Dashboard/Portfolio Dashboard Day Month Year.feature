#Author: madushika@mydigitaloffice.ca
@myP1_Regression @portfolioDMY
Feature: Portfolio Dashboard Day Month Year Verify functionality

  Background: Verify Portfolio Dashboard
    Given I am login to the myp1 site
    And System navigate to the dashboard
    When Check data loaded
    
    Scenario: Verify Year page navigate functionality
    Given Click on Portfolio year button
    And Verify navigate to year page
    
    Scenario: Verify Month page navigate functionality
    Given Click on Portfolio month button
    And Verify navigate to Month page
    