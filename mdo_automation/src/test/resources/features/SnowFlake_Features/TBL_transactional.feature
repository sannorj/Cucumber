
@dbTest

Feature: Data Comparison Between TBL_M3_CSV and tbl_transactional

  Scenario: Compare data between TBL_M3_CSV and tbl_transactional tables
   Given  the application establishes the Snowflake connection to the database
   And read the data from TBL_M3_CSV table where file name equals to '%T00 - GL Post Date Added 2023_02_01_081301.csv%'
   And read the data from tbl_transactional table  where hotel code equals to 'T00-368'
   Then the data in TBL_M3_CSV should match the data in tbl_transactional

  Scenario: Verify Credit and Debit signs in TBL_transition
   Given  the application establishes the Snowflake connection to the database
   And reads the Credit data from TBL_M3_CSV table  where file name equals to '%T00 - GL Post Date Added 2023_02_01_081301.csv%' and GL Account equals to '1060.000'
   And reads the Debit data from TBL_M3_CSV table where GL Account equals to '4020.000'
   Then verify that Credit and Debit signs are perfectly reflected on TBL_transition
   
  Scenario: Verify correct company code in tbl_transactional table
    Given  the application establishes the Snowflake connection to the database
    And reads the Company_Code and Property Code from TBL_M3_CSV table where file name equals to '%T00 - GL Post Date Added 2023_02_01_081301.csv%'
    And gets the organization code from the file name where file name equals to 'T00 - GL Post Date Added 2023_02_01_081301.csv'
    Then the Hotel code in tbl_transactional table should display the correct combination of organization + company code + property code
