
@dbTest

Feature: Data Comparison Between TBL_M3_CSV and tbl_transactional

  Scenario: Compare data between TBL_M3_CSV and tbl_transactional tables
   Given  the application establishes the Snowflake connection to the database
    And read the data from TBL_M3_CSV table
    And read the data from tbl_transactional table 
    Then the data in TBL_M3_CSV should match the data in tbl_transactional
