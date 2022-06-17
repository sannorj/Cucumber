@myP2_Regression

Feature: Pickup report - Edit Column Validation 

Background: Navigate to pickup report page
  	Given I am login to the myp2 site
    And System navigate to the home page
    Then I am expand the pickUp report option under Reports section in Side Menu
    And I am navigate to pickUp report page
    
Scenario: Verify whether turned off column are not visible in the table

		Given I am loading the Pickup report
		Then I am navigate to edit column page
    And turning on all the columns
    And I am validating with the report column
    
Scenario: Verify whether turned on column are visible in the table

		Given I am loading the Pickup report
		Then I am navigate to edit column page
    And turning off some of the columns
    And I am validating with the report column    
     
    