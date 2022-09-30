#Author: madushika@mydigitaloffice.ca
@myP1_Regression @myp1test
Feature: Trends Dashboard Functionality

  Scenario: Verify Trends Dashboard
    Given I am login to the myp1 site
    And System navigate to the dashboard
    When Navigate to Trends page
    Then Verify Trends Filtered data loaded
    And Verify All cards loaded minimized and View Large chart