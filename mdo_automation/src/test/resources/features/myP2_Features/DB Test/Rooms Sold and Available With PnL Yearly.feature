#Author: haniffa@mydigitaloffice.ca
@myP2_Regression  @myP2_Smoke @dbTestKPI

Feature: Compare the Rooms Sold and Rooms Available Data's with PnL Yearly

  Scenario Outline:: Fetch the Rooms Sold and Rooms Available Data From DB 
    Given I have a databse connection
    When I retrieve the rooms available data from '<table>' for '<Startdate>' '<Enddate>' '<hotelid>'
    When I retrieve the rooms sold data from '<table>' for '<Startdate>' '<Enddate>' '<hotelid>'
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "HighGate Hotels" 
    And I am expand the P&L Statement option under Reports section in Side Menu
    Then I am navigate to P&L Yearly page
    And I select the group "01. Highgate - US" , property "Alohilani Resort Waikiki Beach" , year "2022" , view "Owner's View"
    When I am Loading the PnLYearly Report with GO button
    Then Page should load the defualt static section
    And I am storing the Rooms Available data
    And I am storing the Rooms Sold data
    And I Compare the store data with DB captured value
   Examples: 
   |        table        						 | Startdate  	           | Enddate  	            | hotelid |
   |  hotel_rooms_stat_actual        | 2022-01-01 00:00:00+00  | 2022-12-31 00:00:00+00 |   832   |
       
    