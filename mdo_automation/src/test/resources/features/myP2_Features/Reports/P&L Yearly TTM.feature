#Author: haniffa@mydigitaloffice.ca
@myP2_Regression @tgPnlYearly

Feature: P&L Yearly - TTM Validation

	 Background: Navigate to P&L report Func
   Given I am login to the myp2 site
   And System navigate to the home page
   And Select the organization as "Beck Legacy Group" 
   And I am expand the P&L Statement option under Reports section in Side Menu
   Then I am navigate to P&L Yearly page
   
   Scenario: Verify PnL Yearly Static Section
   Given I select the group,property,view
   And I am Loading the PnLYearly Report with GO button
   Then Page should load the defualt static section
   
   Scenario: Verify whethere Page load according to TTM Year function
   Given I select the group,property,view
   When I am Loading the PnLYearly Report with GO button
   Then Page should load the defualt static section
   And  Verify whether the header load according to TTM selected
    
   Scenario: Verify whether the Edit Column first year dropdown disabled
   Given I select the group,property,view
   When I am Loading the PnLYearly Report with GO button
   Then Page should load the defualt static section
   And I am navigate to PnL Yearly Edit Column
 	 And Verify whether the year drodwon disabled
 	 
 	 Scenario: Verify whether the month header is located correctly 
 	 Given I select the group,property,view
   When I am Loading the PnLYearly Report with GO button
   Then Page should load the defualt static section
   And I am validating the month header
    
    
    