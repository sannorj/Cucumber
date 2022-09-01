@myP1_Regression
Feature: Portfolio Dashboard Add Comment functionality

  Background: Verify Portfolio Dashboard
    Given I am login to the myp1 site
    And System navigate to the dashboard
    When Check data loaded
    Then Verify user name filter option
    And Verify filter Period option
    
    Scenario: Verify Portfolio Add Comment Popup functionality
    Given Click on Portfolio Add Comment button
    And Verify Portfolio Comment Popup form Loaded
    When Select a Hotel
    Then Fill all Form Data
    When Click on submit button
    And Verify Data successfully Submited and comment added
    
    #Scenario: Verify Added Comment availability in View Comments page
    #Then Click on Portfolio View Past Comments link
    #And Naviage to View Comments page
    #When Check Submitted data is in View Comment table