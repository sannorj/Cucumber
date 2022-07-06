package myP1_step_definitions;

import static org.junit.Assert.assertTrue;
import factory.DriverFactory;
import io.cucumber.java.en.Then;
import myP1_pageObjects.propertyDashboard_PageObjects;

public class propertyDashboard_StepDefinition {
	propertyDashboard_PageObjects dashboardPo = new propertyDashboard_PageObjects(DriverFactory.getDriver());

	@Then("I click Property menu")
	public void i_click_Property_menu() throws InterruptedException {
		assertTrue(dashboardPo.navigateToProperty());
		//KT testing
	}
	
	@Then("I navigate to Property dashboard page")
	public void i_navigate_to_property_dashboard_page() throws InterruptedException {
		dashboardPo.selectPropertyValues();
		assertTrue(dashboardPo.navigateToPropertyDashboard());
		dashboardPo.navigateToRevenueBreakdown();
		assertTrue(dashboardPo.verifyToPropertyDashboard());
	}

}
