#Author: haniffa@mydigitaloffice.ca
@myP2_Regression @DashBoard

   Feature: Primary Dashboard - Order column feature  

	 Background: Navigate to Order Column Page 
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group"
    When I select the group,property and Date
    And I am navigate to order column page
    
    Scenario: Verify whether the columns are in order
    When I am storing all the columns
    And I am verifying the ordered columns are in correct order
    