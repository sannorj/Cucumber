package myP1_step_definitions;

import static org.junit.Assert.assertTrue;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.propertyDashboard_PageObjects;

public class propertyDashboard_StepDefinition {
	propertyDashboard_PageObjects dashboardPo = new propertyDashboard_PageObjects(DriverFactory.getDriver());

	@Then("I click Property menu")
	public void i_click_Property_menu() throws InterruptedException {
		assertTrue(dashboardPo.navigateToProperty());
	}

	@Then("I navigate to Property dashboard page")
	public void i_navigate_to_property_dashboard_page() throws InterruptedException {
		dashboardPo.selectPropertyValues();
		assertTrue(dashboardPo.navigateToPropertyDashboard());
	}

	@Given("Check data load according to selected date")
	public void check_data_load_according_to_selected_date() throws InterruptedException {
		assertTrue(dashboardPo.verifyDataLoadTODate());
	}

	@Given("Verify First table is loaded")
	public void verify_first_table_is_loaded() throws InterruptedException {
		assertTrue(dashboardPo.verifyTableLoaded());
	}

	@Then("Verify all the Chartes Loaded")
	public void verify_all_the_chartes_loaded() throws InterruptedException {
		dashboardPo.checkAllChartsLoaded();
	}

}
