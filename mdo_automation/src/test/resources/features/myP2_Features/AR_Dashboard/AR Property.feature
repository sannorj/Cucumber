#Author: haniffa@mydigitaloffice.ca
@myP2_Regression @arPropertySmoke

  Feature: AR Property - Outstanding valiadtion Functionality 

  Background: Navigate to AR Property and verify functionality  
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "Beck Legacy Group" 
  And I am expand the Account Recievable option under Reports section in Side Menu
  Then I am navigate to AR Property page
  When I select the property and Date
  And I select the date from picker
  Then I am loading ar property report with Go button
  
  Scenario: Verify whether the AR Account chart is visible  
	Given I turn on the Show chart
	And Verify whether the chart is visible
	
  Scenario: Verify whether the AR Property ShowAtRisk Outstanding RED Functionality
 	Given I am storing all the property values
 	And I am sorting all the property values
 	Then I turn on the Show at risk
	And Verify whether the AR Property RED Outstanding values are correctly highlighted	
	
  Scenario: Verify whether the AR Property ShowAtRisk Outstanding YELLOW Functionality
 	Given I am storing all the property values
 	And I am sorting all the property values
 	Then I turn on the Show at risk
	And Verify whether the AR Property YELLOW Outstanding values are correctly highlighted	
	
