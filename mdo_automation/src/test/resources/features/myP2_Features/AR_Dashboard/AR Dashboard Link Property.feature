#Author: pasindu@mydigitaloffice.ca
@myP2_Regression @arDashboardLinkProp @pasindu

Feature: AR Aging Dashboard - Outstanding validation Functionality 

  Background: Navigate to AR Dashboard and verify functionality  
  	Given I am login to the myp2 site
  	And System navigate to the home page
  	And Select the organization as "Insignia Hospitality Group" 
  	And I am expand the Account Recievable option under Reports section in Side Menu
  	Then I am navigate to AR Dashboard page
 		When I select the group Value from the group dropdown section
 		And I select the date from picker
  	Then I am loading ar report with Go button
  
  Scenario: Matching the values of the column on AR property page by clicking the property link button on the AR dashboard page
  	When user click on the CNMTS Property hyper-link action on AR dashboard table 
  	Then user verify AR Property page header
  	And Check Property dropdown field and date field on AR Property page
  	And Observe the column values for a specific Property and save it in to the array
  	And User click GO button
		And Observe the column values for the second time and save it in to the new array
		And User compares the two arrays to check whether they are equal