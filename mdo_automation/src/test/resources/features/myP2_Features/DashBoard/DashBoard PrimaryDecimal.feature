#Author: haniffa@mydigitaloffice.ca 
@myP2_Regression 
Feature: Primary Dashboard - Custom Decimal Places Features

Scenario: Verify whether user can able to set the custom decimal places in primary dashboard
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "HighGate Hotels" 
    When I select the group,property and Date
    And I click the edit column icon "3"
    Then I click the Setting icon on Rooms Available
    And I am assigning decimal values "2"
    And I click the Setting icon on Rooms Revenue
    Then I am Overriding the Primary decimal values
		Then I am storing the Room Availble and Rooms Revenue Values
		And I am comparing decimal values    

		
 
