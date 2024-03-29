#Author: haniffa@mydigitaloffice.ca


Feature: GL Hierarchy - Toggle button Validation With PnL Monthly 

    Background: Navigate to P&L Monthly report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Monthly page
    And select the Group ,Propery, date,View and Click on GO button
    
    Scenario: Verify the All on Modal Function
    Given I am expand the configuration options in Side Menu
		Then I am navigate to GL Hierarchy page
		And Click the All On button
		And  Verify whether the function worked properly
    
    Scenario: Verify whether the PnL month Room revenue bottom child modal section working according to the GL Hierarchy Toggle button
 		Given I am expanding the bottom child value of Total Room revenue
 		Then I am expand the configuration options in Side Menu
 		And I am navigate to GL Hierarchy page
 		When Verify the captured bottom modal GL hierarchy and turn off the modal
 		Then I am expand the P&L Statement option under Reports section in Side Menu
 		And go to the P&L Monthly page
    Then load the PnL Monthly With GO button
    And Verify the bottom child modal is not visible in the report
    
    Scenario: Verify whether the PnL month Room revenue top child modal section working according to the GL Hierarchy Toggle button
 		Given I am expanding the top child value of Total Room revenue
 		Then I am expand the configuration options in Side Menu
 		And I am navigate to GL Hierarchy page
 		When Verify the captured top modal GL hierarchy and turn off the modal
 		Then I am expand the P&L Statement option under Reports section in Side Menu
 		And go to the P&L Monthly page
    Then load the PnL Monthly With GO button
    And Verify the top child modal is not visible in the report
    
    Scenario: Verify whether the PnL month Room revenue parent modal section working according to the GL Hierarchy Toggle button
    Given I am expanding the parent value of Total Room revenue
 		Then I am expand the configuration options in Side Menu
 		And I am navigate to GL Hierarchy page
 		When Verify the captured parent modal GL hierarchy and turn off the modal
 		Then I am expand the P&L Statement option under Reports section in Side Menu
 		And go to the P&L Monthly page
    Then load the PnL Monthly With GO button
    And Verify the parent modal is not visible in the report
    
    Scenario: All on Modal Function After Validation
    Given I am expand the configuration options in Side Menu
		Then I am navigate to GL Hierarchy page
		And Click the All On button
		And  Verify whether the function worked properly
    

  
	