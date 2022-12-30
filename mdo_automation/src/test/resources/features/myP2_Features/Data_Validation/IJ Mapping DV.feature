#Author: madushika@mydigitaloffice.ca
@myP2_Regression @myP2_Smoke @DV
Feature: Report Income Journal Mapping data validation Functionality 

  Scenario Outline: Navigate to Income Journal Mapping page and data validation functionality
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "HighGate Hotels" 
  Given Selects filters as '<filter1>' and '<filter2>' in the landing page
  And Click on the Menu bar
  When Expand the '<Main_menu>' menu
  And Select the '<target_Page>' option
  Given Check the header of the navigated page '<target_Page_header>'
  And Verify Group was selected as '<nullVal>' and Property was selected as '<filter2>'
  And Select date as '<date>'
  When Click on the Go button
  Then Click on '<mapping>' button
  When Store first cell value
  Then Click on '<summary>' button
  And Verify data not loaded
  Then Click on '<reconciliation>' button
  And Verify data not loaded
  Given Select Group as '<nullVal>' and Property as '<filter2>'
  And Select date as '<date2>'
  Then Click on '<mapping>' button
  And Verify data not loaded
  Then Click on '<summary>' button
  And Verify data not loaded
  Then Click on '<reconciliation>' button
  And Verify data not loaded
  
   Examples: 
       |     filter1       | 	filter2 	|    Main_menu   |   target_Page  | target_Page_header | nullVal|    date    | mapping | summary | reconciliation |     filter3     |    date2   |
       | 01. Highgate - US | 	24 North 	| Income Journal |  Mapping (New) |    Mapping (New)   |  null  | 08/22/2021 | Mapping | Summary | Reconciliation |  Colony Service | 12/21/2021 |