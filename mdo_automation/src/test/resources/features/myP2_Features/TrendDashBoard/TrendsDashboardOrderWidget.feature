@myP2_Regression

Feature: Trend Dashboard Order Widgets

Background: Navigate to trend dashboard order widgets
  	Given I am login to the myp2 site
    And System navigate to the home page
    And I am expand the DashBoard section in Side Menu and navigate to trend dashboard
    When I Am navigate to toggle widget page by clicking ToggleWidget Icon
    Then i am changing all the widget state to on 
    
Scenario: verify whether the existing ordered widgets are in correct order
    When I Am navigate to order widget page by clicking OrderWidget Icon
    Then I am storing all the ordered widget
    And verify whether the widgets are in the correct order
 
 Scenario: Re-order widgets and verify whether the widgets are in correct order
    When I Am navigate to order widget page by clicking OrderWidget Icon
    Then I am re-arrange some widgets
    And I am storing all the ordered widget
    And verify whether the widgets are in the correct order   
    