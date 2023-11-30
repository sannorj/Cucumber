@dbTest

Feature: Compare the value between source and base tables for 

   Scenario: Snowflack BD connection 
    Given  the application establishes the Snowflake connection to the database
     When Retrieve the RAW snowflake data from 'DB_EDU.TEST.TBL_M3_CSV' for '346' '2023-08-11' '2023-08-12' 'D'
       
       
       