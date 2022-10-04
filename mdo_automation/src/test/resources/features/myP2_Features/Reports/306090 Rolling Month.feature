#Author: sannorj@mydigitaloffice.ca
@myP2_Regression @myP2_Smoke @sannorj222 

Feature: 306090 Rolling Month Report - Header, Parameters and Search Validation 

   Background: Navigate to 306090 Rolling Month Report
   Given I am login to the myp2 site
   And System navigate to the home page
   And Select the organization as "Beck Legacy Group"
   And Expand the Rolling Month Report option under Reports section in Side Menu
   And Navigate to Rolling Month Report page
    
   Scenario: Verify whether the default Rolling Month headers are loaded on the page
   When User selects the Group and date
   Then Default Rolling Month Headers should be loaded on the page.
   
   Scenario: Verify whether user can search the records.
   When User inputs a parameter in the Rolling Month search field 
   Then Table should load the results on Rolling Month Page
   
   Scenario: Verify whether parameters selected in the Rolling Month are the same in the Calendar Month Report
   When User navigates to the Calendar Month Report
   Then The Rolling Month Report parameters should match the Calendar Month Report.
    
   
   