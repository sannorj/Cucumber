#Author: haniffa@mydigitaloffice.ca 
@myP2_Regression 
Feature: Primary Dashboard - Automate Group and Property validation feature

	Background: Navigate to primary dashboard
    Given I am login to the myp2 site
    And System navigate to the home page
    
  Scenario: Storing and verifying dropdown values for InnVentures Hospitality
		Given Select the organization as "InnVentures Hospitality"
  	And I click the edit column icon
    When I am storing group and property dropdown values
    Then I am storing dashboard grid values
    And I am comparing stored groups and properties
    #When I am storing property list when group more than two
    
  Scenario: Storing and verifying dropdown values for 3H Group, Inc
		Given Select the organization as "Insignia Hospitality Group"
  	And I click the edit column icon
    When I am storing group and property dropdown values
    Then I am storing dashboard grid values
    And I am comparing stored groups and properties 
    
  Scenario: Storing and verifying dropdown values for 3H Group, Inc
		Given Select the organization as "3H Group, Inc"
  	And I click the edit column icon
    When I am storing group and property dropdown values
    Then I am storing dashboard grid values
    And I am comparing stored groups and properties

		
 
