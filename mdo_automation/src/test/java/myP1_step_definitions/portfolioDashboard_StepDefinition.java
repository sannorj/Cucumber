package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import myP1_pageObjects.portfolioDashboard_PageObjects;

public class portfolioDashboard_StepDefinition {
	portfolioDashboard_PageObjects dashboardPo = new portfolioDashboard_PageObjects(DriverFactory.getDriver());
	
	@Then("I expand dashboard menu")
	public void i_expand_dashboard_menu() {
		dashboardPo.navigateToDashboard();
	}

	@Then("I click Portfolio menu")
	public void i_click_portfolio_menu() throws InterruptedException {
		assertTrue(dashboardPo.navigateToPortfolio());
	}

}
