package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import myP1_pageObjects.portfolioDashboard_VisualPortfolio_PageObjects;

public class portfolioDashboard_VisualPortfolio_StepDefinition {
	portfolioDashboard_VisualPortfolio_PageObjects dashboardVisualPortfolioPo = new portfolioDashboard_VisualPortfolio_PageObjects(DriverFactory.getDriver());

	@Given("Click on Visual Portfolio button")
	public void click_on_visual_portfolio_button() {
		dashboardVisualPortfolioPo.clickVisualPortfolioBtn();
	}

	@When("Verify navigate to Visual Portfolio page")
	public void verify_navigate_to_visual_portfolio_page() {
		assertTrue(dashboardVisualPortfolioPo.landToVPpage());
	}
}
