#Author: haniffa@mydigitaloffice.ca
@myP2_Regression1 
Feature: Primary Dashboard - Add Column Feature

	Background: Navigate to primary dashboard
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group"
    When I select the group,property and Date

	Scenario: Navigate To Add Column 
    Then I am navigate to Add column page
    And I pass the Name and KPI
    And I pass the AmountType and Period
    And I setup the decimal value and PerfomanceIndicator
    Then I Verify the newly added column
    
	Scenario: Navigate To Delete Column 
    And I am navigate to Delete column page
    Then I click the delete button and verify whether the column is deleted
	
	
	