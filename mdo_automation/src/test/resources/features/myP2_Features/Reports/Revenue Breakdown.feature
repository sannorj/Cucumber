#Author: haniffa@mydigitaloffice.ca
@myP2_Regression @revenue

  Feature: Verify Revenue Breakdown Functionality

  Scenario: Navigate to Revenue Breakdown report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "HighGate Hotels" 
    And I am expand the Revenue Breakdwon option under Reports section in Side Menu
    Then I am navigate to Revenue Breakdown page
    And I am Loading the Revenue Breakdown Report with GO button
    
    
   