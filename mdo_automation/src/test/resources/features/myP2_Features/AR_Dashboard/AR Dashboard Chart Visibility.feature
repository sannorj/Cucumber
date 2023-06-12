#Author: pasindu@mydigitaloffice.ca
@myP2_Regression @arDashChartVisibility @pasindu 

Feature: AR Aging Dashboard - Chart Visibility Checking Functionality 

  Background: Navigate to AR Dashboard and verify functionality  
  	Given I am login to the myp2 site
  	And System navigate to the home page
  	And Select the organization as "Insignia Hospitality Group" 
  	And I am expand the Account Recievable option under Reports section in Side Menu
  	Then I am navigate to AR Dashboard page
 		When I select the group Value from the group dropdown section
 		And I select the date from picker
  	Then I am loading ar report with Go button
  
  Scenario: verify the functionality and accuracy of the AR widget in the Primary Dashboard
  	When User checking if a specific column in the AR dashboard report has a total greater than zero
  	Then System navigate to the Primary Dashboard page and verify Primary Dashboard page header
  	And Check group dropdown field and date field on Primary Dashboard page
  	And Validate if the AR widget correctly displays the corresponding charts