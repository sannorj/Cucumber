package myP1_step_definitions;

import dbConnection.DBConnection;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.dbTest_myp1_PageObject;

public class dbTest_StepDefinition {
	dbTest_myp1_PageObject db = new dbTest_myp1_PageObject(DriverFactory.getDriver());
	DBConnection dbConnection = new DBConnection();
	

	@When("I retrieve the actual data list from {string} for {string} {string} {string} {string} {string}")
	public void i_retrieve_the_actual_data_list_from_for(String table, String mdoglcode, String from_date, String to_date, String hotelid, String hre_type_id) {
	    db.selectTblValues(table,mdoglcode,from_date,to_date,hotelid,hre_type_id);
	}

	@Then("I retrieve the sample report file data")
	public void i_retrieve_the_sample_report_file_data() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@And("I compare the database value with report values")
	public void i_compare_the_database_value_with_report_values() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
