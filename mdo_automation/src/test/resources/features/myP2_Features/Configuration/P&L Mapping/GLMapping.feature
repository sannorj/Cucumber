#Author: pasindu@mydigitaloffice.ca
@myP2_Regression @GL_Mapping @pasindu

Feature: Primary DashBoard - By Revenue Feature 

Background: Navigate to P&L Monthly report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Insignia Hospitality Group"
    Then I am expand the configuration options in Side Menu
    Then I am navigate to GL Mapping page
    Then User selecting a Single property from the property dropdown and check records in table
  
  Scenario: Verify whenever a user wants to add a new GL code
  When The user clicks the Add button and confirms that the Add GL Code page is visible
  Then User creates a new GL Code and save it
  Then User search the new GL Code using the search bar and confirms that gl code is visible on the table
  
  Scenario: Verify whenever a user wants to edit a record
  Then User search the new GL Code using the search bar and confirms that gl code is visible on the table
  And The user clicks the Edit button and confirms that the Edit GL Code page is visible
  And User edit the specific GL Code and save it
  Then User search the edited GL Code using the search bar and confirms that gl code is visible on the table
  
  Scenario: Verify whenever a user wants to Delete a GL code
  Then User search the edited GL Code using the search bar and confirms that gl code is visible on the table
  And The user clicks the delete button and confirms that the delete GL Code page is visible
  And User successfully delete the specific GL Code