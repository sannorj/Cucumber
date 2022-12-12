#Author: madushika@mydigitaloffice.ca
@myP2_Regression @salesMp1
Feature: Sales Mapping Functionality 
	
  Background: Navigate to Sales Mapping and verify functionality  
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "HighGate Hotels" 
    
  Scenario: Verify the search option functionality in Sales Page
  Then I am expand the Accounts Mapping option under Configuration section in Side Menu
  And I am navigate to Sales Mapping page through the AR Mapping page
  When I select the Group and Property then loading Sales Mapping report with Go button
	Given Fill an account name in the list to search space and click on go buttton in SalesMapping
	And Verify whether the serched option is filtered in SalesMapping

  Scenario: Verify SalesMapping Single mapping Functionality
  Then I am expand the Accounts Mapping option under Configuration section in Side Menu
  And I am navigate to Sales Mapping page through the AR Mapping page
  When I select the Group and Property then loading Sales Mapping report with Go button
 	Given I am selecting the unmapped account and map it to selected account in SalesMapping
 	And Verify whether the selected account mapped in SalesMapping
 	Then Remove mapped account again and verify whether the account removed in SalesMapping
	
  Scenario: Verify Sales bulk mapping Functionality
  Then I am expand the Accounts Mapping option under Configuration section in Side Menu
  And I am navigate to Sales Mapping page through the AR Mapping page
  When I select the Group and Property then loading Sales Mapping report with Go button
 	Given I am selecting the few bullet icons in salesMapping to select randome accounts and Click on Bulk Action::Map To button
 	And Select an salesMapping account then click on save button
 	Then Verify whether the MappedTo accounts successfully changed
	And Remove mappedTo accounts again
	Then Verify whether the removed accounts successfully removed
	
	Scenario: Verify Sales Manager and Management Status change functionality
  Then I am expand the Accounts Mapping option under Configuration section in Side Menu
  And I am navigate to Sales Mapping page through the AR Mapping page
  When I select the Group and Property then loading Sales Mapping report with Go button
	Given I am selecting a Sales Manager option and Verify successfully changed
	And Remove selected Sales Manager and Verify successfully removed
	Then I am selecting a Management Status option and Verify successfully changed
	When Remove selected Management Status and Verify successfully removed
	
	@myP2_Smoke @dropdown_validation
	Scenario Outline: Verify Sales Mapping page Element visibility and filter functionality
  Given Selects filters as '<filter1>' and '<filter2>' in the initial page
  And Click on the Menu bar
  When Expand the '<Main_menu>' menu 
  Then Expand the '<sub_menu>' menu option
  Given Select the '<second_sub_menu>' menu option
  And Navigate to '<target_Page>' page
  Given Check the header of the navigated page '<target_Page_header>'
  And Verify Group was selected as '<filter1>' and Property was selected as '<filter2>'
  When Click on the Go button
  Then Verify all the Properties filtered according to selected '<filter2>' Property
  And Verify all check box are loaded
  Given Verify mapping dropdown under the Mapped To header
  And Verify remove Mapping link under the Actions header
  When Verify manager dropdown under the Sales Manager header
  Then Verify managed dropdown under the Managed header
  
   Examples: 
       |    filter1       | 	filter2 	|       Main_menu   |  			sub_menu  		|  	second_sub_menu  	|  	target_Page  		|  	target_Page_header 		|
       |  Highgate - US   | 	24 North 	|  	Configuration 	|  	Accounts Mapping  |  		AR Mapping  		| 	Sales Mapping 	|  			Sales Mapping 		|
  
	