#Author: pasindu@mydigitaloffice.ca
@myP2_Regression @ByRevenue @pasindu

Feature: Primary DashBoard - By Revenue Feature 

Background: Login to MYP2 application
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "Insignia Hospitality Group" 
  
  Scenario: Verify table records when the user select All properties from the property dropdown and click the By Revenue section
  When User click the By Revenue section
  Then User select All properties from the property dropdown
  And Verify table is empty
  
  Scenario: Verify table records when the user select single properties from the property dropdown and click the By Revenue section
  When User click the By Revenue section
  Then User select Single property from the property dropdown
  And Verify first column table data is available