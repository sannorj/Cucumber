#Author: sannorj@mydigitaloffice.ca
@myP2_Regression 
Feature: Income Journal Summary

	Background: Navigate to Income Journal Summary
    Given I am login to the myp2 site
    And System navigate to the home page
    And In the Side Menu, expand the IJ section.
    And Go to the Income Journal Summary
    And Select the Property , Period , Date and Click on GO button

  Scenario: Verify whether user can Add Row in Income Journal Summary  
    When User clicks Add icon in to left coner on ij summary page 
    And User fills up all required fields and click on save button. 
    Then The newly added Income Journal Summary  should be visible on the home page. 
