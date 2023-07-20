package myP2_step_definitions;


import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.dbPickupReport_PageObject;

public class dbPickupReport {
	
	dbPickupReport_PageObject pickDB = new dbPickupReport_PageObject(DriverFactory.getDriver());
	
	
	
	@When("I retrieve the Pickup data from {string} for {string} {string} {string} {string}   {string}")
	public void i_retrieve_the_pickup_data_from_for(String string, String string2, String string3, String string4, String string5, String string6) {
		pickDB.selectDBdata(string, string2, string3, string4, string5, string6);
	}
	
	@Given("I am loading the Pickup report with specific filters")
	public void i_am_loading_the_pickup_report_with_specific_filters() {
		pickDB.loadSpecificDatesReport();
	}

	@Given("Store the total Revenue Data from the table")
	public void store_the_total_revenue_data_from_the_table() throws InterruptedException {
		pickDB.storePickuptotalRev();
	}

	@Then("Compare the Retrieved data with UI data")
	public void compare_the_retrieved_data_with_ui_data() {
		assertTrue(pickDB.veriyPickUpdata());
	}

}
