#Author: haniffa@mydigitaloffice.ca
@myP2_Regression @myP2Sanity

Feature: P&L Yearly - View Feature Validation and Static Calculation


  Scenario: Navigate to P&L report Func
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    And I am expand the P&L Statement option under Reports section in Side Menu
    Then I am navigate to P&L Yearly page
    And I select the group "All groups" , property "Days Inn & Suites Page Lake Powell" , year "2020" , view "Owner's View"
    
     When User Clicks on the View dropdown
     Then View dropdown should contains Owners View , Operators View, Room Revenue Detail, Add Custom View
     When User clicks on edit column option 
     Then Custom column1 dropdown should contains ACTUAL , BUDGET , FORECAST , ACTUAL/FORECAST
     And  Year  dropdown should contain the current year at the top and the past 4 years in descending order
     
     
	Scenario: Navigate to P&L report Func
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
    
  
    
   
    
    
    
    