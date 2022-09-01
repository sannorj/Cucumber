#Author: madushika@mydigitaloffice.ca
@myP2_Regression @ARFix
Feature: AR Mapping Functionality 

  Background: Navigate to AR Mapping and verify functionality  
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "Beck Legacy Group" 
  Then I am expand the Accounts Mapping option under Configuration section in Side Menu
  And I am navigate to AR Mapping page
  When I select the Group and Property then loading AR Mapping report with Go button
  
  Scenario: Verify the search option functionality
	Given Fill an account name in the list to search space and click on go buttton
	And Verify whether the serched option is filtered
	
  Scenario: Verify Single mapping Functionality
 	Given I am selecting the unmapped account and map it to selected account
 	And Verify whether the selected account mapped
 	Then Remove mapped account again and verify whether the account removed
	
 Scenario: Verify bulk mapping Functionality
 	Given I am selecting the few bullet icons to select randome accounts and Click on Bulk Action::Map To button
 	And Select an account then click on save button
 	Then Verify whether the accounts successfully changed
	And Remove mapped account again
	Then Verify whether the removed account is successfully removed	
	