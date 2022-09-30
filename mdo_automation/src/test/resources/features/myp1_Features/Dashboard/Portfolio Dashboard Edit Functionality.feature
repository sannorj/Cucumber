#Author: madushika@mydigitaloffice.ca
@myP1_Regression
Feature: Portfolio Dashboard Edit Functionality

  Background: Verify Portfolio Dashboard
    Given I am login to the myp1 site
    And System navigate to the dashboard
    When Check data loaded
    Then Verify user name filter option
    And Verify filter Period option
    
    Scenario: Verify Edit Functions
    Given Click on Portfolio Edit button
    And Add column
    Then Verify Column added
    Given Click Edit button
    And Delete an selected column 
    When Click remove confirm
    Given Click Edit button
    Then Verify column is removed