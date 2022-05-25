@myP2_Regression @jenkin1
Feature: Gss By Month - Set Priority Feature
 
  Scenario:  Verify GSS Medallia
    Given I am login to the myp2 site
    And System navigate to the home page
    And I am expand the Guest Satisfaction option under Reports section in Side Menu
    Then I am navigate to GSS Medallia page
    And I am Loading the Medalliah Report with GO button "2022"
    Then I am Assinging the 0 as priority for priority which is equal to 1
    And I am expand the Guest Satisfaction option under Reports section in Side Menu
    Then I am navigate to GSS By Month page
    And Loading the Month Report with GO button
    And I click the SetPriority button "Days Inn & Suites Page Lake Powell"
    Then I set the 1st priority "Overall Score"
    And I am expand the Guest Satisfaction option under Reports section in Side Menu
    Then I am navigate to GSS By Month page
    And I am Validating the priority values "Days Inn & Suites Page Lake Powell"
    And Finally I am Comparing the values
    
    
   

 