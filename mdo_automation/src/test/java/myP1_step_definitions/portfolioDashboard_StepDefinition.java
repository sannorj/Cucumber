package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.portfolioDashboard_PageObjects;

public class portfolioDashboard_StepDefinition {
	portfolioDashboard_PageObjects dashboardPo = new portfolioDashboard_PageObjects(DriverFactory.getDriver());

//	@Then("I expand dashboard menu")
//	public void i_expand_dashboard_menu() {
//		dashboardPo.navigateToDashboard();
//	}
//
//	@Then("I click Portfolio menu")
//	public void i_click_portfolio_menu() throws InterruptedException {
//		assertTrue(dashboardPo.navigateToPortfolio());
//	}

	@When("Check data loaded")
	public void check_data_loaded() throws InterruptedException {
		assertTrue(dashboardPo.checkDataLoaded());
	}

	@Then("Verify user name filter option")
	public void verify_user_name_filter_option() {
		assertTrue(dashboardPo.filterUserName());
	}

	@And("Verify filter Period option")
	public void verify_filter_period_option() throws InterruptedException {
		assertTrue(dashboardPo.filterPeriod());
	}

	@When("Verify main table rows expanded")
	public void verify_main_table_rows_expanded() throws InterruptedException {
		assertTrue(dashboardPo.rowExpand());
	}

	@Then("Verify table data sorted")
	public void verify_table_data_sorted() throws InterruptedException {
		assertTrue(dashboardPo.isTblDataSort());
	}

	@And("Verify Select option and go to summary Page")
	public void verify_select_option_and_go_to_summary_page() {
		assertTrue(dashboardPo.goToSummaryPage());
	}

}
