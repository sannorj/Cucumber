#Author: haniffa@mydigitaloffice.ca
@myP2_Regression 
Feature: GL Hierarchy Toggle button Validation With PnL Comparison

	Background: Navigate to P&L Property Comparison report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group"
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Property Comparison
    And Select the Group , date,View and Click on GO button
    
    Scenario: Verify the All on Modal Function
    Given I am expand the configuration options in Side Menu
		Then I am navigate to GL Hierarchy page
		And Click the All On button
		And  Verify whether the function worked properly
    
#	Scenario: Verify whether the PnL comparison Room revenue bottom child modal section working according to the GL Hierarchy Toggle button
 #		Given I am expanding the bottom child value of Total Room revenue in PnL Comparison
 #		Then I am expand the configuration options in Side Menu
 #		And I am navigate to GL Hierarchy page
 #		When Verify the captured bottom modal in PnL Comparison with GL hierarchy and turn off the modal
 #		Then I am expand the P&L Statement option under Reports section in Side Menu
 #		And go to the P&L Property Comparison
 #    And Select the Group , date,View and Click on GO button
 #    And Verify the bottom child modal is not visible in the Pnl comparison report		

  #Scenario: Verify whether the PnL comparison Room revenue top child modal section working according to the GL Hierarchy Toggle button
 #		Given I am expanding the top child value of Total Room revenue in PnL Comparison
 #		Then I am expand the configuration options in Side Menu
 #		And I am navigate to GL Hierarchy page
 #		When Verify the captured top modal in PnL Comparison with GL hierarchy and turn off the modal
 #		Then I am expand the P&L Statement option under Reports section in Side Menu
 #		And go to the P&L Property Comparison
    #And Select the Group , date,View and Click on GO button
    #And Verify the top child modal is not visible in the Pnl comparison report
    #
  #Scenario: Verify whether the PnL comparison Room revenue parent modal section working according to the GL Hierarchy Toggle button
 #		Given I am expanding the parent value of Total Room revenue in PnL Comparison
 #		Then I am expand the configuration options in Side Menu
 #		And I am navigate to GL Hierarchy page
 #		When Verify the captured parent modal in PnL Comparison with GL hierarchy and turn off the modal
 #		Then I am expand the P&L Statement option under Reports section in Side Menu
 #		And go to the P&L Property Comparison
    #And Select the Group , date,View and Click on GO button
    #And Verify the parent modal is not visible in the Pnl comparison report 
    #
    #Scenario: Verify the All on Modal Function
    #Given I am expand the configuration options in Side Menu
#		Then I am navigate to GL Hierarchy page
#		And Click the All On button
#		And  Verify whether the function worked properly
#		

		   