package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import dbConnection.DBConnection;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.GL_Hierarchy_Mapping_PageObject;
import myP2_pageObjects.dbTest_PageObject;

public class dbTest_StepDefinition {

	dbTest_PageObject db = new dbTest_PageObject(DriverFactory.getDriver());
	DBConnection dbConnection = new DBConnection();

	@When("I have a databse connection")
	public void I_have_a_databse_connection() throws Exception {
		DBConnection.getConnection();
	}

	@When("I retrieve the actual data from {string} for {string} {string} {string} {string}")
	public void I_retrieve_the_actual_data(String string, String string2, String string3, String string4,
			String string5) throws InterruptedException {
			db.selectActualData(string, string2, string3, string4, string5);
	}
	
	@Then("I retrieve the base data from {string} for {string} {string} {string} {string}")
	public void I_retrieve_the_base_data(String string, String string2, String string3, String string4,
			String string5) throws InterruptedException {
		db.selectBaseData(string, string2, string3, string4, string5);
	}
	
	@And("I compare the actual and base data values")
	public void I_compare_the_actual_and_base_data_values() throws Exception {
		assertTrue(db.compareActualAndBaseValue());
	}
	

}
