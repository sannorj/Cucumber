#Author: madushika@mydigitaloffice.ca
@myP1_Regression @PortfolioSearch
Feature: Portfolio Dashboard Search functionality

  Background: Verify Portfolio Dashboard
    Given I am login to the myp1 site
    And System navigate to the dashboard
    When Check data loaded
    Then Verify user name filter option
    And Verify filter Period option
    
    Scenario: Verify Portfolio search button functionality
    Given add search value to search box
    When Verify table data filtering to search keyword
    