#Author: sannorj@mydigitaloffice.ca
@myP2_Regression @myP2_Smoke

Feature: Income Journal Summary  - Add New Row Feature

	Background: Navigate to Income Journal Summary
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group"

  Scenario: Verify whether user can Add Row in Income Journal Summary  
    And In the Side Menu, expand the IJ section.
    And Navigate to the Income Journal Summary
    And Select the Property , Period , Date and Click on GO button
    When User clicks Add icon in to left coner on ij summary page 
    And User fills up all required fields and click on save button. 
    Then The newly added Income Journal Summary  should be visible on the home page. 
   
  @dropdown_validation
  Scenario Outline: Verify Summary page Element visibility and filter functionality
	  Given Selects filters as '<filter1>' and '<filter2>' in the initial page
	  And Click on the Menu bar
	  When Expand the '<Main_menu_1>' menu 
	  Then Expand the '<sub_menu_1>' menu option
	  And Select the '<target_Page_1>' option
	  And Click on the Menu bar
	  When Expand the '<Main_menu>' menu 
	  And Select the '<target_Page>' option
	  Given Check the header of the navigated page '<target_Page_header>'
	  And Verify Group was selected as '<nullVal>' and Property was selected as '<filter2>'
  
   Examples: 
       |    filter1         |            filter2 								|    Main_menu   | target_Page  |target_Page_header|  nullVal |  Main_menu_1  |  	 sub_menu_1    |  target_Page_1 |
       |  Beck Legacy Group | Days Inn & Suites Page Lake Powell| Income Journal | Summary (New)|   Summary (New)  |   null 	| Configuration | Accounts Mapping | 	 AR Mapping   |
	
		   
