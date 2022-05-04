Feature: Dashboard Add Column

Background: Navigate to primary dashboard

    Given I am login to the myp2 site
    And System navigate to the home page
    When I select the group "01 West Coast Hotels" , property "Boston Park Plaza" , Date "04/24/2021"

Scenario: Navigate To Add Column 
    Then I am navigate to Add column page
    
    And I pass the Name "GOP Flow Thru Test KPI QA Autoff" , KPI "GOP Flow Thru Test KPI QA 1"
    And I pass the AmountType "Actual" , Period "Last Year"
    And I setup the decimal value "2" and PerfomanceIndicator "On"
    Then I Verify the newly added column
    
Scenario: Navigate To Delete Column 
    And I am navigate to Delete column page "GOP Flow Thru Test KPI QA Autoff"
    Then I click the delete button and verify whether the column is deleted
	
	
	