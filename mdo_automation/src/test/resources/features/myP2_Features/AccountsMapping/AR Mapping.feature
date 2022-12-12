#Author: madushika@mydigitaloffice.ca
@myP2_Regression @ARFix
Feature: AR Mapping Functionality 

  Background: Navigate to AR Mapping and verify functionality  
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "HighGate Hotels" 
    
  Scenario: Verify the search option functionality
  Then I am expand the Accounts Mapping option under Configuration section in Side Menu
  And I am navigate to AR Mapping page
  When I select the Group and Property then loading AR Mapping report with Go button
	Given Fill an account name in the list to search space and click on go buttton
	And Verify whether the serched option is filtered
	
  Scenario: Verify Single mapping Functionality
  Then I am expand the Accounts Mapping option under Configuration section in Side Menu
  And I am navigate to AR Mapping page
  When I select the Group and Property then loading AR Mapping report with Go button
 	Given I am selecting the unmapped account and map it to selected account
 	And Verify whether the selected account mapped
 	Then Remove mapped account again and verify whether the account removed

 	Scenario: Verify bulk mapping Functionality
  Then I am expand the Accounts Mapping option under Configuration section in Side Menu
  And I am navigate to AR Mapping page
  When I select the Group and Property then loading AR Mapping report with Go button
 	Given I am selecting the few bullet icons to select randome accounts and Click on Bulk Action::Map To button
 	And Select an account then click on save button
 	Then Verify whether the accounts successfully changed
	And Remove mapped account again
	Then Verify whether the removed account is successfully removed	
	
	@myP2_Smoke
  Scenario Outline: Verify AR Mapping page Element visibility and filter functionality
  Given Selects filters as '<filter1>' and '<filter2>' in the initial page
  And Click on the Menu bar
  When Expand the '<Main_menu>' menu 
  Then Expand the '<sub_menu>' menu option
  And Select the '<target_Page>' option
  Given Check the header of the navigated page '<target_Page_header>'
  And Verify Group was selected as '<filter1>' and Property was selected as '<filter2>'
  When Click on the Go button
  Then Verify all the Properties filtered according to selected '<filter2>' Property
  And Verify all check box are loaded
  Given Verify mapping dropdown under the Mapped To header
  And Verify remove Mapping link under the Actions header
  
   Examples: 
       |    filter1       | 	filter2 	|       Main_menu   |  			sub_menu  		|  target_Page  |  	target_Page_header 	|
       |  Highgate - US   | 	24 North 	|  	Configuration 	|  	Accounts Mapping  | 	AR Mapping  |  			AR Mapping 			|
  
		
		
	