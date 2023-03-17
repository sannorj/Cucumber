#Author: madushika@mydigitaloffice.ca
@myP1_Regression @Portfolio
Feature: Portfolio Dashboard functionality

  Scenario: Verify Portfolio Dashboard
    Given I am login to the myp1 site
    And System navigate to the dashboard
    When Check data loaded
    Then Verify user name filter option
    And Verify filter Period option  
    When Verify main table rows expanded
    Then Verify table data sorted 
    And Verify Select option and go to summary Page
    