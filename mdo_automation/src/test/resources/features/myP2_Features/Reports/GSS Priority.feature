@myP2_Regression @faliureSmoke
Feature: Verify GSS Priority Functionality

  Scenario: Verify GSS Medallia
    Given I am login to the myp2 site
    And System navigate to the home page
    And I am expand the Guest Satisfaction option under Reports section in Side Menu
    Then I am navigate to GSS Medallia page
    And I am Loading the Medalliah Report with GO button
    Then I am Assinging the 0 as priority for all the priority dropDown 
    And I am expand the Guest Satisfaction option under Reports section in Side Menu
    Then I am navigate to GSS Priority page
    And I select the group,period, quantity
    Then I am Loading the Priority Report with GO button
    And I am navigate medallia page to set priority
    Then I am search for group and assign priotiy 1
    And I am expand the Guest Satisfaction option under Reports section in Side Menu
    Then I am navigate to GSS Priority page
    And I select the group,period, quantity and Property
    Then I am Loading the Priority Report with GO button
    And I am Calculating values
    Then I am Comparing values