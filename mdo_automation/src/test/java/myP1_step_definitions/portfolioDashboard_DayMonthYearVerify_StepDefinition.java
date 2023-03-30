package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import myP1_pageObjects.portfolioDashboard_DayMonthYearVerify_PageObjects;

public class portfolioDashboard_DayMonthYearVerify_StepDefinition {

	portfolioDashboard_DayMonthYearVerify_PageObjects dashboardDayMonthYearVerifyPo = new portfolioDashboard_DayMonthYearVerify_PageObjects(
			DriverFactory.getDriver());

	@Given("Click on Portfolio month button")
	public void click_on_portfolio_month_button() throws InterruptedException {
		dashboardDayMonthYearVerifyPo.clickMonthBtn();
	}

	@And("Verify navigate to Month page")
	public void verify_navigate_to_month_page() throws InterruptedException {
		assertTrue(dashboardDayMonthYearVerifyPo.navigateToMonthPg());
	}

	@Given("Click on Portfolio year button")
	public void click_on_portfolio_year_button() {
		dashboardDayMonthYearVerifyPo.clickYearBtn();
	}

	@And("Verify navigate to year page")
	public void verify_navigate_to_year_page() {
		assertTrue(dashboardDayMonthYearVerifyPo.navigateToYearPg());
	}

}
