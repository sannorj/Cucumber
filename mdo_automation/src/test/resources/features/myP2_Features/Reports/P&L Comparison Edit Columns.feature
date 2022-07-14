#Author: sannorj@mydigitaloffice.ca
@myP2_Regression @myP2_Smoke @SMPL1

Feature:  P&L Comparison Report - Edit Column functionality  

Background: Navigate to P&L Monthly report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Property Comparison
    And Select the Group , date,View and Click on GO button
    
    Scenario: Verify that the very first three column headers match to the edit drawer drop downs
    When User clicks on edit column option 
    And Page should open the edit column drawer
    Then First column and the year dropdown value should match the first table column
    And The value of the year & value should match the second column in the comparison pages table.
    
    Scenario: Verify whether user can add a additional coulmn 
    When User clicks on edit column option 
    And Select column and year from the dropdown and click on apply button in Comparison page 
    Then Table should show the newly inserted column in Comparison page 
    
    Scenario: Verify whether user can remove the newly inserted column
    When User clicks on edit column option 
    And Remove the values for the columns and years on the Comparison Edit screen, then click the Apply button.
    Then Table should remove the newly inserted column from the Comparison table
    
    Scenario: Verify whether user can edit every header that is available
    When User clicks on edit column option 
    And change the all the parameters in edit column 
    Then Table should display the recently modified column
    
 