#Author: madushika@mydigitaloffice.ca
@myP2_Regression 
Feature: Sales Mapping Functionality 

  Background: Navigate to Sales Mapping and verify functionality  
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "Beck Legacy Group" 
  Then I am expand the Accounts Mapping option under Configuration section in Side Menu
  And I am navigate to Sales Mapping page through the AR Mapping page
  When I select the Group and Property then loading Sales Mapping report with Go button
  
  Scenario: Verify the search option functionality in Sales Page
	Given Fill an account name in the list to search space and click on go buttton in SalesMapping
	And Verify whether the serched option is filtered in SalesMapping

  Scenario: Verify SalesMapping Single mapping Functionality
 	Given I am selecting the unmapped account and map it to selected account in SalesMapping
 	And Verify whether the selected account mapped in SalesMapping
 	Then Remove mapped account again and verify whether the account removed in SalesMapping
	
  Scenario: Verify Sales bulk mapping Functionality
 	Given I am selecting the few bullet icons in salesMapping to select randome accounts and Click on Bulk Action::Map To button
 	And Select an salesMapping account then click on save button
 	Then Verify whether the MappedTo accounts successfully changed
	And Remove mappedTo accounts again
	Then Verify whether the removed accounts successfully removed	

	Scenario: Verify Sales Manager and Management Status change functionality
	Given I am selecting a Sales Manager option and Verify successfully changed
	And Remove selected Sales Manager and Verify successfully removed
	Then I am selecting a Management Status option and Verify successfully changed
	When Remove selected Management Status and Verify successfully removed
	
	
