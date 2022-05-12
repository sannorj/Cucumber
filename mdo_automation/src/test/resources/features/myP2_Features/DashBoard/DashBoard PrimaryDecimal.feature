@myP2_Regression
Feature: Primary Dashboard 

Scenario: Navigate to P&L report Func
    Given I am login to the myp2 site
    And System navigate to the home page
    When I select the group "01 West Coast Hotels" , property "Boston Park Plaza" , Date "04/24/2021"
    And I click the edit column icon "3"
    Then I click the Setting icon on Rooms Available
    And I am assigning decimal values "2"
    And I click the Setting icon on Rooms Revenue
    Then I am Overriding the Primary decimal values
		Then I am storing the Room Availble and Rooms Revenue Values
		And I am comparing decimal values    

		
 
