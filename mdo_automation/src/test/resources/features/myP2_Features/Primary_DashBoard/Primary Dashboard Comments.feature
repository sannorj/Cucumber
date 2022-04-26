@myP2_Regression
Feature: Primary Dashboard Comments

Background: Login to MYP2 application 
    Given I am login to the myp2 site
    And System navigate to the home page
    And select the Group ,Property and Date 
   
   Scenario: Verify whether the user has the ability to add their first comment
   Given User click on the Add Comments page
   And User fill the all the mandatory fields and click on submit button 
   Then  a newly inserted comment should be visible for the relevant property.