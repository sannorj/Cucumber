#Author: haniffa@mydigitaloffice.ca
@myp1dbTest

Feature: Compare the value between source and base tables for 

   Scenario Outline:: Compare the Total Room Revenue  KPI value between source and base tables (calculation_mdo_gl_code_actual and calculation_kpi_actual_periods_2021)
   	Given I have a databse connection
   	When I retrieve the actual data list from '<table>' for '<mdoglcode>' '<from_date>' '<to_date>' '<hotelid>' '<hre_type_id>'
  #	Then I retrieve the sample report file data
#	 	And I compare the database value with report values
   
   Examples: 
       |        table        						 |              basetable           	 | mdoglcode |	  from_date  	         |	  to_date  	           | hotelid |hre_type_id |     kpi            |
       |  calculation_mdo_gl_code_actual |  calculation_kpi_actual_periods_2021|  RMREV90  |  2021-03-15 00:00:00+00 |  2021-03-20 00:00:00+00 |   832   |  Revenue   | Total Room Revenue |
       
     
     