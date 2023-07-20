#Author: sannorja@mydigitaloffice.ca
 @dbTest



Feature: Compare the value between pickup report UI with source tables in DB 

 Scenario Outline:: Compare the value between pickup report UI with source tables in DB 
  Given I have a databse connection
  When I retrieve the Pickup data from '<table>' for '<hotelid>' '<StartDate>' '<EndDate>' '<mdoglcode>'   '<hre_type_id>'
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "HighGate Hotels" 
  Then I am expand the pickUp report option under Reports section in Side Menu
  And I am navigate to pickUp report page
  Given I am loading the Pickup report with specific filters
  And Store the total Revenue Data from the table 
  Then Compare the Retrieved data with UI data
       
  
  	
  	  Examples: 
       |        table        						 |     mdoglcode  	          |	    StartDate  	           |           EndDate       | hotelid | hre_type_id |
       |  calculation_mdo_gl_code_actual |     RMREV90               |    2022-12-01 00:00:00+00   |   2022-12-07 00:00:00+00| 832     | Revenue   |
       
       
   
     

