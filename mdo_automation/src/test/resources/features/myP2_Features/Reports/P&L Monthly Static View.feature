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
    
     
     
     