#Author: haniffa@mydigitaloffice.ca
@myP2_Regression  @myP2_Smoke @PnLYearly

Feature: P&L Yearly - View Feature Validation and Static Calculation

  Scenario: Verify the view, Custom column , year dropdown values
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    And I am expand the P&L Statement option under Reports section in Side Menu
    Then I am navigate to P&L Yearly page
    And I select the group "All groups" , property "Days Inn & Suites Page Lake Powell" , year "2021" , view "Owner's View"
    When User Clicks on the View dropdown
    Then View dropdown should contains Owners View , Operators View, Room Revenue Detail, Add Custom View
    When User clicks on edit column option 
    Then Custom column1 dropdown should contains ACTUAL , BUDGET , FORECAST , ACTUAL/FORECAST
    And  Year  dropdown should contain the current year at the top and the past four years in descending order

	Scenario: Validation of P&L Yearly Static section KPI
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    And I am expand the P&L Statement option under Reports section in Side Menu
    Then I am navigate to P&L Yearly page
    And I select the group "All groups" , property "Days Inn & Suites Page Lake Powell" , year "2020" , view "Owner's View"
  
    When I am Loading the PnLYearly Report with GO button
    Then Page should load the defualt static section 
    And I am calulating the values
	
		When ROOMS SOLD divided by ROOMS AVAILABLE Yearly    
    Then Calculated value should be match with OCCUPANCY Yearly
   
    When Total Rooms Revenue divided by ROOMS SOLD Yearly
    Then Calculated value should be match with ADR Yearly
   
    When Total Rooms Revenue divided by ROOMS AVAILABLE Yearly
    Then Calculated value should be match with REV-PAR Yearly
   
    When TOTAL OPERATING REVENUE divided by ROOMS AVAILABLE Yearly
    Then Calculated value should be match with TOTAL REV-PAR Yearly
    
  @myP2_Smoke
  Scenario Outline: Verify P&L Yearly report page Element visibility and filter functionality
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
	  Given Selects filters as '<filter1>' and '<filter2>' in the initial page
	  And Click on the Menu bar
	  When Expand the '<Main_menu>' menu 
	  Then Expand the '<sub_menu>' menu option
	  And Select the '<target_Page>' option
	  Given Check the header of the navigated page '<target_Page_header>'
	  And Verify Group was selected as '<filter1>' and Property was selected as '<filter2>'
	  When Click on the Go button
	  Then Verify name raws
  
   Examples: 
       |    filter1         |            filter2 								| Main_menu |  sub_menu |      target_Page 			  |		  target_Page_header			| nullVal | 
       |  Beck Legacy Group | Days Inn & Suites Page Lake Powell|  Reports	|P&L Reports| P&L Yearly Report (New) | Profit & Loss Yearly Report |   null 	|
       
    
   
    
    
    
    