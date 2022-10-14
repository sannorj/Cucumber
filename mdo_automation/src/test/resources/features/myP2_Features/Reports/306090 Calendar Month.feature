#Author: sannorj@mydigitaloffice.ca
@myP2_Regression @myP2_Smoke 
Feature: 306090 Calendar Month Report - Header, Parameters and Search Validation 

   Background: Navigate to 306090 Calendar Month Report
   Given I am login to the myp2 site
   And System navigate to the home page
   And Select the organization as "Beck Legacy Group"
   And Expand the Calendar Month Report option under Reports section in Side Menu
   And Navigate to Calendar Month Report page
   
   Scenario: Verify whether the default Rolling Month headers are loaded on the page
   When User selects the Group and date
   Then Calendar Month Headers should be loaded on the page.
    
   Scenario: Verify whether user can search the records.
   When User inputs a parameter in the Calender Month search field 
   Then Table should load the results on Calender Month Page
   
   Scenario: Verify whether parameters selected in the Calendar Month are the same in the Rolling Month Report
   When User navigates to the Rolling Month Report
   Then The Calendar Month Report parameters should match the Rolling Month Report.
    