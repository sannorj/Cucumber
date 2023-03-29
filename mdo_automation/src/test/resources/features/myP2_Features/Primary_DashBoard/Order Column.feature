#Author: haniffa@mydigitaloffice.ca
@myP2_Regression @PrimaryDashBoard

   Feature: Primary Dashboard - Change the position of the columns in the By property table and check the sorting functionality

	 Background: Navigate to Order Column Page 
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group"
    When I select the group,property and Date
    And I am navigate to order column page
    
    Scenario: Make sure the order of the columns in the By Property table matches the Order Columns page
    When I am storing all the columns
    And I am verifying the ordered columns are in correct order
    