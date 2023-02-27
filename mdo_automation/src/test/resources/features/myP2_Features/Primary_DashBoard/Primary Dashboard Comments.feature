#Author: sannorj@mydigitaloffice.ca
@myP2_Regression @comments

Feature: Primary Dashboard - Comments Feature

Background: Login to MYP2 application 
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "Beck Legacy Group" 
  And select the Group ,Property and Date 
   
  Scenario: Verify whether the user has the ability to add their first comment
  	Given User click on the Add Comments page
  	And User fill the all the mandatory fields and click on submit button 
  	Then Newly inserted comment should be visible for the relevant property.