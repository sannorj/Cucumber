#Author: sannorj@mydigitaloffice.ca
@myP2_Regression @myP2_Smoke @PnL @comparisonEdit

Feature:  P&L Comparison Report - Edit Column functionality  

  Background: Navigate to P&L Monthly report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    
  Scenario: Verify that the very first three column headers match to the edit drawer drop downs
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Property Comparison
    And Select the Group , date,View and Click on GO button
    When User clicks on edit column option 
    And Page should open the edit column drawer
    Then First column and the year dropdown value should match the first table column
    And The value of the year & value should match the second column in the comparison pages table.
    
  Scenario: Verify whether user can add a additional coulmn 
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Property Comparison
    And Select the Group , date,View and Click on GO button
    When User clicks on edit column option 
    And Select column and year from the dropdown and click on apply button in Comparison page 
    Then Table should show the newly inserted column in Comparison page 
    
  Scenario: Verify whether user can remove the newly inserted column
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Property Comparison
    And Select the Group , date,View and Click on GO button
    When User clicks on edit column option 
    And Remove the values for the columns and years on the Comparison Edit screen, then click the Apply button.
    Then Table should remove the newly inserted column from the Comparison table
    
  Scenario: Verify whether user can edit every header that is available
    And I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Property Comparison
    And Select the Group , date,View and Click on GO button
    When The recently modified column should be displayed when a user changes all the parameters in the edit column 
    Then Page should load the defualt static section    
    
  Scenario Outline: Verify P&L Property Comparison page Element visibility and filter functionality
	  Given Selects filters as '<filter1>' and '<filter2>' in the initial page
	  And Click on the Menu bar
	  When Expand the '<Main_menu>' menu 
	  Then Expand the '<sub_menu>' menu option
	  And Select the '<target_Page>' option
	  Given Check the header of the navigated page '<target_Page_header>'
	  And Verify Group was selected as '<filter1>' and Property was selected as '<nullVal>'
	  When Click on the Go button
	  Then Verify name raws
  
   Examples: 
       |    filter1         |            filter2 								| Main_menu |  sub_menu |         		target_Page 			      |					target_Page_header				| nullVal | 
       |  Beck Legacy Group | Days Inn & Suites Page Lake Powell|  Reports	|P&L Reports| P&L Property Comparison Report (New)| Profit & Loss Property Comparison |  null 	|
	
		   
 