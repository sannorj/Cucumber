@myP2_Regression
Feature: P&L Monthly Report


Background: navigate to P&L report
    Given I am login to the myp2 site
    And System navigate to the home page
       
 Scenario: Navigate to P&L Monthly and Click on GO button
    When I am expand the P&L Statement option under Reports section in Side Menu
    And go to the P&L Monthly page
    And select the Group ,Propery, date,View and Click on GO button
    Then Page should load the defualt static section 
      

     
     
     
     
    
    
