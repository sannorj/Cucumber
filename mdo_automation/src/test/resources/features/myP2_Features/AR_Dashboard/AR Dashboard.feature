#Author: haniffa@mydigitaloffice.ca
@myP2_Regression @Q1S1ARDashboard

Feature: AR Aging Dashboard - Outstanding validation Functionality 

  Background: Navigate to AR Dashboard and verify functionality  
  	Given I am login to the myp2 site
  	And System navigate to the home page
  	And Select the organization as "Beck Legacy Group" 
  
  Scenario: Verify whether the AR Dashboard chart is visible  
  	And I am expand the Account Recievable option under Reports section in Side Menu
  	Then I am navigate to AR Dashboard page
 		When I select the group and Date
 		And I select the date from picker
  	Then I am loading ar report with Go button
 		Given I turn on the Show chart
 		And Verify whether the chart is visible
 		
 	Scenario: Verify whether the AR Dashboard ShowAtRisk Outstanding RED Functionality
  	And I am expand the Account Recievable option under Reports section in Side Menu
  	Then I am navigate to AR Dashboard page
  	When I select the group and Date
  	And I select the date from picker
    Then I am loading ar report with Go button
 	  Given I am storing all the values
 	  And I am sorting all the values
 	  Then I turn on the Show at risk
	  And Verify whether the RED Outstanding values are correctly highlighted

	Scenario: Verify whether the AR Dashboard ShowAtRisk Outstanding YELLOW Functionality
  	And I am expand the Account Recievable option under Reports section in Side Menu
  	Then I am navigate to AR Dashboard page
	  When I select the group and Date
	  And I select the date from picker
    Then I am loading ar report with Go button
 	  Given I am storing all the values
 	  And I am sorting all the values
 	  Then I turn on the Show at risk
	  And Verify whether the YELLOW Outstanding values are correctly highlighted
	  
	@myP2_Smoke 
  Scenario Outline: Verify AR Dashboard page Element visibility and filter functionality
	  Given Selects filters as '<filter1>' and '<filter2>' in the initial page
	  And Click on the Menu bar
	  When Expand the '<Main_menu>' menu 
	  Then Expand the '<sub_menu>' menu option
	  And Select the '<target_Page>' option
	  Given Check the header of the navigated page '<target_Page_header>'
	  And Verify Group was selected as '<filter1>' and Property was selected as '<nullVal>'
	  When Click on the Go button
  
   Examples: 
       |    filter1         | filter2 													| Main_menu |   sub_menu  			 |   target_Page  					| target_Page_header 			| nullVal |
       |  Beck Legacy Group | Days Inn & Suites Page Lake Powell| Reports 	| Accounts Receivable| 	AR Aging Dashboard (New)| AR Aging Dashboard (New)| null		|
	