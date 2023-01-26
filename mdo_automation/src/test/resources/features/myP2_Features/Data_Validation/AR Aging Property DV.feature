#Author: madushika@mydigitaloffice.ca
@myP2_Regression @myP2_Smoke 
Feature: Report AR Aging Dashboard data validation Functionality 

  Scenario Outline: Navigate to AR Aging Dashboard page and verify page showing the record without a account name functionality
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "InnVest Hotels" 
  Given Selects filters as '<filter1>' and '<nullVal>' in the landing page
  And Click on the Menu bar
  When Expand the '<Main_menu>' menu
  Then Expand the '<sub_menu>' menu option
  And Select the '<target_Page>' option
  Given Check the header of the navigated page '<target_Page_header>'
  And Verify Group was selected as '<nullVal>' and Property was selected as '<filter2>'
  And Select date as '<date>'
  When Click on the Go button
  Then Verify Account name 
  
   Examples: 
       |     filter1     | 	         filter2          	|  Main_menu  |      sub_menu       |       target_Page       |  	target_Page_header  	| nullVal|    date    |  
       | Disposed Hotels | 	314 - Comfort Inn Waterloo 	|  	Reports 	| Accounts Receivable | AR Aging Property (New) | AR Aging Property (New) |  null  | 11/30/2021 | 
       