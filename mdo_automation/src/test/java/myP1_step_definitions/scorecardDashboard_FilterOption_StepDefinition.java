package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import myP1_pageObjects.scorecardDashboard_FilterOption_pageObjects;

public class scorecardDashboard_FilterOption_StepDefinition {

	scorecardDashboard_FilterOption_pageObjects dashboardFilterOpt = new scorecardDashboard_FilterOption_pageObjects(
			DriverFactory.getDriver());

	@Given("Verify cards data loaded for date")
	public void verify_cards_data_loaded_for_date() {
		assertTrue(dashboardFilterOpt.verifyCardDataLoad());
	}

	@Given("Verify Week Month buttons works")
	public void verify_week_month_buttons_works() {
		assertTrue(dashboardFilterOpt.verifyWkMonthBtn());
	}

}
