#Author: haniffa@mydigitaloffice.ca
@myP2_Regression  @myP2_Smoke @PnL

Feature: P&L Yearly - TTM Forcast Functionalty 

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
   
    #Scenario: Storing and comparing actual forcast data with TTM forcast data
    #Given I select the group,property,view in TTM
    #When I am Loading the PnLYearly Report with GO button
    #Then Page should load the defualt static section
    #And I am storing the TTM forcast data
    #Given I select the group,property,view
    #When I am Loading the PnLYearly Report with GO button
    #Then Page should load the defualt static section
    #And I am storing the actual forcast data
    #And I compare the stored forcast data
    #
    