#Author: madushika@mydigitaloffice.ca
@myP2_Regression @ARFix
Feature: AR Mapping Functionality 

  Background: Navigate to AR Mapping and verify functionality  
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "HighGate Hotels" 
    
  @myP2_Regression @ARFix
  Scenario: Verify the search option functionality
  Then I am expand the Accounts Mapping option under Configuration section in Side Menu
  And I am navigate to AR Mapping page
  When I select the Group and Property then loading AR Mapping report with Go button
	Given Fill an account name in the list to search space and click on go buttton
	And Verify whether the serched option is filtered
	
	@myP2_Regression @ARFix
  Scenario: Verify Single mapping Functionality
  Then I am expand the Accounts Mapping option under Configuration section in Side Menu
  And I am navigate to AR Mapping page
  When I select the Group and Property then loading AR Mapping report with Go button
 	Given I am selecting the unmapped account and map it to selected account
 	And Verify whether the selected account mapped
 	Then Remove mapped account again and verify whether the account removed

  @myP2_Regression @ARFix
 	Scenario: Verify bulk mapping Functionality
  Then I am expand the Accounts Mapping option under Configuration section in Side Menu
  And I am navigate to AR Mapping page
  When I select the Group and Property then loading AR Mapping report with Go button
 	Given I am selecting the few bullet icons to select randome accounts and Click on Bulk Action::Map To button
 	And Select an account then click on save button
 	Then Verify whether the accounts successfully changed
	And Remove mapped account again
	Then Verify whether the removed account is successfully removed	

	@dropdown_smoke @myP2_Smoke
  Scenario: Verify AR & Sales Mapping pages - Element visible additional validation functionality
  Given Select Group as "Highgate - US" and Property as "24 North" 
  And Click on Menu bar
  When Expand "Configuration" menu 
  Then Expand "Accounts Mapping" menu option
  And Select "AR Mapping" option
  Given Verify navigate to "AR Mapping" Page
  And Verify Group selected as "Highgate - US" and Property already selected as "24 North" 
  When Click on "Go" button
  Then Verify all the Properties filtered according to selected "24 North" Property
  And Verify all check box are loaded
  
		
		
	