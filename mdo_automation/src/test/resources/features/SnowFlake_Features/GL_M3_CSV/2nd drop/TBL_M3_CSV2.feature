@dbTest

Feature: Compare M3 CSV data with TBL_M3_CSV table


#2nd file 
  Scenario: Read all avalable M3 CSV file data and compare data with TBL_M3_CSV table
     Given  the application establishes the Snowflake connection to the database
     And read the  all M3 CSV file is available at given path 'src/test/resources/SnowFlake_RawData/T00 - GL Post Date Added 2023_06_08_093021.csv'
     And read the all data from  TBL_M3_CSV table in the database where file name equals to '%T00 - GL Post Date Added 2023_06_08_093021.csv%'
     Then compare the data in the M3 CSV file with the data in the TBL_M3_CSV table  
     
  Scenario: Get the count of M3 CSV file data and compare it with TBL_M3_CSV table data
     Given  the application establishes the Snowflake connection to the database
     And gets the count of M3 CSV file at given path equals to 'src/test/resources/SnowFlake_RawData/T00 - GL Post Date Added 2023_06_08_093021.csv'
     And gets the count of TBL_M3_CSV table data where file name equals to '%T00 - GL Post Date Added 2023_06_08_093021.csv%'
     Then compare both CSV and database table counts to ensure they are equal
     
  # need to check null value whether its  0 or null
  Scenario: Compare Sum of Amounts from CSV and Database
    Given the application establishes the Snowflake connection to the database
    When calculate the sum of amounts from the CSV file at given path 'src/test/resources/SnowFlake_RawData/T00 - GL Post Date Added 2023_06_08_093021.csv'
    And retrieve the sum of amounts from the database where file name equals to '%T00 - GL Post Date Added 2023_06_08_093021.csv%'
    Then the sum of amounts from the CSV file should be equal to the sum from the database