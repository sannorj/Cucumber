package SnowFlake_step_definitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import SnowFlake_pageObects.*;

public class TBL_M3_CSV_StepDefinition {
	
	TBL_M3_CSV_pageObject m3 = new TBL_M3_CSV_pageObject(DriverFactory.getDriver());
	
	// 1 ============================================================================================================//

	
	
	@Given("read the  M3 CSV file is available at given path {string}")
	public void read_the_m3_csv_file_is_available_at_given_path(String path) {
		m3.readCSVFileFunc(path);
	}

	@Given("read the data from  TBL_M3_CSV table in the database where file name equals to {string}")
	public void the_tbl_m3_csv_table_is_populated_in_the_database_where_file_name_equals_to(String fileName) throws SQLException, Exception {
	    m3.readDBdataFunc(fileName);
	}


	@Then("I compare the data in the M3 CSV file with the data in the TBL_M3_CSV table")
	public void i_compare_the_data_in_the_m3_csv_file_with_the_data_in_the_tbl_m3_csv_table() {
		assertTrue(m3.verifyCSVdbFunc());  
	}
	
	
	
	

	
	// 2 ============================================================================================================//

	
	@Given("gets the count of M3 CSV file at given path {string}")
	public void gets_the_count_of_m3_csv_file_at_given_path(String path) {
	    m3.countCSVRowFunc(path);
	}

	@Given("gets the count of TBL_M3_CSV table data where file name equals to {string}")
	public void gets_the_count_of_tbl_m3_csv_table_data_where_file_name_equals_to(String fileName) throws SQLException, Exception {
		m3.countDBRowFunc(fileName);
	}

	
	@Then("compare both CSV and database table counts to ensure they are equal")
	public void compare_both_csv_and_database_table_counts_to_ensure_they_are_equal() {
		assertTrue(m3.verifyCountOfCSVdbFunc());
	}

	// 3 ============================================================================================================//	
	
	@When("calculate the sum of amounts from the CSV file at given path {string}")
	public void calculate_the_sum_of_amounts_from_the_csv_file_at_given_path(String path) {
	   m3.readCSVSumAmoutFunc(path);
	}

	@When("retrieve the sum of amounts from the database where file name equals to {string}")
	public void retrieve_the_sum_of_amounts_from_the_database_where_file_name_equals_to(String fileName) throws SQLException, Exception {
	    m3.readDBSumAmoutFunc(fileName);
	}

	@Then("the sum of amounts from the CSV file should be equal to the sum from the database")
	public void the_sum_of_amounts_from_the_csv_file_should_be_equal_to_the_sum_from_the_database() {
		assertTrue(m3.verifySumAmountOfCSVdbFunc());
	}
	
	
	// 4 ============================================================================================================//	
	
	@Given("read the  all M3 CSV file is available at given path {string}")
	public void read_the_all_m3_csv_file_is_available_at_given_path(String string) {
	   m3.readAllCSVFileFunc(string);
	}

	@Given("read the all data from  TBL_M3_CSV table in the database where file name equals to {string}")
	public void read_the_all_data_from_tbl_m3_csv_table_in_the_database_where_file_name_equals_to(String string) throws SQLException, Exception {
		m3.readAllDBdataFunc(string);
	}

	@Then("compare the data in the M3 CSV file with the data in the TBL_M3_CSV table")
	public void compare_the_data_in_the_m3_csv_file_with_the_data_in_the_tbl_m3_csv_table() throws SQLException, Exception {
		assertTrue(m3.compareData());
	}
	
	
	
//	@Given("read the Count of file name that have same COMPANY_CODE, PROPERTY_CODE, BATCH_ID, POST_DATE in TBL_M3_CSV Table")
//	public void read_the_count_of_file_name_that_have_same_company_code_property_code_batch_id_post_date() throws SQLException, Exception {
//		m3.fileCountFunc();
//	}
//
//	@Then("the TBL_M£ table should not have duplicate entries")
//	public void the_tbl_m£_table_should_not_have_duplicate_entries() {
//		assertTrue(m3.verifyduplicateCountFunc());
//	}

	
	@Given("gets the count of M3 CSV file at given path equals to {string}")
	public void gets_the_count_of_m3_csv_file_at_given_path_equals_to(String string) {
		m3.countCSVRowFunc_2(string);
	}
}
