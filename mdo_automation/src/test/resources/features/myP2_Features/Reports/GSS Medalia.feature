#Author: haniffa@mydigitaloffice.ca
@myP2_Regression

   Feature: Verify GSS Medalia Functionality

  Scenario: Verify GSS Medallia
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    And I am expand the Guest Satisfaction option under Reports section in Side Menu
    Then I am navigate to GSS Medallia page
    And I am Loading the Medalliah Report with GO button
    Then I am Assinging the 0 as priority for all the priority dropDown
    And Assinging all the priority values by searching property one by one
    
    Scenario: Verify GSS Medallia Priority
    Given I am login to the myp2 site
    And System navigate to the home page
    And I am expand the Guest Satisfaction option under Reports section in Side Menu
    Then I am navigate to GSS Medallia page
    And I am Loading the Medalliah Report with GO button
    And I am Assinging the existing priority value for the priority dropDown
    
   