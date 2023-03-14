#Author: madushika@mydigitaloffice.ca
@myP1_Regression @PAddEvent
Feature: Property Dashboard Add Event functionality

  Background: Verify Property Dashboard Page Navigation
    Given I am login to the myp1 site
    And System navigate to the dashboard
    Then I navigate to Property dashboard page
    Given Check data load according to selected date
    
    Scenario: Verify Add Event Popup functionality
    Given Click on Add Event button
    And Verify Add Event Popup form Loaded
    Then Fill all Event Form Data without Repeat option
    When Click on submit button of Event
    And Verify not repeat Data successfully Submited
    Then Fill all Event Form Data with Repeat option
    When Click on submit button of Event
    And Verify repeated Data successfully Submited
		
    Scenario: Verify Added Event Popup in Page Load and check added events
    Given Verify Added Events are popup
    Then Check the Events by clicking calendar
    And Delete Events
    When Check Events deleted successfully
    
    
    
    