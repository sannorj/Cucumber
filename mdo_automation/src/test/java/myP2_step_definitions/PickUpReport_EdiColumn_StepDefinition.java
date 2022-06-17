package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import myP2_pageObjects.PickUpReport_EdiColumn_PageObject;

public class PickUpReport_EdiColumn_StepDefinition {

	PickUpReport_EdiColumn_PageObject pickupReport = new PickUpReport_EdiColumn_PageObject(DriverFactory.getDriver());

	@Given("I am loading the Pickup report")
	public void I_am_loading_the_Pickup_report() {
		pickupReport.loadReport();
	}

	@Given("I am navigate to edit column page")
	public void i_am_navigate_to_edit_column_page() {
		assertTrue(pickupReport.navigateToEditColumn());
	}

	@And("turning on all the columns")
	public void turning_on_all_the_columns() throws InterruptedException {
		pickupReport.switchOnAllTheColumns();
	}
	
	@And("I am validating with the report columns")
	public void I_am_validating_with_the_report_column() throws InterruptedException {

	}
	
	@And("turning off some of the columns")
	public void turning_off_some_of_the_columns() throws InterruptedException {
		pickupReport.switchOffSomeColumns();
	}
	
	

}
