#Author: sannorj@mydigitaloffice.ca
@myP2_Regression @myP2_Smoke @BSB

Feature:  P&L Monthly Report - Edit Column functionality  

Background: Navigate to P&L Monthly report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "HighGate Hotels" 
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Monthly page  
    And select the Group ,Propery, date,View and Click on GO button
    
    Scenario: Verify that the very first three column headers match to the edit drawer drop downs
    When User clicks on edit column option 
    And Page should open the edit column drawer
    Then First column and the year dropdown value should match the first table column
    And Second column and the year dropdown value should match the table column
    And Third column and the year dropdown value should match the table column
    
    Scenario: Verify whether user can add a additional coulmn 
    When User clicks on edit column option 
    And Select column and year from the dropdown and click on apply button 
    Then Table should show the newly inserted column 
    
    Scenario: Verify whether user can remove the newly inserted column
    When User clicks on edit column option 
    And Remove column and year values from the dropdown and click on apply button
    Then Table should remove the newly inserted column from the table
 
    
    
    
    
    
    
    
    
    
    
    
    
     
