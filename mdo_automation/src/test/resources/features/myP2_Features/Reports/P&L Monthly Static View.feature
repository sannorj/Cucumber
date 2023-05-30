#Author: sannorj@mydigitaloffice.ca
@myP2_Regression  @myP2_Smoke @PnLMonthlyFix

Feature:  P&L Monthly Report - View Feature Validation and Static Calculation

Background: Navigate to P&L Monthly report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Monthly page   
    And select the Group ,Propery, date,View and Click on GO button
    
    Scenario: Verify the view, Custom column , year dropdown values
     When User Clicks on the View dropdown
     Then View dropdown should contains Owners View , Operators View, Room Revenue Detail, Add Custom View
     When User clicks on edit column option 
     Then Custom column1 dropdown should contains ACTUAL , BUDGET , FORECAST , ACTUAL/FORECAST
     And  Year  dropdown should contain the current year at the top and the past four years in descending order
    
    Scenario: Verify the Static section 
     Then Page should load the defualt static section 
    
    #Scenario: Verify that the occupancy calculations are correct
     When ROOMS SOLD divided by ROOMS AVAILABLE
     Then Calculated value should be match with OCCUPANCY
    
    #Scenario: Verify that the ADR calculations are correct 
     When Total Rooms Revenue divided by ROOMS SOLD
     Then Calculated value should be match with ADR
    
    #Scenario: Verify that the REV-PAR calculations are correct	
     When Total Rooms Revenue divided by ROOMS AVAILABLE
     Then Calculated value should be match with REV-PAR
    
    #Scenario: Verify that the TOTAL REV-PAR calculations are correct 
     When TOTAL OPERATING REVENUE divided by ROOMS AVAILABLE
     Then Calculated value should be match with TOTAL REV-PAR
    
    #Scenario: Verify whether users should be allowed to choose Owners view from a dropdown menu.
     Then the P&L should show the relevent sections that belong to the Owner's view 
    
    #Scenario: Verify whether users should be allowed to choose Room Revenue Detail view from a dropdown menu.
     When user selects the Room Revenue Detail View
     Then the P&L should show the relevent sections that belong to the Room Revenue Detail view

   @myP2_Smoke 
   Scenario Outline: Verify P&L Monthly page Element visibility and filter functionality
   
    When Click on the Menu bar and navigate to primary dashboard
	  Given Selects filters as '<filter1>' and '<filter2>' in the initial page
	  And Click on the Menu bar
	  When Expand the '<Main_menu_1>' menu 
	  Then Expand the '<sub_menu_1>' menu option
	  And Select the '<target_Page_1>' option
	  And Click on the Menu bar
	  When Expand the '<Main_menu>' menu 
	  Then Expand the '<sub_menu>' menu option
	  And Select the '<target_Page>' option
	  Given Check the header of the navigated page '<target_Page_header>'
	  And Verify Group was selected as '<filter1>' and Property was selected as '<filter2>'
	  When Click on the Go button
  
   Examples: 
       |    filter1         | filter2 													| Main_menu |  sub_menu  |      target_Page  				|     target_Page_header 			| nullVal |  Main_menu_1  |  	 sub_menu_1    |  target_Page_1 |
       |  Beck Legacy Group | Days Inn & Suites Page Lake Powell|  Reports  | P&L Reports| P&L Monthly Report (New) | Profit & Loss Monthly Report| null		| Configuration | Accounts Mapping | 	 AR Mapping   |
       
     
     