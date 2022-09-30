#Author: madushika@mydigitaloffice.ca
@myP1_Regression
Feature: Property Dashboard Weather Forecast & Verify Navigate to OTA Insight functionality

  Background: Verify Property Dashboard Page Navigation
    Given I am login to the myp1 site
    And System navigate to the dashboard
    Then I navigate to Property dashboard page
    Given Check data load according to selected date
    
    Scenario: Check Weather Forecast & Verify Navigate to OTA Insight
    Given Verify Weather Forecast loaded according to celsius
    And Verify Weather Forecast loaded according to fahrenheit
    When Check OTA Insight Table is loaded
    Then Check OTA Insight Chart is loaded
    And Click on OTA Insight Go To Details link
    When I navigate to OTA Insight Page
    
    
    