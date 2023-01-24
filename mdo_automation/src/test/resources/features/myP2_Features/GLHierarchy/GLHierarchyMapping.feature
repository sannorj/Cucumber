#Author: sannorj@mydigitaloffice.ca
@myP2_Regression @myP2_Smoke 

Feature: GL Hierarchy - hmg gl code  mapping validation

Background: Navigate to P&L Monthly report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    
   Scenario: Verify whether user can map a single available hmg code to a mdo gl code
    And I am expand the configuration options in Side Menu
    And I am navigate to GL Hierarchy page
   When user selects the property form property dropdown
   Then based on the property page should load the MDO gl codes 
   And  clicks on the add GL Codes button from the UI
   And  select one single available hmg gl code from the pop-up and click on save button 
   Then Add GL Codes text should change to Manage GL Codes
   
   Scenario: Verify whether user can remove the mapped hmg code from the pop-up
    And I am expand the configuration options in Side Menu
    And I am navigate to GL Hierarchy page
   When user selects the property form property dropdown
   Then based on the property page should load the MDO gl codes 
   And  clicks on the Manage GL Codes button from the UI
   And  Remove the all mapped hmg GL codes 
   Then Manage GL Codes GL Codes text should change to Add GL Codes
   
   Scenario: Verify whether user can map a multiple available hmg code to a mdo gl code
    And I am expand the configuration options in Side Menu
    And I am navigate to GL Hierarchy page
   When user selects the property form property dropdown
   Then based on the property page should load the MDO gl codes 
   And  clicks on the add GL Codes button from the UI
   And  select multiple available hmg gl code from the pop-up and click on save button 
   Then Add GL Codes text should change to Manage GL Codes
   
   Scenario: Verify whether user can remove the mapped hmg code from the pop-up
    And I am expand the configuration options in Side Menu
    And I am navigate to GL Hierarchy page
   When user selects the property form property dropdown
   Then based on the property page should load the MDO gl codes 
   And  clicks on the Manage GL Codes button from the UI
   And  Remove the all mapped hmg GL codes 
   Then Manage GL Codes GL Codes text should change to Add GL Codes 
   
  Scenario Outline: Verify GL Hierarchy page Element visibility and filter functionality
	  Given Selects filters as '<filter1>' and '<filter2>' in the initial page
	  And Click on the Menu bar
	  When Expand the '<Main_menu>' menu 
	  Then Expand the '<sub_menu>' menu option
	  And Select the '<target_Page>' option
	  Given Check the header of the navigated page '<target_Page_header>'
	  And Verify Group was selected as '<nullVal>' and Property was selected as '<filter2>'
  
   Examples: 
       |    filter1         | filter2 													| 	 Main_menu  |  sub_menu  | target_Page  | target_Page_header 	| nullVal |
       |  Beck Legacy Group | Days Inn & Suites Page Lake Powell| Configuration | P&L Mapping| GL Hierarchy |     GL Hierarchy    | null		|
	
	