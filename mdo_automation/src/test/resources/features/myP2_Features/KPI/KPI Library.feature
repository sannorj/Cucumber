#Author: haniffa@mydigitaloffice.ca
@myP2_Regression

    Feature: KPI Library functionality feature

    Background: Navigate to KPI Labrary
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "Beck Legacy Group" 
    When I am expand the configuration option in Side Menu
    And System navigate to KPI Library page
    
    Scenario: Create new KPI with Static Fromula
    Given I am navigate to Add kpi page
    And i select the KPIType,Name,Description
    When I am assigning a static formula
    Then I save the formula
    And Verify whether the saved formula is available
        
    Scenario: Delete static KPI
    Given i am searching kpi for delelte
    And i expand the functions and delete the KPI
    
    Scenario: Create new KPI with Dynamic Fromula
    Given I am navigate to Add kpi page
    And i select the KPIType,Name,Description Dynamicaly
    When I am assigning a Dynamic formula
    Then I save the formula
    And Verify whether the saved dynamic formula is available
        
    Scenario: Edit Dynamic KPI
    Given i am searching kpi for edit
    Then i expand the functions and edit the KPI
    And i save the edited KPI and verify
    
    Scenario: Delete Dynamic Edited KPI
    Given i am searching dynamic edited kpi for delelte
    And i expand the functions and delete the dynamic KPI
   