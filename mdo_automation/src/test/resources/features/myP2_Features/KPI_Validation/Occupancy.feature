#Author: sannorj@mydigitaloffice.ca
@myP2_KPI_Regression

Feature: Verify Occupancy KPI Calculation 

   Scenario Outline: Get myP2 ADR KPI data for Highgate
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "HighGate Hotels" 
    And I change the date HG
    Then I navigate to the Add Column cart HG
    
    And I add '<kpi1>' kpi HG
    Then I get '<kpi1>' value HG
    And I delete added '<kpi1>' cloumn HG
    
    And I add '<kpi2>' kpi HG
    Then I get '<kpi2>' value HG
    And I delete added '<kpi2>' cloumn HG
  
    And I add '<kpi3>' kpi HG
    Then I get '<kpi3>' value HG
    And I delete added '<kpi3>' cloumn HG

    Examples: 
       |    kpi1       | Amount |       kpi2       |  Amount  |   kpi3     |  Amount |
       |  Rooms Sold   | Actual |  Rooms Available |  Actual  | Occupancy  |  Actual |
        
      
   Scenario Outline: Verify Occupancy KPI Calculation
    And I am verifying '<myP2kpi1>' divided by '<myP2kpi2>' calculated value is matching with  '<myP2kpi3>'
    
     Examples: 
      |     myP2kpi1    |       myP2kpi2   	|  myP2kpi3 |
      |  Rooms Sold     |  Rooms Available  | Occupancy |