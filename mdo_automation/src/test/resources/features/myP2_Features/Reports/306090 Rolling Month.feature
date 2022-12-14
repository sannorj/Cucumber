#Author: sannorj@mydigitaloffice.ca
@myP2_Regression @myP2_Smoke 

Feature: 306090 Rolling Month Report - Header, Parameters and Search Validation 

   Background: Navigate to 306090 Rolling Month Report
   Given I am login to the myp2 site
   And System navigate to the home page
   And Select the organization as "Beck Legacy Group"
    
   Scenario: Verify whether the default Rolling Month headers are loaded on the page
   And Expand the Rolling Month Report option under Reports section in Side Menu
   And Navigate to Rolling Month Report page
   When User selects the Group and date
   Then Default Rolling Month Headers should be loaded on the page.
   
   Scenario: Verify whether user can search the records.
   And Expand the Rolling Month Report option under Reports section in Side Menu
   And Navigate to Rolling Month Report page
   When User inputs a parameter in the Rolling Month search field 
   Then Table should load the results on Rolling Month Page
   
   Scenario: Verify whether parameters selected in the Rolling Month are the same in the Calendar Month Report
   And Expand the Rolling Month Report option under Reports section in Side Menu
   And Navigate to Rolling Month Report page
   When User navigates to the Calendar Month Report
   Then The Rolling Month Report parameters should match the Calendar Month Report.
    
	@myP2_Smoke @dropdown_validation
  Scenario Outline: Verify Rolling Month Report page Element visibility and filter functionality
	  Given Selects filters as '<filter1>' and '<filter2>' in the initial page
	  And Click on the Menu bar
	  When Expand the '<Main_menu>' menu 
	  Then Expand the '<sub_menu>' menu option
	  And Select the '<landing_Page>' option
  	And Navigate to '<target_Page>' page
	  Given Check the header of the navigated page '<target_Page_header>'
	  And Verify Group was selected as '<filter1>' and Property was selected as '<nullVal>'
	  When Click on the Go button
	  Then Verify Properties available
  
   Examples: 
       |    filter1         | filter2 													| Main_menu | sub_menu|     landing_Page    |   target_Page  |     target_Page_header 			| nullVal |  
       |  Beck Legacy Group | Days Inn & Suites Page Lake Powell|  Reports  | Revenue |30/60/90 Report (New)|  Rolling Month |30/60/90 Rolling Month Report | null		| 
       
  
   
   