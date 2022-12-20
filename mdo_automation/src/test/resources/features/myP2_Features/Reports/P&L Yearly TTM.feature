#Author: haniffa@mydigitaloffice.ca
@myP2_Regression @pnlT

Feature: P&L Yearly - TTM Validation

	 Background: Navigate to P&L report Func
   Given I am login to the myp2 site
   And System navigate to the home page
   And Select the organization as "Beck Legacy Group" 
   
   Scenario: Verify PnL Yearly Static Section
   And I am expand the P&L Statement option under Reports section in Side Menu
   Then I am navigate to P&L Yearly page
   Given I select the group,property,view
   And I am Loading the PnLYearly Report with GO button
   Then Page should load the defualt static section
   
   Scenario: Verify whethere Page load according to TTM Year function
   And I am expand the P&L Statement option under Reports section in Side Menu
   Then I am navigate to P&L Yearly page
   Given I select the group,property,view
   When I am Loading the PnLYearly Report with GO button
   Then Page should load the defualt static section
   And  Verify whether the header load according to TTM selected
    
   Scenario: Verify whether the Edit Column first year dropdown disabled
   And I am expand the P&L Statement option under Reports section in Side Menu
   Then I am navigate to P&L Yearly page
   Given I select the group,property,view
   When I am Loading the PnLYearly Report with GO button
   Then Page should load the defualt static section
   And I am navigate to PnL Yearly Edit Column
 	 And Verify whether the year drodwon disabled
 	 
 	 Scenario: Verify whether the month header is located correctly 
   And I am expand the P&L Statement option under Reports section in Side Menu
   Then I am navigate to P&L Yearly page
 	 Given I select the group,property,view
   When I am Loading the PnLYearly Report with GO button
   Then Page should load the defualt static section
   And I am validating the month header
    
  @myP2_Smoke
  Scenario Outline: Verify P&L Yearly page Element visibility and filter functionality
	  Given Selects filters as '<filter1>' and '<filter2>' in the initial page
	  And Click on the Menu bar
	  When Expand the '<Main_menu>' menu 
	  Then Expand the '<sub_menu>' menu option
	  And Select the '<target_Page>' option
	  Given Check the header of the navigated page '<target_Page_header>'
	  And Verify Group was selected as '<filter1>' and Property was selected as '<filter2>'
	  And Select '<year>' option
	  When Click on the Go button
	  Then Verify name raws
  
   Examples: 
       |    filter1         |            filter2 								| Main_menu |  sub_menu |      target_Page 			  |		  target_Page_header			| nullVal | year |
       |  Beck Legacy Group | Days Inn & Suites Page Lake Powell|  Reports	|P&L Reports| P&L Yearly Report (New) | Profit & Loss Yearly Report |   null 	| TTM  |
    