#Author: pasindu@mydigitaloffice.ca
@myP2_Regression @PrimaryDashBoard @byRev

Feature: Primary DashBoard - By Revenue default Data Validation Function 

Background: Login to myP2 application
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "Insignia Hospitality Group" 
  
  Scenario: Verify the default message for the By Revenue table when a user selects All Properties from the Properties dropdown menu in the Primary dashboard. 
  When User click the By Revenue section
  Then User select All properties from the property dropdown
  And Review the default warning message that appears in the By Revenue table
  
  Scenario: Verify table records when the user select single properties from the property dropdown and click the By Revenue section
  When User click the By Revenue section
  Then User select Single property from the property dropdown
  And Verify first column table data is available