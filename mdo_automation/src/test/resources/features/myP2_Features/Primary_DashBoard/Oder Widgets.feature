@myP2_Regression @JenkinTest
Feature: Primary Dashboard - Re arrange the widgets and verify

Scenario: Verify whether Ordered Widgets are in the correct order
    Given I am login to the myp2 site
    And System navigate to the home page
    When I Am navigate to toggle widget page by clicking ToggleWidget Icon
    Then I turn on all the widgets
    When I Am navigate to order widget page by clicking OrderWidget Icon
    Then I am getting all the ordered widget
    And I am verify with widgets with the dashboard
    #And I drag and drop the data
    
	
	
	