#Author: madushika@mydigitaloffice.ca
@myP1_Regression 
Feature: Labor Rollup Dashboard Functionality

  Background: Verify Labor Rollup Dashboard
    Given I am login to the myp1 site
    And System navigate to the dashboard
    When Navigate to Labor Rollup page
    Then Select a date and hotel as "Gateway" and period as "MTD" to filter table
    
    Scenario: Verify Labor Rollup Actual button functionality
    Given Verify Actual buttons
    #When I turn on all the columns
    And Verify columns Total values of Actual
    Then Verify actual data sorted
    And Verify filtered Actual Search data
   	
   	Scenario: Verify Labor Rollup POR button functionality
    Given Verify POR buttons
    And Verify columns Total values of POR
    Then Verify POR data sorted
    And Verify filtered POR Search data
   	
   	Scenario: Verify Labor Rollup Edit functionality
   	Given Disable selected columns
   	Then Select a date and hotel as "Gateway" and period as "MTD" to filter table
    And Verify columns disabled in Actual and POR
    When Enable columns
   	Then Select a date and hotel as "Gateway" and period as "MTD" to filter table
    Then Verify columns enabled in Actual and POR
    