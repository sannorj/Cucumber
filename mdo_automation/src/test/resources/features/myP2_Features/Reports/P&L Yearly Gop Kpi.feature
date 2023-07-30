#Author: pasindu@mydigitaloffice.ca
@myP2_Regression

Feature: P&L Yearly - GOP KPI are not displayed for P&L Monthly & P&L Comparison reports

  Background: Navigate to P&L Yearly page and verify functionality  
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Insignia Hospitality Group" 
    And I am expand the P&L Statement option under Reports section in Side Menu
    
    Scenario: Verify the P&L Yearly exclusive sections are not displayed in P&L Monthly and P&L Property Comparison report
    Then I am navigate to P&L Yearly page
		When I select the group "1Insignia Hospitality Group" , property "CNMTS" , year "2020" , view "GOP KPI View"
		Then I clicks GO button and confirm if the sections, GOP Flow Thru Prior Year Actuals & GOP Margin sections are visible in the P&L Yearly report
		And I am expand the P&L Statement option under Reports section in Side Menu
		And go to the P&L Monthly page 
		And I select the group "1Insignia Hospitality Group" , property "CNMTS" , specific date , view "Owner's View" and confirm GOP KPI View section is not visible in view dropdown
		And I clicks GO button
		And confirm if the sections, GOP Flow Thru Prior Year Actuals & GOP Margin sections are not visible in the PnL Monthly report
		
		
		Given I am expand the P&L Statement option under Reports section in Side Menu
		And go to the P&L Property Comparison
		Then I select the group "1Insignia Hospitality Group" , specific date , view "Owner's View" and confirm GOP KPI View section is not visible in view dropdown
		And I clicks GO button
		And confirm if the sections, GOP Flow Thru Prior Year Actuals & GOP Margin sections are not visible in the PnL Property Comparison report