@myP2_Regression
Feature: Dashboard 

@tgDashboard

Scenario: Navigate to Order Column Page and Verify whether the columns are in order
    Given I am login to the myp2 site
    And System navigate to the home page
    When I select the group "01 West Coast Hotels" , property "Boston Park Plaza" , Date "04/24/2021"
    And I am navigate to order column page
    Then I am storing all the columns
    And I am verifying the ordered columns are in correct order
    