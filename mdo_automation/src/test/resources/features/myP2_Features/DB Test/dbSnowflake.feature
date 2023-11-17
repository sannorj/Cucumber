@dbTest

Feature: Compare the value between source and base tables for 

   Scenario: Snowflack BD connection 
   	Given I have a SnowFlacke databse connection
    #When I retrieve the RAW snowflake data from 'raw.gl.tbl_m3_csv' for '146' '2023-08-11' '2023-08-12' 'D'
    
     #When I retrieve the RAW snowflake data from 'raw' 'gl.tbl_m3_csv' for '146' '2023-08-11' '2023-08-12' 'D'
     When I retrieve the RAW snowflake data from 'DB_EDU.TEST.TBL_M3_CSV' for '346' '2023-08-11' '2023-08-12' 'D'
       
       
       