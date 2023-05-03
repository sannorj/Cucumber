#Author: sannorj@mydigitaloffice.ca
@myP2_Regression @PnLComparison

Feature: P&L Property Comparison - View Feature Validation and Static Calculation

	Background: Navigate to Property Comparison report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    
  Scenario: Verify the view, Custom column , year dropdown values
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Property Comparison
    And Select the Group , date,View and Click on GO button
    When User Clicks on the View dropdown PnL Comparison
    Then View dropdown should contains Owners View , Operators View, Room Revenue Detail, Add Custom View in PnL Comparioson
    When User clicks on edit column option in PnL Comparison
    Then Custom column1 dropdown should contains ACTUAL , BUDGET , FORECAST , ACTUAL/FORECAST in PnL Comparison
    And  Year dropdown should contain the current year at the top and the past 4 years in descending order
  
  Scenario: Verify the View Feature and Static Calculation 
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Property Comparison
    And Select the Group , date,View and Click on GO button
    Then Page should load the defualt static section in PnL Comparison

    #Scenario: Verify that the occupancy calculations are correct 
    #When ROOMS SOLD divided by ROOMS AVAILABLE in PnL Comparison
    #Then Calculated value should be match with OCCUPANCY in PnL Comparison
    
    #Scenario: Verify that the ADR calculations are correct 
    #When Total Rooms Revenue divided by ROOMS SOLD in PnL Comparison
    #Then Calculated value should be match with ADR in PnL Comparison
    
    #Scenario: Verify that the REV-PAR calculations are correct 
    #When Total Rooms Revenue divided by ROOMS AVAILABLE
    #Then Calculated value should be match with REV-PAR
    
    #Scenario: Verify that the TOTAL REV-PAR calculations are correct 
    #When TOTAL OPERATING REVENUE divided by ROOMS AVAILABLE
    #Then Calculated value should be match with TOTAL REV-PAR
    
    #Scenario: Verify whether users should be allowed to choose Owners view from a dropdown menu.
    #Then the P&L should show the relevent sections that belong to the Owner's view 
    
    #Scenario: Verify whether users should be allowed to choose Operators view from a dropdown menu.
    #When user selects the Operators View
    #Then the P&L should show the relevent sections that belong to the Operators View
    
    #Scenario: Verify whether users should be allowed to choose Room Revenue Detail view from a dropdown menu.
    #When user selects the Room Revenue Detail View
    #Then the P&L should show the relevent sections that belong to the Room Revenue Detail view
      
  