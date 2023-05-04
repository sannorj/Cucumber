#Author: madushika@mydigitaloffice.ca
@myP1_Regression @LaborMain
Feature: Labor Dashboard Edit Functionality

  Background: Verify Labor Dashboard
    Given I am login to the myp1 site
    And System navigate to the dashboard
    When Navigate to Labor page
    Then Select a date and hotel as "24 North"
    And Filter all data
    
    Scenario: Labor dashboard edit functionality
    When Desable card from add chart
    And Verify card desable
    Then Enable card again
    And Verify card enable