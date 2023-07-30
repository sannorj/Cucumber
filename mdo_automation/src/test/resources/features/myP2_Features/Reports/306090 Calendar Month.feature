#Author: sannorj@mydigitaloffice.ca
@myP2_Regression

Feature: 306090 Calendar Month Report - Header, Parameters and Search Validation 

   Background: Navigate to 306090 Calendar Month Report
   Given I am login to the myp2 site
   And System navigate to the home page
   And Select the organization as "Beck Legacy Group"
   
   Scenario: Verify whether the default Rolling Month headers are loaded on the page
   And Expand the Calendar Month Report option under Reports section in Side Menu
   And Navigate to Calendar Month Report page
   When User selects the Group and date
   Then Calendar Month Headers should be loaded on the page.
    
   Scenario: Verify whether user can search the records.
   And Expand the Calendar Month Report option under Reports section in Side Menu
   And Navigate to Calendar Month Report page
   When User inputs a parameter in the Calender Month search field 
   Then Table should load the results on Calender Month Page
   
   Scenario: Verify whether parameters selected in the Calendar Month are the same in the Rolling Month Report
   And Expand the Calendar Month Report option under Reports section in Side Menu
   And Navigate to Calendar Month Report page
   When User navigates to the Rolling Month Report
   Then The Calendar Month Report parameters should match the Rolling Month Report.
    
  #Scenario Outline: Verify Calendar Month Report page Element visibility and filter functionality
#	  Given Selects filters as '<filter1>' and '<filter2>' in the initial page
#	  And Click on the Menu bar
#	  When Expand the '<Main_menu>' menu 
#	  Then Expand the '<sub_menu>' menu option
#	  And Select the '<landing_Page>' option
  #	And Navigate to '<target_Page>' page
#	  Given Check the header of the navigated page '<target_Page_header>'
#	  And Verify Group was selected as '<filter1>' and Property was selected as '<nullVal>'
#	  When Click on the Go button
#	  Then Verify Properties available
  #
   #Examples: 
       #|    filter1         | filter2 													| Main_menu | sub_menu|     landing_Page    |   target_Page  |     target_Page_header 			| nullVal |  
       #|  Beck Legacy Group | Days Inn & Suites Page Lake Powell|  Reports  | Revenue |30/60/90 Report (New)| Calendar Month |30/60/90 Calendar Month Report| null		| 
       
  