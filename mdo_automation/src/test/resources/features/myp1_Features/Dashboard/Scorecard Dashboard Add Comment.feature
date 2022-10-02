#Author: madushika@mydigitaloffice.ca
@myP1_Regression
Feature: Scorecard Dashboard Add Comment Functionality

  Background: Verify Scorecard Dashboard Main Functionality
    Given I am login to the myp1 site
    And System navigate to the dashboard
    When Navigate to Scorecard page
    Then Verify Scorecard data loaded
    
    Scenario: Verify Add Comment Popup functionality
    Given Click on Add Comment button
    And Verify Comment Popup form Loaded
    Then Fill Form Data
    When Click on submit button
    And Verify Data successfully Submited

    Scenario: Verify Added Comment availability in View Comments page
    Then Click on View Past Comments
    And Naviage to View Comments page
    When Check Submitted data is in View Comment table