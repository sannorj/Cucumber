#Author: sannorj@mydigitaloffice.ca
@myP2_Regression @myP2_Smoke111 

Feature:  P&L Monthly Report - View Feature Validation and Static Calculation

Background: Navigate to P&L Monthly report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Monthly page   
    And select the Group ,Propery, date,View and Click on GO button
 
    Scenario: Verify the Static section 
    Then Page should load the defualt static section 
    
    #Scenario: Verify that the occupancy calculations are correct
    When ROOMS SOLD divided by ROOMS AVAILABLE
    Then Calculated value should be match with OCCUPANCY
    
    #Scenario: Verify that the ADR calculations are correct 
    When Total Rooms Revenue divided by ROOMS SOLD
    Then Calculated value should be match with ADR
    
    #Scenario: Verify that the REV-PAR calculations are correct	
    When Total Rooms Revenue divided by ROOMS AVAILABLE
    Then Calculated value should be match with REV-PAR
    
    #Scenario: Verify that the TOTAL REV-PAR calculations are correct 
    When TOTAL OPERATING REVENUE divided by ROOMS AVAILABLE
    Then Calculated value should be match with TOTAL REV-PAR
    
    Scenario: Verify whether users should be allowed to choose Owners view from a dropdown menu.
    Then the P&L should show the relevent sections that belong to the Owner's view 
    
    #Scenario: Verify whether users should be allowed to choose Operators view from a dropdown menu.
    When user selects the Operators View
    Then the P&L should show the relevent sections that belong to the Operators View
    
    #Scenario: Verify whether users should be allowed to choose Room Revenue Detail view from a dropdown menu.
    When user selects the Room Revenue Detail View
    Then the P&L should show the relevent sections that belong to the Room Revenue Detail view
      

     
     
     
     
    
    
