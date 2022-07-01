#Author: haniffa@mydigitaloffice.ca
@myP2_Regression

Feature: AR DashBoard Functionality 

Background: Navigate to AR Dashboard and verify functionality  
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "Beck Legacy Group" 
  And I am expand the Account Recievable option under Reports section in Side Menu
  Then I am navigate to AR Dashboard page
  When I select the group and Date
  Then I am loading ar report with Go button
  
 Scenario: Verify whether the AR Dashboard chart is visible  
	Given I turn on the Show chart
	And Verify whether the chart is visible
	
 Scenario: Verify whether the AR Dashboard ShowAtRisk Outstanding RED Functionality
 	Given I am storing all the values
 	And I am sorting all the values
 	Then I turn on the Show at risk
	And Verify whether the RED Outstanding values are correctly highlighted

	Scenario: Verify whether the AR Dashboard ShowAtRisk Outstanding YELLOW Functionality
 	Given I am storing all the values
 	And I am sorting all the values
 	Then I turn on the Show at risk
	And Verify whether the YELLOW Outstanding values are correctly highlighted