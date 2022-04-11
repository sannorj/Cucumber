@myP2_Regression
Feature: P&L Yearly Report

Background: Login to MYP2 application 
    Given I am login to the myp2 site
    And System navigate to the home page

    
  Scenario: Navigate to P&L report
    And I am expand the P&L Statement option under Reports section in Side Menu
    Then I am navigate to P&L Yearly page
    
    
    
   
    
    
    
    