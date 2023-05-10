#Author: madushika@mydigitaloffice.ca
@myP1_Regression @PropertyAddComment
Feature: Property Dashboard Add Comment functionality

  Background: Verify Property Dashboard Page Navigation
    Given I am login to the myp1 site
    And System navigate to the dashboard
    Then I navigate to Property dashboard page
    Given Check data load according to selected date
        
    Scenario: Verify Add Comment Popup functionality
    Given Click on Add Comment button
    And Verify Comment Popup form Loaded
    Then Fill all Form Data
    When Click on submit button
    And Verify Data successfully Submited and comment added

    Scenario: Verify Added Comment availability in View Comments page
    Then Click on View Past Comments link
    And Naviage to View Comments page
    When Check Submitted data is in View Comment table
    
    
    
    