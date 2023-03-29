#Author: haniffa@mydigitaloffice.ca
@myP2_Regression @PrimaryDashBoard

Feature: Primary Dashboard - Reposition the widgets and check the ordering feature

Scenario: Verify the widgets are in the correct order when the user modifies the order form Order widgets on the dashboard page  
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group"
    #And Select the property
    When I Am navigate to toggle widget page by clicking ToggleWidget Icon
    Then I turn on all the widgets
    When I Am navigate to order widget page by clicking OrderWidget Icon
    Then I am getting all the ordered widget
    And I am verify with widgets with the dashboard
    #And I drag and drop the data
    
	
	
	