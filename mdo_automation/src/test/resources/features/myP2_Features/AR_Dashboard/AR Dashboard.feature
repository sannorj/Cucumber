#Author: haniffa@mydigitaloffice.ca
@myP2_Regression @arFixDashboad

Feature: AR DashBoard - Outstanding validation Functionality 

Background: Navigate to AR Dashboard and verify functionality  
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "Beck Legacy Group" 
  And I am expand the Account Recievable option under Reports section in Side Menu
  Then I am navigate to AR Dashboard page
  
 Scenario: Verify whether the AR Dashboard chart is visible  
 #When I select the group and Date
 And I select the date from picker
 Then I am loading ar report with Go button
 Given I turn on the Show chart
 And Verify whether the chart is visible
	
