#Author: haniffa@mydigitaloffice.ca
@myP2_Regression

Feature: P&L Yearly - TTM Validstion

	Background: Navigate to P&L report Func
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    And I am expand the P&L Statement option under Reports section in Side Menu
    Then I am navigate to P&L Yearly page
    And I select the group "All groups" , property "Hampton Inn & Suites Page Lake Powell" , view "Owner's View"
    When I am Loading the PnLYearly Report with GO button
   
   Scenario: Verify whethere Page load according to TTM Year function
   
    Then Page should load the defualt static section
    And  Verify whether the header load according to TTM selected
    
    
    