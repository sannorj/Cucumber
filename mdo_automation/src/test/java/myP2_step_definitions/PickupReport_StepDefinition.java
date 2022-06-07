package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import myP2_pageObjects.PickupReport_PageObjective;

public class PickupReport_StepDefinition {

	PickupReport_PageObjective pickupReport = new PickupReport_PageObjective(DriverFactory.getDriver());

	@Then("I am expand the pickUp report option under Reports section in Side Menu")
	public void i_am_expand_the_pick_up_report_option_under_reports_section_in_side_menu() {
		pickupReport.expandPickupReport();
	}

	@And("I am navigate to pickUp report page")
	public void i_am_navigate_to_pick_up_report_page() {
		assertTrue(pickupReport.navigatePickupReportPage());
	}
	@When("I stored all the actual data")
	public void I_stored_all_the_actual_data() {
		pickupReport.storeAlltheActualData();
	}
	@And("I compare the dates and verify")
	public void i_compare_the_dates_and_verify() {
		assertTrue(pickupReport.compareDates());
	}
}
