#Author: madushika@mydigitaloffice.ca
@myP1_Regression @p1
Feature: Property Dashboard Data Load functionality

  Scenario: Verify Property Dashboard Page Navigation
    Given I am login to the myp1 site
    And System navigate to the dashboard
    Then I navigate to Property dashboard page
  	#Verify Data Loaded successfully
    Given Check data load according to selected date
    When Verify First table is loaded
    And Verify all the Chartes Loaded
    
    