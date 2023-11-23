package SnowFlake_step_definitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import SnowFlake_pageObects.*;

public class TBL_M3_CSV_StepDefinition {
	
	TBL_M3_CSV_pageObject m3 = new TBL_M3_CSV_pageObject(DriverFactory.getDriver());
	
	@Given("read the  M3 CSV file is available at given path")
	public void read_the_m3_csv_file_is_available_at_given_path() {
		m3.readCSVFileFunc();
	}

	@Given("the TBL_M3_CSV table is populated in the database")
	public void the_tbl_m3_csv_table_is_populated_in_the_database() throws SQLException, Exception {
		m3.readDBdataFunc();
	}

	@Then("I compare the data in the M3 CSV file with the data in the TBL_M3_CSV table")
	public void i_compare_the_data_in_the_m3_csv_file_with_the_data_in_the_tbl_m3_csv_table() {
		assertTrue(m3.verifyCSVdbFunc());  
	}
	
	
	@Given("gets the count of M3 CSV file")
	public void gets_the_count_of_m3_csv_file() {
		m3.countCSVRowFunc();
	}

	@Given("gets the count of TBL_M3_CSV table data")
	public void gets_the_count_of_tbl_m3_csv_table_data() throws SQLException, Exception {
		m3.countDBRowFunc();
	}

	@Then("compare both CSV and database table counts to ensure they are equal")
	public void compare_both_csv_and_database_table_counts_to_ensure_they_are_equal() {
		assertTrue(m3.verifyCountOfCSVdbFunc());
	}


}
