@dbTest

Feature: Compare M3 CSV data with TBL_M3_CSV table

  Scenario: Read M3 CSV file and compare data with TBL_M3_CSV table
    Given  the application establishes the Snowflake connection to the database
    And read the  M3 CSV file is available at given path
    And the TBL_M3_CSV table is populated in the database
    Then I compare the data in the M3 CSV file with the data in the TBL_M3_CSV table
    
    
   Scenario: Get the count of M3 CSV file data and compare it with TBL_M3_CSV table data
   Given  the application establishes the Snowflake connection to the database
    And gets the count of M3 CSV file
    And gets the count of TBL_M3_CSV table data
    Then compare both CSV and database table counts to ensure they are equal



