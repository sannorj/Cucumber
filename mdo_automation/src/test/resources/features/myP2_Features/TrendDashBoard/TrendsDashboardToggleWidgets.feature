@myP2_Regression

Feature: Trend Dashboard Toggle Widgets

Background: Navigate to trend dashboard toggle widgets
  	Given I am login to the myp2 site
    And System navigate to the home page
    And I am expand the DashBoard section in Side Menu and navigate to trend dashboard
    When I Am navigate to toggle widget page by clicking ToggleWidget Icon
    
Scenario: Verify whether the existing widgets are in order

    Then i am changing all the widget state to on 
    And I am comparing all the available widgets are in correct order
    
Scenario: Turned off some widgets and verify whether visibility of widgets    
    
    Then I turned off Some widgets
    And Verifying the visibility of widgets on dashboard
	
	
	