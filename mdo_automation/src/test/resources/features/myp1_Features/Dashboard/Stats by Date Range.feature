#Author: madushika@mydigitaloffice.ca
@myP1_Regression @StatsbyDR
Feature: Stats by Date Range functionality

 		Background: Verify Stats by Date Range Page Navigation
 		Given I am login to the myp1 site
    And System navigate to the dashboard
    Then I navigate to Property dashboard page
    Given Check data load according to selected date
    When Verify First table is loaded
    And Verify all the Chartes Loaded
    
  	Scenario: Verify date range filter and check data availability
    Then Navigate to Stats by Date Range Page
    Given Select different dates and verify data availability in table
    And Select equal dates and verify data availability in table
    
    
    #Scenario: Verify average and Total of table data
    #Then Navigate to Stats by Date Range Page
    #Given Select different dates and verify data availability in table
    #And Verify Occ total values show the average of all rows
    #And Verify ADR total values show the average of all rows
    #And Verify RevPAR total values show the average of all rows
    #When Verify Room Revenue values show total values of all the rows
    #When Verify Room Sold values show total values of all the rows
    
    #Scenario: Verify Property dashboard page table data compare with stats by date range table data
    