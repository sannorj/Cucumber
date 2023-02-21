#Author: sannorj@mydigitaloffice.ca
@myP2_Regression1  @sannorj

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
   
  Scenario: Verify whether the user can able to reply the comments from the All comments page
  	When Users click “All Replies” for a specific thread, they are redirected to a page where they see all the replies to that thread.
  	And User will be able to reply back to the thread
  	Then The newly added comments should be added to the appropriate username and property
   
  Scenario: Verify whether the User will be able to activate/deactivate a comment thread
  	When Users click “All Replies” for a specific thread, they are redirected to a page where they see all the replies to that thread.
  	And User clicks the resolve option
  	Then Resolved comments should be moved from the active list to the Resolved Comments section.
  	And  User clicks the Active option
  	Then Activated comments should be moved from the Resolved list to the active Comments section.