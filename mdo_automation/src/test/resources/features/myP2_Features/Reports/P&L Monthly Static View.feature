#Author: sannorj@mydigitaloffice.ca
@myP2_Regression @myP2Sanity @PnLMont
 
Feature:  P&L Monthly Report - View Feature Validation and Static Calculation

Background: Navigate to P&L Monthly report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Monthly page   
    And select the Group ,Propery, date,View and Click on GO button
    
    
    Scenario: Verify whether users should be allowed to choose Operators view from a dropdown menu.
     When user selects the Operators View
     Then the P&L should show the relevent sections that belong to the Operators View
   


     
     
     
     
    
   
