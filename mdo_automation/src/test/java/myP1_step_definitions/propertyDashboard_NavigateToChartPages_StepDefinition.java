package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.propertyDashboard_NavigateToChartPages_PageObjects;

public class propertyDashboard_NavigateToChartPages_StepDefinition {

	propertyDashboard_NavigateToChartPages_PageObjects dashboardNavigateToChartPagesPo = new propertyDashboard_NavigateToChartPages_PageObjects(
			DriverFactory.getDriver());

	@Given("Click on View Large")
	public void click_on_view_large() throws InterruptedException {
		dashboardNavigateToChartPagesPo.clickViewLarge();
	}

	@And("Check Revenue Breakdown Chart is displayed")
	public void check_revenue_breakdown_chart_is_displayed() throws InterruptedException {
		assertTrue(dashboardNavigateToChartPagesPo.checkRBDchartDisplayed());
	}

	@When("Click on Revenue Breakdown Go To Details link")
	public void click_on_revenue_breakdown_go_to_details_link() throws InterruptedException {
		dashboardNavigateToChartPagesPo.clickRBDgotoDetails();
	}

	@And("I navigate to Revenue Breakdown Page")
	public void i_navigate_to_revenue_breakdown_page() throws InterruptedException {
		assertTrue(dashboardNavigateToChartPagesPo.RBDpageIsDisplayed());
	}

	@Given("Click on Market Suite shop Go To Details link")
	public void click_on_market_suite_shop_go_to_details_link() {
		dashboardNavigateToChartPagesPo.clickMarketSuiteShopGotoDetails();
	}

	@And("I navigate to Market Suite shop Page")
	public void i_navigate_to_market_suite_shop_page() throws InterruptedException {
		assertTrue(dashboardNavigateToChartPagesPo.marketSuiteShopIsDisplayed());
	}

	@Given("Click on Total Expense Breakdown Go To Details link")
	public void click_on_total_expense_breakdown_go_to_details_link() throws InterruptedException {
		dashboardNavigateToChartPagesPo.totalExpenseBreakdownGotoDetails();
	}

	@And("I navigate to Total Expense Breakdown Page")
	public void i_navigate_to_total_expense_breakdown_page() throws InterruptedException {
		assertTrue(dashboardNavigateToChartPagesPo.totalExpenseBreakdownIsDisplayed());
	}

	@Given("Click on Expense vs Budget By Department Go To Details link")
	public void click_on_expense_vs_budget_by_department_go_to_details_link() {
		dashboardNavigateToChartPagesPo.expensevsBudgetByDepartmentGotoDetails();
	}

	@And("I navigate to Expense vs Budget By Department Page")
	public void i_navigate_to_expense_vs_budget_by_department_page() throws InterruptedException {
		assertTrue(dashboardNavigateToChartPagesPo.expensevsBudgetByDepartmentIsDisplayed());
	}

	@Given("Click on Expense vs Budget By Category Go To Details link")
	public void click_on_expense_vs_budget_by_category_go_to_details_link() throws InterruptedException {
		dashboardNavigateToChartPagesPo.expensevsBudgetByCategoryGotoDetails();
	}

	@And("I navigate to Expense vs Budget By Category Page")
	public void i_navigate_to_expense_vs_budget_by_category_page() throws InterruptedException {
		assertTrue(dashboardNavigateToChartPagesPo.expensevsBudgetByCategoryIsDisplayed());
	}

	@Given("Click on Cash Collecting Widget Go To Details link")
	public void click_on_cash_collecting_widget_go_to_details_link() {
		dashboardNavigateToChartPagesPo.cashWidgetGotoDetails();
	}

	@And("I navigate to Cash Collecting Widget Page")
	public void i_navigate_to_cash_collecting_widget_page() throws InterruptedException {
		assertTrue(dashboardNavigateToChartPagesPo.cashWidgetIsDisplayed());
	}

	@Given("Click on AR Aging Widget Go To Details link")
	public void click_on_ar_aging_widget_go_to_details_link() {
		dashboardNavigateToChartPagesPo.ARAgingWidgetGotoDetails();
	}

	@And("I navigate to AR Aging Widget Page")
	public void i_navigate_to_ar_aging_widget_page() throws InterruptedException {
		assertTrue(dashboardNavigateToChartPagesPo.ARAgingWidgetIsDisplayed());
	}

	@Given("Click on Labor Widget Go To Details link")
	public void click_on_labor_widget_go_to_details_link() {
		dashboardNavigateToChartPagesPo.LaborWidgetGotoDetails();
	}

	@And("I navigate to Labor Widget Page")
	public void i_navigate_to_labor_widget_page() {
		assertTrue(dashboardNavigateToChartPagesPo.LaborWidgetIsDisplayed());
	}

	@Given("Click on STR Report Go To Details link")
	public void click_on_str_report_go_to_details_link() {
		dashboardNavigateToChartPagesPo.STRWidgetGotoDetails();
	}

	@And("I navigate to STR Report Page")
	public void i_navigate_to_str_report_page() {
		assertTrue(dashboardNavigateToChartPagesPo.STRWidgetIsDisplayed());
	}

}
