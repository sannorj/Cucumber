#Author: madushika@mydigitaloffice.ca
@myP1_Regression @Portfolio
Feature: Portfolio Dashboard functionality

 	Background: Verify Portfolio Dashboard Page Navigation
 		Given I am login to the myp1 site
    And System navigate to the dashboard
    When Check data loaded
    
  	Scenario: Verify Portfolio Dashboard
    Then Verify user name filter option
    And Verify filter Period option  
    When Verify main table rows expanded
    Then Verify table data sorted 
    And Verify Select option and go to summary Page
    
    
    