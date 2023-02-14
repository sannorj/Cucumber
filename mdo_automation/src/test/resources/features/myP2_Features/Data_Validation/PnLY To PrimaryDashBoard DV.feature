	#Author: sannorj@mydigitaloffice.ca
@myP2_Regression @myP2Sanity @Q1S1Dataval 
 
 Feature: Data Validation Between P&L Yearly To Primary DashBoard
 
  Background: Navigate to P&L Yearly report Func
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "InnVentures Hospitality" 
    And I am expand the P&L Statement option under Reports section in Side Menu
    Then I am navigate to P&L Yearly page
    And I select the group "All groups" , property "CP Lake Oswego" , year "2022" , view "Owner's View"
    And I am Loading the PnLYearly Report with GO button
    Then Page should load the defualt static section
    
    Scenario: Verify whether P&L Yearly static values are matching with Primary DashBoard
    Then Store the Static values for month of March
    And Navigate to the Primary Dashboard Page
    And Select the group,property and Correct Date
    And Store the standard KPI values
    Then Verify whether the P&L Yearly and Primary Dashboard figures are equal
    
    Scenario: Verify whether P&L Yearly OPERATING REVENUE values are matching with Primary DashBoard
	    Then Store the Operating Revenue values for month of March
	    And Navigate to the Primary Dashboard Page
	    And Select the group,property and Correct Date
	    And Store the Operating Revenue KPI values
	    Then Verify whether the P&L Yearly and Primary Dashboard Operating Revenue figures are equal

#	    Scenario: Verify whether P&L Yearly DEPARTMENTAL EXPENSES values are matching with Primary DashBoard
#	    Then Store the Departmental expenses values for month of March
#	    And Navigate to the Primary Dashboard Page
#	    And Select the group,property and Correct Date
#	    And Store the Departmental expenses KPI values
#	    Then Verify whether the P&L Yearly and Primary Dashboard Departmental Expenses figures are equal