#Author: sannorj@mydigitaloffice.ca
@myP2_Regression

Feature: Guest Ledger - Search & Filter Validation

	Background: Navigate to Guest Ledger
    Given I am login to the myp2 site
    And System navigate to the home page
    
   Scenario: Verify whether the user can filter the records.
    And go to the Guest Ledger
    And Select the organization as "Marriott"
    And Select the Group
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
   #		And User selects the Arrival date from the filter options after clicking the reset button.
   #		Then Records should be filtered based on the Arrival date
   #		And User selects the Departure date from the filter options after clicking the reset button.
   #		Then Records should be filtered based on the Departure date
   	And User enters OutStanding amount
   	Then Records should be filtered based on the OutStanding amount
   	And User enters Limit amount from the filter options
   	Then Records should be filtered based on the Limit amount   
   
   Scenario: Verify whether user can search the records.
    And go to the Guest Ledger
    And Select the organization as "Marriott"
    And Select the Group
  	When User inputs a parameter in the search field
   	Then Table should load the results
  
  @myP2_Smoke
  Scenario Outline: Verify Guest Ledger page Element visibility and filter functionality
    Then Select the organization as "Beck Legacy Group"
	  Given Selects filters as '<filter1>' and '<filter2>' in the initial page
	  And Click on the Menu bar
	  And Select the '<target_Page>' option
	  Given Check the header of the navigated page '<target_Page_header>'
	  And Verify Group was selected as '<filter1>' and Property was selected as '<nullVal>'
  
   Examples: 
       |    filter1         | filter2 													|    target_Page     | target_Page_header | nullVal |
       |  Beck Legacy Group | Days Inn & Suites Page Lake Powell| Guest Ledger (New) | Guest Ledger (New) |  null		|
   

   