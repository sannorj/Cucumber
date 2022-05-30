@myP2_Regression @PnlSmoke5
Feature: P&L Yearly - View Feature Validation and Static Calculation
@kethees
	Scenario: Navigate to P&L report Func
    Given I am login to the myp2 site
    And System navigate to the home page
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
    
   
    
    
    
    