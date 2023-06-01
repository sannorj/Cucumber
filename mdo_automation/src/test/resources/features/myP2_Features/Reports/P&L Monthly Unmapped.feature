#Author: pasindu@mydigitaloffice.ca
@myP2_Regression @pnlMonthlyUnmapped @pasindu

Feature: P&L Monthly - Unmapped

    Background: Navigate to P&L Monthly report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Insignia Hospitality Group" 
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Monthly page   
    And select the Group ,Propery, date,View and Click on GO button
    
    Scenario: Verifying if an error is prompted when the Profit & Loss Unmapped report is generated
    When User clicks on Profit & Loss Unmapped option button
    And User navigates to Profit & Loss Unmapped page
		Then User select a Property, Year and Missing Property GL value from Unmapped dropdown and click GO button
		And confirm if data is generated for the selected parameters without any errors being prompted
		Then User select a Property, Year and GL not in COA value from Unmapped dropdown and click GO button
		And confirm if data is generated for the selected parameters without any errors being prompted
		Then User select a Property, Year and GL not mapped value from Unmapped dropdown and click GO button
		And confirm if data is generated for the selected parameters without any errors being prompted