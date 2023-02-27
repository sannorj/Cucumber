#Author: haniffa@mydigitaloffice.ca 
@myP2_Regression1 @DashBoard
Feature: Primary Dashboard - Toggle Widgets

	Scenario: Verify whether turned off widgets are not exist in the dashboard 
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group"
    When I Am navigate to toggle widget page by clicking ToggleWidget Icon
    Then I turn on all the widgets 
    And verify whthere all the widgets are available
		And I Am navigate to toggle widget page by clicking ToggleWidget Icon
		Then I search for "Occupancy" , "Revenue Breakdown ($)" , "Room Revenue (Actual vs Budget vs Last Year)" and turned off
		And Verify whethere turned of widgets are not visible in the dashboard
	
	
	