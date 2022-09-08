#Author: sannorj@mydigitaloffice.ca
@myP2_Regression  @arFix
Feature: AR Account - Outstanding validation Functionality 

  Background: Navigate to AR Account and verify functionality  
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "Beck Legacy Group" 
  And I am expand the Account Recievable option under Reports section in Side Menu
  Then I am navigate to AR Account page
  When I select the Account and Date
  Then I am loading ar Account report with Go button
  
  Scenario: Verify whether the AR Account chart is visible
	Given I turn on the Show chart
	And Verify whether the chart is visible
	
  Scenario: Verify whether the AR Account ShowAtRisk Outstanding RED Functionality
 	Given I am storing all the account values
 	And I am sorting all the account values
 	Then I turn on the Show at risk
	And Verify whether the AR account RED Outstanding values are correctly highlighted
	
 Scenario: Verify whether the AR Account ShowAtRisk Outstanding Yellow Functionality
 	Given I am storing all the account values
 	And I am sorting all the account values
 	Then I turn on the Show at risk
	And Verify whether the AR account Yellow Outstanding values are correctly highlighted