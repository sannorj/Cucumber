#Author: haniffa@mydigitaloffice.ca
@myP2_Regression @pnl

Feature: P&L Yearly -  Main Header Title Verification For Column 1 Data Set Mode's (ACTUAL/FORECAST)

  Background: Navigate to PnL Yearly report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    And I am expand the P&L Statement option under Reports section in Side Menu
    Then I am navigate to P&L Yearly page
    And I select the group "All groups" , property "Days Inn & Suites Page Lake Powell" , year "2023" , view "Owner's View"
    When I am Loading the PnLYearly Report with GO button
    
  Scenario: Verify The Main header Title verification for FORECAST
    When User clicks on edit column option
    Then User select the Column1 dropdown parameters "ACTUAL/FORECAST" and "3/1/2023"
    And I am Loading the PnLYearly Report with GO button
    And I am verify the report header for "ACTUAL/FORECAST" and "3/1/2023"
    When I change the view "Operator's View"
    And I am Loading the PnLYearly Report with GO button
    And I am verify the report header for "ACTUAL/FORECAST" and "3/1/2023"
    When I change the view "GOP KPI View"
    And I am Loading the PnLYearly Report with GO button
    And I am verify the report header for "ACTUAL/FORECAST" and "3/1/2023"
    When I change the view "Room Revenue Detail"
    And I am Loading the PnLYearly Report with GO button
    And I am verify the report header for "ACTUAL/FORECAST" and "3/1/2023"