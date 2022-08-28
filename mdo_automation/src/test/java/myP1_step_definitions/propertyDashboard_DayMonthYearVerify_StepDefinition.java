package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.propertyDashboard_DayMonthYearVerify_PageObjects;

public class propertyDashboard_DayMonthYearVerify_StepDefinition {
	propertyDashboard_DayMonthYearVerify_PageObjects dashboardDayMonthYearVerifyPo = new propertyDashboard_DayMonthYearVerify_PageObjects(
			DriverFactory.getDriver());

	@Given("Click on Month")
	public void click_on_month() {
		dashboardDayMonthYearVerifyPo.clickMonth();
	}

	@And("search selected month and year")
	public void search_selected_month_and_year() throws InterruptedException {
		dashboardDayMonthYearVerifyPo.searchSelectedMonthYear();
	}

	@When("Check Add Event popup is visible")
	public void check_add_event_popup_is_visible() {
		assertTrue(dashboardDayMonthYearVerifyPo.checkAddEventPopupLoaded());
	}

	@Then("Click on Selected date")
	public void click_on_selected_date() throws InterruptedException {
		dashboardDayMonthYearVerifyPo.clickSeletedDate();
	}

	@And("Verify I navigate to Selected Date")
	public void verify_i_navigate_to_selected_date() throws InterruptedException {
		assertTrue(dashboardDayMonthYearVerifyPo.verifyNavigateToSelectedDate());
	}

	@Given("Click on Year")
	public void click_on_year() {
		dashboardDayMonthYearVerifyPo.clickYear();
	}

	@And("search selected year")
	public void search_selected_year() throws InterruptedException {
		dashboardDayMonthYearVerifyPo.searchSelectedYear();
	}

	@When("Click on Selected Month")
	public void click_on_selected_month() throws InterruptedException {
		dashboardDayMonthYearVerifyPo.clickOnSelectedMonth();
	}

	@Then("Verify I navigate to Selected Month")
	public void verify_i_navigate_to_selected_month() throws InterruptedException {
		assertTrue(dashboardDayMonthYearVerifyPo.verifyNavigateToSelectedMonth());
	}

}
