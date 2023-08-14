#Author: haniffa@mydigitaloffice.ca
@myP2_Regression @RBD

Feature: Verify Revenue Breakdown Initial Load

  Scenario: Navigate to Revenue Breakdown report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "HighGate Hotels" 
    And I am expand the Revenue Breakdwon option under Reports section in Side Menu
    Then I am navigate to Revenue Breakdown page
    And I am Loading the Revenue Breakdown Report with GO button
    
  @myP2_Smoke
  Scenario Outline: Verify Revenue Breakdown report page Element visibility and filter functionality
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
	  Given Selects filters as '<filter1>' and '<filter2>' in the initial page
	  And Click on the Menu bar
	  When Expand the '<Main_menu>' menu 
	  Then Expand the '<sub_menu>' menu option
	  And Select the '<target_Page>' option
	  Given Check the header of the navigated page '<target_Page_header>'
	  And Verify Group was selected as '<nullVal>' and Property was selected as '<filter2>'
  
   Examples: 
       |    filter1         |            filter2 								| Main_menu | sub_menu |           target_Page  		    |    target_Page_header    | nullVal | 
       |  Beck Legacy Group | Days Inn & Suites Page Lake Powell|  Reports	|  Revenue | Revenue Breakdown Report (New) | Revenue Breakdown Report |   null  |
    
    
   