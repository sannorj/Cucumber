package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.trendsDashboard_PageObjects;

public class trendsDashboard_StepDefinition {

	trendsDashboard_PageObjects dashboardTrends = new trendsDashboard_PageObjects(DriverFactory.getDriver());

	@When("Navigate to Trends page")
	public void navigate_to_trends_page() {
		dashboardTrends.navigateTrends();
	}

	@Then("Verify Trends Filtered data loaded")
	public void verify_trends_filtered_data_loaded() throws InterruptedException {
		assertTrue(dashboardTrends.filterData());
	}

	@And("Verify All cards loaded minimized and View Large chart")
	public void verify_all_cards_loaded_minimized_and_view_large_chart() throws InterruptedException {
		dashboardTrends.verifyCards();
	}

}
