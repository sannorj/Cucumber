#Author: madushika@mydigitaloffice.ca
@myP1_Regression
Feature: Scorecard Dashboard Filter Functionality

  Background: Verify Scorecard Dashboard Main Functionality
    Given I am login to the myp1 site
    And System navigate to the dashboard
    When Navigate to Scorecard page
    Then Verify Scorecard data loaded
    
    Scenario: Verify data loaded according to Filter options
    Given Verify cards data loaded for date
    And Verify Week Month buttons works