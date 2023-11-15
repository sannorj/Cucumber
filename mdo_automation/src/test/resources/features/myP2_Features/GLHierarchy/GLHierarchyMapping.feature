#Author: sannorj@mydigitaloffice.ca


Feature: GL Hierarchy - hmg gl code  mapping validation

   Background: Navigate to P&L Monthly report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    And I am expand the configuration options in Side Menu
    And I am navigate to GL Hierarchy page
    When user selects the property form property dropdown
    Then based on the property page should load the MDO gl codes
    And  clicks on the Manage GL Codes button from the UI
    
   Scenario: Verify whether user can map a single available hmg code to a mdo gl code
   And  select one single available hmg gl code from the pop-up and click on save button 
   Then Add GL Codes text should change to Manage GL Codes
   
   Scenario: Verify whether user can remove the mapped hmg code from the pop-up
   And  Remove the all mapped hmg GL codes 
   Then Manage GL Codes GL Codes text should change to Add GL Codes
   
   Scenario: Verify whether user can map a multiple available hmg code to a mdo gl code
   And  select multiple available hmg gl code from the pop-up and click on save button 
   Then Add GL Codes text should change to Manage GL Codes