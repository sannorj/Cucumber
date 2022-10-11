#Author: haniffa@mydigitaloffice.ca
@myP2_Regression @FinalFix

    Feature: Pickup report - ON THE BOOKS and ACTUAL Date Validation 

    Background: Navigate to pickup report page
  	Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    Then I am expand the pickUp report option under Reports section in Side Menu
    And I am navigate to pickUp report page
    
    Scenario: Compare and Verify actual data
    When I stored all the actual data
    And I compare the dates and verify
     
    