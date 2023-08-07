#Author: sannorj@mydigitaloffice.ca
@myP2_Regression

Feature: P&L Property Comparison - View Feature Validation and Static Calculation

	Background: Navigate to Property Comparison report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Property Comparison
    And Select the Group , date,View and Click on GO button
    
  Scenario: Verify the view, Custom column , year dropdown values
    When User Clicks on the View dropdown PnL Comparison
    Then View dropdown should contains Owners View , Operators View, Room Revenue Detail, Add Custom View in PnL Comparioson
    When User clicks on edit column option in PnL Comparison
    Then Custom column1 dropdown should contains ACTUAL , BUDGET , FORECAST , ACTUAL/FORECAST in PnL Comparison
    And  Year dropdown should contain the current year at the top and the past 4 years in descending order
  
  Scenario: Verify the View Feature and Static Calculation 
    Then Page should load the defualt static section in PnL Comparison

@sana
  Scenario: Verify that the occupancy calculations are correct 
    When ROOMS SOLD divided by ROOMS AVAILABLE in PnL Comparison
    Then Calculated value should be match with OCCUPANCY in PnL Comparison
  