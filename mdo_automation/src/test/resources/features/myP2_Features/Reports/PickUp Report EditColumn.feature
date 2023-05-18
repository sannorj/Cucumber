#Author: haniffa@mydigitaloffice.ca
@myP2_Regression @pickupReport

Feature: Pickup report - Edit Column Validation 

    Background: Navigate to pickup report page
  	Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    Then I am expand the pickUp report option under Reports section in Side Menu
    And I am navigate to pickUp report page
    Given I am loading the Pickup report
		Then I am navigate to edit column page
    
    Scenario: Verify whether turned off column are not visible in the table
    And turning on all the columns
    And I am validating with the report columns
    
   Scenario: Verify whether turned on column are visible in the table
    And turning off some of the columns
    And I am validating with the report columns
     
    