#Author: madushika@mydigitaloffice.ca
@myP1_Regression @LaborMain
Feature: Labor Dashboard Main Functionality

  Background: Verify Labor Dashboard
    Given I am login to the myp1 site
    And System navigate to the dashboard
    When Navigate to Labor page
    Then Select a date and hotel as "24 North"
    And Filter all data
    
    Scenario: Verify Labor functionality
    Then Verify All cards loaded minimized and chart loaded according to data
    And Verify "Payroll Actual vs Budget (" hour and minute buttons
    When Verify "Payroll Actual vs Budget" Go to detail page view
    
    #Scenario: Labor dashboard edit functionality
    #Given Close a single card manualy
    #And Enable card again
    #When Desable card from add chat
    #Then Enable acrd again
    #And Verify All enabled card visible