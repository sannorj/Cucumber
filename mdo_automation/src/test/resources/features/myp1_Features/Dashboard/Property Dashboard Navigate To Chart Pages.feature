#Author: madushika@mydigitaloffice.ca
@myP1_Regression
Feature: Property Dashboard Navigate to Chart Pages functionality

  Background: Verify Property Dashboard Page Navigation
    Given I am login to the myp1 site
    And System navigate to the dashboard
    Then I navigate to Property dashboard page
    Given Check data load according to selected date
    
    Scenario: Verify Navigate to Revenue Breakdown
    Given Click on View Large
    And Check Revenue Breakdown Chart is displayed
    When Click on Revenue Breakdown Go To Details link
    And I navigate to Revenue Breakdown Page
    
    Scenario: Verify Navigate to Market Suite shop
    Given Click on Market Suite shop Go To Details link
    And I navigate to Market Suite shop Page
    
    Scenario: Verify Navigate to Total Expense Breakdown
    Given Click on Total Expense Breakdown Go To Details link
    And I navigate to Total Expense Breakdown Page
    
    Scenario: Verify Navigate to Expense vs Budget By Department
    Given Click on Expense vs Budget By Department Go To Details link
    And I navigate to Expense vs Budget By Department Page
    
    Scenario: Verify Navigate to Expense vs Budget By Category
    Given Click on Expense vs Budget By Category Go To Details link
    And I navigate to Expense vs Budget By Category Page
    
    Scenario: Verify Navigate to Cash Collecting Widget
    Given Click on Cash Collecting Widget Go To Details link
    And I navigate to Cash Collecting Widget Page
    
    Scenario: Verify Navigate to AR Aging Widget
    Given Click on AR Aging Widget Go To Details link
    And I navigate to AR Aging Widget Page
    
    Scenario: Verify Navigate to Labor Widget
    Given Click on Labor Widget Go To Details link
    And I navigate to Labor Widget Page

    Scenario: Verify Navigate to STR Report
    Given Click on STR Report Go To Details link
    And I navigate to STR Report Page
        
    
    