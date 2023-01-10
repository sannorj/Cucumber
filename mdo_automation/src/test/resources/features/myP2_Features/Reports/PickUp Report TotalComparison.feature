#Author: pasindu@mydigitaloffice.ca
@myP2_Regression

Feature: Pickup report - Total values comparison 

    Background: Navigate to pickup report page
  	Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Insignia Hospitality Group" 
    Then I am expand the pickUp report option under Reports section in Side Menu
    And I am navigate to pickUp report page
    
    Scenario: Check OTB Total records equal to Grand Total records
		Given I am loading the Pickup report page with specific dates
		Then I am saving the OTB total raw values to the new array
    And I am saving the Grand total raw values to the new array
    And I am comparing the two arrays
    
    Scenario: Check the mean value of the corresponding element of the actual total and OTB total arrays and check with corresponding element of the grand total array 
		Given I am loading the Pickup report page with second specific dates
		Then I am saving the Actual total raw values to the new array
		And I am saving the OTB total raw values to the new array
    And I am saving the Grand total raw values to the new array
    And I am Checking the mean value of the corresponding element of the actual total and OTB total arrays
    And I am comparing the meanArray with grand total array
     
    