#Author: sannorj@mydigitaloffice.ca
@myP2_Regression 

    Feature: Account Sales Manager : Add,Edit,Delete Sales Manager Account functionality

    Background: Navigate to Sales Managers page
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    And I am expand the configuration option
    Then I am navigate to Sales Managers page
    
    Scenario: Verify whether user can add a Sales Managers 
    When User clicks on add option 
    And Enters the all mandatory fields and click on save button 
    Then The main page should display the newly created Sales Managers manager
    
    Scenario: Verify whether user can Edit a Sales Managers Account 
    When User clicks on Edit option 
    And change the Name of the Sales Manager
    Then The new Sales Managers manager name should be reflected on the home page
    
    Scenario: Verify whether user can Delete a Sales Managers Account 
    When User clicks on remove option 
    Then Deleted Sales Managers Manager record should be removed On the home page
    
    