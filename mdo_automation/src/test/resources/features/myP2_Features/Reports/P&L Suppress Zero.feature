#Author: sannorj@mydigitaloffice.ca
@myP2_Regression  @myP2_Smoke @PnL @SurpassZero

Feature: P&L - Suppress Zero Values

	Background: Navigate to P&L report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    And I am expand the P&L Statement option under Reports section in Side Menu
    
    Scenario: Verify whether user can hide the rows with 0 value on the P&L monthly report
    When go to the P&L Monthly page  
    And Select the Group ,Propery, feature date,View and Click on GO button 
    And Turn on the Zero Value Rows toggle button 
    Then The report should suppress records that have amount 0 for all applicable columns. 
    
    Scenario: Verify whether user can hide the rows with 0 value on the P&L yearly report
    When I am navigate to P&L Yearly page  
    And I select the group "All groups" , property "Days Inn & Suites Page Lake Powell" , year "2017" , view "Owner's View"
    And Turn on the Zero Value Rows toggle button 
    Then The report should suppress records that have amount 0 for all applicable columns. 
    
    
    