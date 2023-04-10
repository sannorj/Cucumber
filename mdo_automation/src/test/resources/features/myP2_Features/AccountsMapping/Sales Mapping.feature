#Author: madushika@mydigitaloffice.ca
@myP2_Regression @salesMap
Feature: Sales Mapping Functionality 
	
  Background: Navigate to Sales Mapping and verify functionality  
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "HighGate Hotels" 
    
  
	
	@myP2_Smoke 
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
       |  01. Highgate - US   | 	24 North 	|  	Configuration 	|  	Accounts Mapping  |  		AR Mapping  		| 	Sales Mapping 	|  			Sales Mapping 		|
  
	