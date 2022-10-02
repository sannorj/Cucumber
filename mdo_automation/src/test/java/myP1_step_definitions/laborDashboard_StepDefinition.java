package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import javax.xml.datatype.DatatypeFactory;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.laborDashboard_PageObjects;

public class laborDashboard_StepDefinition {

	laborDashboard_PageObjects dashboardLabor = new laborDashboard_PageObjects(DriverFactory.getDriver());

	@When("Navigate to Labor page")
	public void navigate_to_labor_page() {
		assertTrue(dashboardLabor.navigateLabor());
	}

	@Then("Select a date and hotel as {string}")
	public void select_a_date_and_hotel_as_to_filter_data(String string) throws InterruptedException {
		dashboardLabor.selectOptions(string);
	}

	@And("Filter all data")
	public void filter_all_data() throws InterruptedException {
		dashboardLabor.loadData();
	}

	@Then("Verify All cards loaded minimized and chart loaded according to data")
	public void verify_all_cards_loaded_minimized_and_chart_loaded_according_to_data() throws InterruptedException {
		dashboardLabor.verifyCards();
	}

	@And("Verify {string} hour and minute buttons")
	public void verify_hour_and_minute_buttons(String string) {
		dashboardLabor.verifyHrMinButton(string);
	}

	@When("Verify {string} Go to detail page view")
	public void verify_go_to_detail_page_view(String string) throws InterruptedException {
		assertTrue(dashboardLabor.payrollPageView(string));
	}

}
