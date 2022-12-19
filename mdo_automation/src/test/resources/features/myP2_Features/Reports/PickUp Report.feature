#Author: haniffa@mydigitaloffice.ca
@myP2_Regression @FinalFix

    Feature: Pickup report - ON THE BOOKS and ACTUAL Date Validation 

    Background: Navigate to pickup report page
  	Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    
    Scenario: Compare and Verify actual data
    Then I am expand the pickUp report option under Reports section in Side Menu
    And I am navigate to pickUp report page
    When I stored all the actual data
    And I compare the dates and verify
     
  @dropdown_validation
  Scenario Outline: Verify Pickup report page Element visibility and filter functionality
	  Given Selects filters as '<filter1>' and '<filter2>' in the initial page
	  And Click on the Menu bar
	  When Expand the '<Main_menu>' menu 
	  Then Expand the '<sub_menu>' menu option
	  Then Expand the '<sub_menu_1>' menu option
	  And Select the '<target_Page>' option
	  Given Check the header of the navigated page '<target_Page_header>'
	  And Verify Group was selected as '<filter1>' and Property was selected as '<filter2>'
	  When Click on the Go button
  
   Examples: 
       |    filter1         |            filter2 								| Main_menu | sub_menu |  sub_menu_1  |     target_Page 		|target_Page_header| nullVal | 
       |  Beck Legacy Group | Days Inn & Suites Page Lake Powell|  Reports	|  Revenue |Pickup Reports| Pickup Report (New) |   Pickup Report  |   null  |
    