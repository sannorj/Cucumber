#Author: madushika@mydigitaloffice.ca
@myP2_Regression @myP2_Smoke
Feature: Report 306090 data validation Functionality 

  Scenario Outline: Navigate to 306090 Report page and data validation functionality
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "HighGate Hotels" 
  Given Selects filters as '<filter1>' and '<filter2>' in the landing page
  And Click on the Menu bar
  When Expand the '<Main_menu>' menu
  Then Expand the '<sub_menu>' menu option
  And Select the '<target_Page>' option
  Given Check the header of the navigated page '<target_Page_header>'
  And Verify Group was selected as '<filter1>' and Property was selected as '<nullVal>'
  And Select date as '<date>'
  When Click on the Go button
  Then Click on '<R_month>' button
  When Store first cell value
  Then Click on '<C_month>' button
  And Verify data not loaded
  Given Select Group as '<filter1>' and Property as '<nullVal>'
  And Select date as '<date2>'
  Then Click on '<R_month>' button
  And Verify data not loaded
  
   Examples: 
       |     filter1       | 	filter2 	|  Main_menu  | sub_menu  |     target_Page        |  	    target_Page_header     | nullVal|    date    |    R_month    |     C_month    |     filter3     |    date2   |
       | 01. Highgate - US | 	24 North 	|  	Reports 	|  Revenue  |  30/60/90 Report (New) | 30/60/90 Rolling Month Report |  null  | 08/22/2021 | Rolling Month | Calendar Month |  Colony Service | 12/21/2021 |