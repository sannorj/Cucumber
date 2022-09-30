#Author: madushika@mydigitaloffice.ca
@myP1_Regression
Feature: Property Dashboard Day Month Year page Verify functionality

  Background: Verify Property Dashboard Page Navigation
    Given I am login to the myp1 site
    And System navigate to the dashboard
    Then I navigate to Property dashboard page
    
    Scenario: Verify Navigate to Month and Date Page
    Given Click on Month
    And search selected month and year
    When Check Add Event popup is visible
    Then Click on Selected date
    And Verify I navigate to Selected Date
    
    Scenario: Verify Navigate to Year Page
    Given Click on Year
    And search selected year
    When Click on Selected Month
    Then Verify I navigate to Selected Month