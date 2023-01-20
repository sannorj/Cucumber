package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import myP2_pageObjects.PickUpReport_TotalComparison_PageObject;

public class PickupReport_TotalComparison_StepDefinition {

	PickUpReport_TotalComparison_PageObject pickupReport = new PickUpReport_TotalComparison_PageObject(DriverFactory.getDriver());

	@Given("I am loading the Pickup report page with specific dates")
	public void I_am_loading_the_Pickup_report_page_with_specific_dates() {
		pickupReport.loadSpecificDatesReport();
	}
	
	@Given("I am loading the Pickup report page with second specific dates")
	public void I_am_loading_the_Pickup_report_page_with_second_specific_dates() {
		pickupReport.loadSecondSpecificDatesReport();
	}

	@Then("I am saving the OTB total raw values to the new array")
	public void I_am_saving_the_OTB_total_raw_values_to_the_new_array() throws InterruptedException {
		pickupReport.otbTotalArray();
	}
	
	@Then("I am saving the Actual total raw values to the new array")
	public void I_am_saving_the_Actual_total_raw_values_to_the_new_array() throws InterruptedException {
		pickupReport.actualTotalArray();
	}

	@And("I am saving the Grand total raw values to the new array")
	public void I_am_saving_the_Grand_total_raw_values_to_the_new_array() throws InterruptedException {
		pickupReport.grandTotalArray();
	}
	
	@And("I am Checking the mean value of the corresponding element of the actual total and OTB total arrays")
	public void I_am_Checking_the_mean_value_of_the_corresponding_element_of_the_actual_total_and_OTB_total_arrays() throws InterruptedException {
		pickupReport.meanArray();
	}
	
	@And("I am comparing the two arrays")
	public void I_am_comparing_the_two_arrays() {
		assertTrue(pickupReport.comparingTwoArrays());
	}
	
	@And("I am comparing the meanArray with grand total array")
	public void I_am_comparing_the_meanArray_with_grand_total_array() {
		assertTrue(pickupReport.comparingWithMeanArray());
	}
	
}
