#Author: sannorj@mydigitaloffice.ca
@myP2_Regression  @myP2_Smoke @PnLcomparisonEdit

Feature:  P&L Comparison Report - Edit Column functionality  

  Background: Navigate to P&L Monthly report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    
 
  Scenario: Verify whether user can remove the newly inserted column
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Property Comparison
    And Select the Group , date,View and Click on GO button
    When User clicks on edit column option 
    And Remove the values for the columns and years on the Comparison Edit screen, then click the Apply button.
    Then Table should remove the newly inserted column from the Comparison table
 
  