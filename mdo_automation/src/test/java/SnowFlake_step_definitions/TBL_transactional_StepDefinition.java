package SnowFlake_step_definitions;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import SnowFlake_pageObects.TBL_transactional_pageObject;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TBL_transactional_StepDefinition {
	
	TBL_transactional_pageObject data = new TBL_transactional_pageObject(DriverFactory.getDriver());
	
	
	@Given("read the data from TBL_M3_CSV table")
	public void read_the_data_from_tbl_m3_csv_table() throws SQLException, Exception {
	 data.readTBL_M3_CSVFunc();
	}

	@Given("read the data from tbl_transactional table")
	public void read_the_data_from_tbl_transactional_table() throws SQLException, Exception {
		data.readTBL_transactionalFunc();
	}

	@Then("the data in TBL_M3_CSV should match the data in tbl_transactional")
	public void the_data_in_tbl_m3_csv_should_match_the_data_in_tbl_transactional() throws SQLException, Exception {
	    assertTrue(data.verifyFunc());
	}

}
