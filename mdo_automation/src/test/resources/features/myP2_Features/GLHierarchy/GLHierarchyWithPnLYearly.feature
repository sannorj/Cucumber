#Author: haniffa@mydigitaloffice.ca
@myP2_Regression @GlPnlYearly11 @gl
Feature: GL Hierarchy Toggle button Validation With PnL Yearly

	Background: Navigate to P&L Yearly report
    Given I am login to the myp2 site
    And System navigate to the home page
    Then Select the organization as "Beck Legacy Group"
    
	Scenario: Verify the All on Modal Function
    When I am expand the P&L Statement option under Reports section in Side Menu
    Then I am navigate to P&L Yearly page
    And I select the group "All groups" , property "Days Inn & Suites Page Lake Powell" , year "2020" , view "Owner's View"
    And I am Loading the PnLYearly Report with GO button
    Given I am expand the configuration options in Side Menu
		Then I am navigate to GL Hierarchy page
		And Click the All On button
		And  Verify whether the function worked properly

	Scenario: Verify whether the PnL Yearly Room revenue top child modal section working according to the GL Hierarchy Toggle button
    When I am expand the P&L Statement option under Reports section in Side Menu
    Then I am navigate to P&L Yearly page
    And I select the group "All groups" , property "Days Inn & Suites Page Lake Powell" , year "2020" , view "Owner's View"
    And I am Loading the PnLYearly Report with GO button
 		Given I am expanding the top child value of Total Room revenue in PnL Yearly
 		Then I am expand the configuration options in Side Menu
 		And I am navigate to GL Hierarchy page
 		When Verify the captured top modal in PnL Yearly with GL hierarchy and turn off the modal
 		Then I am expand the P&L Statement option under Reports section in Side Menu
 		And I am navigate to P&L Yearly page
    When I select the group "All groups" , property "Days Inn & Suites Page Lake Powell" , year "2020" , view "Owner's View"
    Then I am Loading the PnLYearly Report with GO button
    And Verify the top child modal is not visible in the Pnl Yearly report
    
	Scenario: Verify whether the PnL Yearly Room revenue parent modal section working according to the GL Hierarchy Toggle button
    When I am expand the P&L Statement option under Reports section in Side Menu
    Then I am navigate to P&L Yearly page
    And I select the group "All groups" , property "Days Inn & Suites Page Lake Powell" , year "2020" , view "Owner's View"
    And I am Loading the PnLYearly Report with GO button
 		Given I am expanding the parent value of Total Room revenue in PnL Yearly
 		Then I am expand the configuration options in Side Menu
 		And I am navigate to GL Hierarchy page
 		When Verify the captured parent modal in PnL Yearly with GL hierarchy and turn off the modal
 		Then I am expand the P&L Statement option under Reports section in Side Menu
 		And I am navigate to P&L Yearly page
    When I select the group "All groups" , property "Days Inn & Suites Page Lake Powell" , year "2020" , view "Owner's View"
    Then I am Loading the PnLYearly Report with GO button
    And Verify the parent modal is not visible in the Pnl Yearly report
    
   Scenario: Verify the All on Modal Function
    When I am expand the P&L Statement option under Reports section in Side Menu
    Then I am navigate to P&L Yearly page
    And I select the group "All groups" , property "Days Inn & Suites Page Lake Powell" , year "2020" , view "Owner's View"
    And I am Loading the PnLYearly Report with GO button
    Given I am expand the configuration options in Side Menu
		Then I am navigate to GL Hierarchy page
		And Click the All On button
		And  Verify whether the function worked properly

	@myP2_Smoke 
  Scenario Outline: Verify P&L Yearly Report page Element visibility and filter functionality
	  Given Selects filters as '<filter1>' and '<filter2>' in the initial page
	  And Click on the Menu bar
	  When Expand the '<Main_menu>' menu 
	  Then Expand the '<sub_menu>' menu option
	  And Select the '<target_Page>' option
	  Given Check the header of the navigated page '<target_Page_header>'
	  And Verify Group was selected as '<filter1>' and Property was selected as '<filter2>'
  
   Examples: 
       |    filter1         | filter2 													| Main_menu |  sub_menu  |      target_Page        |      target_Page_header     | nullVal  |
       |  Beck Legacy Group | Days Inn & Suites Page Lake Powell|  Reports  | P&L Reports| P&L Yearly Report (New) | Profit & Loss Yearly Report |  null		|
		   