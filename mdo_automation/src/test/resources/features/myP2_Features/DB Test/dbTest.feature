#Author: haniffa@mydigitaloffice.ca
@myP2_Regression  @myP2_Smoke @dbTest

Feature: Compare the value between source and base tables

   Scenario Outline:: Compare the value between source and base tables
   Given I have a databse connection
   When I retrieve the actual data from '<table>' for '<mdoglcode>' '<date>' '<hotelid>' '<hre_type_id>'
   Then I retrieve the base data from '<basetable>' for '<kpi>' '<date>' '<hotelid>' '<hre_type_id>'
	 And I compare the actual and base data values
   
   Examples: 
       |        table        						 |              basetable           	 |      mdoglcode  	           |	    date  	   | hotelid |hre_type_id |     kpi            |
       |  calculation_mdo_gl_code_actual |  calculation_kpi_actual_periods_2021|       RMREV90               |    2021-03-15 00:00:00+00   |   832   |  Revenue   | Total Room Revenue |
       
     