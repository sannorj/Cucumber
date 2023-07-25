#Author: pasindu@mydigitaloffice.ca
@myP2_Regression @AllSmokeTests @pasindu

Feature: Smoke testing for all the pages

Background: Login to MYP2 application
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "Insignia Hospitality Group"
  
  Scenario: Verify whether Static section loading in the Primary Dashboard page
    Then Page should load the defualt static section in the Primary Dashboard page
    Then User click on the Add Comments page and verify
    Then User click the View Comments section and verify
    When I Am navigate to toggle widget page by clicking ToggleWidget Icon
    Then User click close button
    When I Am navigate to order widget page by clicking OrderWidget Icon
    Then User click close button
    Then User navigate to Copy Dashboard page by clicking Copy Dashboard Settings Icon
    Then I am navigate to Add column page
    
  Scenario: Verify whether Static section loading in the Trend Dashboard page
  	And I am expand the DashBoard section in Side Menu and navigate to trend dashboard
    Then Page should load the defualt static section in the Trend Dashboard page
    When I Am navigate to toggle widget page by clicking ToggleWidget Icon
    Then User click close button
    When I Am navigate to order widget page by clicking OrderWidget Icon
    Then User click close button
    Then User navigate to Copy Dashboard page by clicking Copy Dashboard Settings Icon
    
  Scenario: Verify whether Static section loading in the PnL Yearly page
  	And I am expand the P&L Statement option under Reports section in Side Menu
    Then I am navigate to P&L Yearly page
    When I am Loading the PnLYearly Report with GO button
    Then Page should load the defualt static section
    Then user clicks Commissions Calculator button and verify the page
    When User clicks on edit column option
    
  Scenario: Verify whether Static section loading in the PnL Monthly page
  	And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Monthly page   
    And select the Group ,Propery, date,View and Click on GO button
    Then Page should load the defualt static section 
    When User clicks on Profit & Loss Unmapped option button
    And User navigates to Profit & Loss Unmapped page
		Then User select a Property, Year and Missing Property GL value from Unmapped dropdown and click GO button
		And confirm if data is generated for the selected parameters without any errors being prompted
    
  Scenario: Verify whether Static section loading in the PnL Property Comparison page
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Property Comparison
    And Select the Group , date,View and Click on GO button
    Then Page should load the defualt static section in PnL Comparison
    
  Scenario: Verify whether Static section loading in the AR Aging Dashboard page
    And I am expand the Account Recievable option under Reports section in Side Menu
  	Then I am navigate to AR Dashboard page
 		When I select the group and Date
 		And I select the date from picker
  	Then I am loading ar report with Go button
  	Given I turn on the Show chart
 		And Verify whether the chart is visible
  
  Scenario: Verify whether Static section loading in the AR Aging Property page
    And I am expand the Account Recievable option under Reports section in Side Menu
  	Then I am navigate to AR Property page
  	When I select the property and Date
  	And I select the date from picker
  	Then I am loading ar property report with Go button
		Given I turn on the Show chart
		And Verify whether the chart is visible
  
  Scenario: Verify whether Static section loading in the Pickup Report page
    Then I am expand the pickUp report option under Reports section in Side Menu
    And I am navigate to pickUp report page
    Given I am loading the Pickup report page with specific dates
    Then I am navigate to edit column page
  
  Scenario: Verify whether Static section loading in the Rolling Month Report page
    And Expand the Rolling Month Report option under Reports section in Side Menu
   	And Navigate to Rolling Month Report page
   	When User selects the Group and date
   	Then Default Rolling Month Headers should be loaded on the page.
  
  Scenario: Verify whether Static section loading in the Calendar Month Report page
    And Expand the Calendar Month Report option under Reports section in Side Menu
   	And Navigate to Calendar Month Report page
   	When User selects the Group and date
   	Then Calendar Month Headers should be loaded on the page.
  
  Scenario: Verify whether Static section loading in the Revenue Breakdown Report page
    And I am expand the Revenue Breakdwon option under Reports section in Side Menu
    Then I am navigate to Revenue Breakdown page
    And I am Loading the Revenue Breakdown Report with GO button for smoke testing
  
  Scenario: Verify whether Static section loading in the GL Mapping page
    Then I am expand the configuration options in Side Menu
    Then I am navigate to GL Mapping page
    Then User selecting a Single property from the property dropdown and check records in table
    When The user clicks the Add button and confirms that the Add GL Code page is visible
    Then user click cancel button
    Then user click Filter option button and verify it
  
  
  #Scenario: Verify whether Static section loading in the PnL Monthly page
    #Then Page should load the defualt static section in the PnL Monthly page
  #
  