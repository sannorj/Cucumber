#Author: madushika@mydigitaloffice.ca
@myP1_Regression
Feature: Scorecard Dashboard Main Functionality

  Scenario: Verify Scorecard Dashboard
    Given I am login to the myp1 site
    And System navigate to the dashboard
    When Navigate to Scorecard page
    Then Verify Scorecard data loaded
    And Verify All enebled cards loaded  
    When Verify cards minimized