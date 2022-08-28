@myP1_Regression
Feature: Property Dashboard Links Verify functionality

  Background: Verify Property Dashboard Page Navigation
    Given I am login to the myp1 site
    And System navigate to the dashboard
    Then I navigate to Property dashboard page
    Given Check data load according to selected date
    
    Scenario: Verify Stats by Date Range Link functionality
    Given verify Stats by Date Range page navigation
    
    Scenario: Verify STR Report Link functionality
    Given verify STR Report page navigation
    
    Scenario: Verify Pick-up Report Link functionality
    Given verify Pick-up Report page navigation
    
    Scenario: Verify Labor Dashboard Link functionality
    Given verify Labor page navigation
    
    #Scenario: Verify Download Btn functionality
    #Given verify download button functionality
    
    