@myP2_Regression
Feature: P&L Monthly Report

Background: Navigate to P&L Monthly report
    Given I am login to the myp2 site
    And System navigate to the home page
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Monthly page   
    And select the Group ,Propery, date,View and Click on GO button
 
    Scenario: Verify the Static section 
    Then Page should load the defualt static section 
    When ROOMS SOLD divided by ROOMS AVAILABLE
    Then Calculated value should be match with OCCUPANCY
    When Total Rooms Revenue divided by ROOMS SOLD
    Then Calculated value should be match with ADR
    When Total Rooms Revenue divided by ROOMS AVAILABLE
    Then Calculated value should be match with REV-PAR
    When TOTAL OPERATING REVENUE divided by ROOMS AVAILABLE
    Then Calculated value should be match with TOTAL REV-PAR
    Then the P&L should show the relevent sections that belong to the Owner's view 
    When user selects the Operators View
    Then the P&L should show the relevent sections that belong to the Operators View
    When user selects the Room Revenue Detail View
    Then the P&L should show the relevent sections that belong to the Room Revenue Detail view
      

     
     
     
     
    
    
