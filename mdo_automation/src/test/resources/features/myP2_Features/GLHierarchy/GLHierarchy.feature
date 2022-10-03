#Author: haniffa@mydigitaloffice.ca
@myP2_Regression @glhFix

Feature: GL Hierarchy

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
    
    
    
    