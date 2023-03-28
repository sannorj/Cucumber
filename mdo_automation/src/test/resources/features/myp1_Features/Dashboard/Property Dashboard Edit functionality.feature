#Author: madushika@mydigitaloffice.ca
@myP1_Regression @PEdit
Feature: Property Dashboard Edit functionality

  Background: Verify Property Dashboard Page Navigation
    Given I am login to the myp1 site
    And System navigate to the dashboard
    Then I navigate to Property dashboard page
    Given Check data load according to selected date
    
    Scenario: Verify Data Loaded successfully and check Add Chart Functionality  
    #Given Click on Edit button
    #And Click on Add Chart button
    #When Verify Add Chart popup displayed
    #Then remove a chart and click on submit button
    #And Check Chart is removed
    #
    #Re-Add removed Chart
    #Given Click on Edit button to add chart
    #When Click on Add Chart button
    #Then Verify Add Chart popup displayed
    #When Re-select removed chart and click on submit button
    #And Verify Chart is loaded
    #
    #edit table
    Given Click on Edit button 
    When Remove Selected Column
    And Enable remove confirm msg
    Then Verify column successfully removed
    Given Click on Edit button
    And Add new Column
    Given Click on Edit button
    Then Select Selected Column for new column
    #Given Click on Edit button
    And Verify column successfully added
    #
    #Close individual chart
    Given Click on Edit button
    And Remove a selected chart
    And Check Chart is removed
    Given Click on Edit button
    When Click on Add Chart button
    Then Verify Add Chart popup displayed
    When Re-select removed chart and click on submit button
    And Verify Chart is loaded
    
    
        