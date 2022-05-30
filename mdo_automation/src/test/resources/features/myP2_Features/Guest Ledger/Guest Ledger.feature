@myP2_Regression @myP2_Smoke
Feature: Guest Ledger - Search & Filter Validation

	Background: Navigate to Guest Ledger
    Given I am login to the myp2 site
    And System navigate to the home page
    And go to the Guest Ledger
    And Select the Group
    
   Scenario: Verify whether the user can filter the records.
   When User Click on  Filter option
   And User selects the Marsha Code from the filter options
   Then Records should be filtered based on the Marsha Code
   And User selects the Type from the filter options after clicking the reset button.
   Then Records should be filtered based on the Type
   And User selects the D/B Code from the filter options after clicking the reset button.
   Then Records should be filtered based on the D/B Code
   And User selects the Settlement type from the filter options after clicking the reset button.
   Then Records should be filtered based on the Settlement type
   And User selects the Folio from the filter options after clicking the reset button.
   Then Records should be filtered based on the Folio
   And User selects the Group from the filter options after clicking the reset button.
   Then Records should be filtered based on the Group
   And User selects the Arrival date from the filter options after clicking the reset button.
   Then Records should be filtered based on the Arrival date
   And User selects the Departure date from the filter options after clicking the reset button.
   Then Records should be filtered based on the Departure date
   And User enters OutStanding amount
   Then Records should be filtered based on the OutStanding amount
   And User enters Limit amount from the filter options
   Then Records should be filtered based on the Limit amount
   
   Scenario: Verify whether user can search the records.
   When User inputs a parameter in the search field
   Then Table should load the results
   

   