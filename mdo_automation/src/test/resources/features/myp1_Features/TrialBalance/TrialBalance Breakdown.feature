#Author: madushika@mydigitaloffice.ca
@myP1_Regression @TBBreakdown
Feature: TrialBalance Breakdown Functionality

  	Background: Verify TrialBalance Breakdown main Functionality 
    Given I am login to the myp1 site
    And System navigate to the dashboard
    When Navigate to TrialBalance Breakdown page
    Then Select a date and hotel as "24 North" and Period as "Current"
    And Update all data
    
    Scenario: Verify TB Description and Type columns are same type
    When Verify each Description "Description" and Type "Type" columns types are equal
    
    Scenario: Verify TB Display Description and Type columns are same type
    Then Verify each Display Description "Display Description" and Type "Type" columns types are equal
    
    Scenario: Verify Has Amount filter option and Credit & Debit Total values comparison
    And Verify Amount "Amount" values greater than zero when filter Has Amount
    Given Verify Credit & Debit Total values are equal when filter Has Amount
    
    #Scenario: Verify Has Stat filter option
    #Then Verify Type column values are stats when filter Has Stat
    
    #Scenario: Verify Has GLCode filter option
    #And Verify GL Code values are greater than zero when filter Has GLCode
    
    #Scenario: Verify TrialBalance model main functionality
    #Given Verify Edit TrialBalance model view options
    #Then Verify close model option
    
    #Scenario: Verify Add and Delete row section functionality
    #And Verify Add Row section
    #When Verify Delete Row section
    
    
    

    