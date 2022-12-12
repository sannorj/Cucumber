#Author: haniffa@mydigitaloffice.ca
@myP2_Regression

Feature: Trend Dashboard Order Widgets Functionality Validation

Background: Navigate to trend dashboard order widgets
  	Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group"
    
	Scenario: verify whether the existing ordered widgets are in correct order
    And I am expand the DashBoard section in Side Menu and navigate to trend dashboard
    When I Am navigate to toggle widget page by clicking ToggleWidget Icon
    Then i am changing all the widget state to on 
    When I Am navigate to order widget page by clicking OrderWidget Icon
    Then I am storing all the ordered widget
    And verify whether the widgets are in the correct order
 
 	Scenario: Re-order widgets and verify whether the widgets are in correct order
    And I am expand the DashBoard section in Side Menu and navigate to trend dashboard
    When I Am navigate to toggle widget page by clicking ToggleWidget Icon
    Then i am changing all the widget state to on 
    When I Am navigate to order widget page by clicking OrderWidget Icon
    Then I am re-arrange some widgets
    And I am storing all the ordered widget
    And verify whether the widgets are in the correct order   
    
	@myP2_Smoke
  Scenario Outline: Verify Trends Dashboard page Element visibility and filter functionality
	  Given Selects filters as '<filter1>' and '<filter2>' in the initial page
	  And Click on the Menu bar
	  When Expand the '<Main_menu_1>' menu 
	  Then Expand the '<sub_menu_1>' menu option
	  And Select the '<target_Page_1>' option
	  And Click on the Menu bar
	  When Expand the '<Main_menu>' menu 
	  And Select the '<target_Page>' option
	  Given Check the header of the navigated page '<target_Page_header>'
	  And Verify Group was selected as '<filter1>' and Property was selected as '<filter2>'
  
   Examples: 
       |    filter1         | filter2 													| Main_menu |      target_Page  		 |     target_Page_header 			| nullVal |  Main_menu_1  |  	 sub_menu_1    |  target_Page_1 |
       |  Beck Legacy Group | Days Inn & Suites Page Lake Powell| Dashboard | Trends Dashboard (New) |  Trends Dashboard (New)| null		| Configuration | Accounts Mapping | 	 AR Mapping   |
       