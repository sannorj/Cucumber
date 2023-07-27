#Author: haniffa@mydigitaloffice.ca
@myP2_Regression

Feature: AR Aging Property - Chart Slot Validation

  Background: Navigate to AR Dashboard and verify functionality  
  	Given I am login to the myp2 site
  	And System navigate to the home page
  	And Select the organization as "Beck Legacy Group" 
  	And I am expand the Account Recievable option under Reports section in Side Menu
  	Then I am navigate to AR Property page
    When I select the property and Date
    And I select the date from picker
    Then I am loading ar property report with Go button
      
  Scenario: Verify whether the AR Dashboard Graph Values are in Correct Order	
 		Given I turn on the Show chart
 		And Verify whether the chart is visible
 		Then Capture and Verify whether the Graph chart got all the values
  
 	Scenario: Verify whether the AR Dashboard Distibution Time Slot are Available	
 		Given I turn on the Show chart
 		And Verify whether the chart is visible
 		Then Capture and Verify whether the distribution chart got all the values
 		
 	Scenario: Verify whether the Distribution Percentage and Graph Percentage values are matching
 		Given I turn on the Show chart
 		And Verify whether the chart is visible
 		When I Capture and store distribution values
 		Then I Capture and store graph values
 		And I Sort and Compare both Graph and Distribution values
