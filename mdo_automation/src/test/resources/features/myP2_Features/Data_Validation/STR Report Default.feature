#Author: madushika@mydigitaloffice.ca
@myP2_Regression @myP2_Smoke @StrReport
Feature: STR Report data validation Functionality 

  Scenario Outline: Verify STR Report Page data change according to selected options and tabs in data validation functionality
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "HighGate Hotels" 
  Given Selects filters as '<filter1>' and '<filter2>' in the landing page
  And Click on the Menu bar
  When Expand the '<Main_menu>' menu
  Then Expand the '<sub_menu>' menu option
  Then Expand the '<sub_menu_1>' menu option
  And Select the '<target_Page>' option
  Given Check the header of the navigated page '<target_Page_header>'
  And Verify Group was selected as '<nullVal>' and Property was selected as '<filter2>'
  And Select date as '<date>'
  Then Click on '<F_week>' button
  When Click on the Go button
  When Store first cell value
  Then Click on '<FT_week>' button
  And Comapre with previous cell value
  Given Select Group as '<nullVal>' and Property as '<filter3>'
  And Select date as '<date2>'
  Then Click on '<F_week>' button
  And Comapre new property values with previous property value
  
   Examples: 
       |    filter1       | 	filter2 	|  Main_menu  | sub_menu  | sub_menu_1|       target_Page        |  	 target_Page_header 	| nullVal|    date    | F_week | FT_week |   filter3   |    date2   |
       |  Highgate - US   | 	24 North 	|  	Reports 	|  Revenue  |  	 STR    | STR Report Default (New) | STR Report Default (New) |  null  | 08/22/2021 | 4 Week | 52 Week | Aloft Tulum | 12/21/2021 |
       