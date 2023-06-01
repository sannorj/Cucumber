package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.PnLComparison_PageObject;


public class PnLComparisonStaticView_StepDefinition {
	
	private PnLComparison_PageObject pnlComparison = new PnLComparison_PageObject(DriverFactory.getDriver());
	
	@Given("go to the P&L Property Comparison")
	public void go_to_the_p_l_property_comparison() throws InterruptedException {
	    assertTrue(pnlComparison.navigatePnLComparison());
	}
	
	@Given("Select the Group , date,View and Click on GO button")
	public void select_the_group_date_view_and_click_on_go_button() throws InterruptedException {
		pnlComparison.selectParameters();
	}
	
	@When("User Clicks on the View dropdown PnL Comparison")
	public void user_clicks_on_the_view_dropdown() throws InterruptedException {
		pnlComparison.clickOnViewDrpFunc();
	}
	
	@Then("View dropdown should contains Owners View , Operators View, Room Revenue Detail, Add Custom View in PnL Comparioson")
	public void view_dropdown_should_contains_owners_view_operators_view_room_revenue_detail_add_custom_view() throws InterruptedException {
		assertTrue(pnlComparison.verifyViewdrpFunc());
	}
	
	@When("User clicks on edit column option in PnL Comparison")
	public void user_clicks_on_edit_column_option() throws InterruptedException {
		pnlComparison.clickOnEditFunc();
	}
	
	@Then("Custom column1 dropdown should contains ACTUAL , BUDGET , FORECAST , ACTUAL\\/FORECAST in PnL Comparison")
	public void custom_column1_dropdown_should_contains_actual_budget_forecast_actual_forecast() throws InterruptedException {
		assertTrue(pnlComparison.verifyCucstomCol1drpFunc());
	}
	
	@Then("Year dropdown should contain the current year at the top and the past {int} years in descending order")
	public void year_dropdown_should_contain_the_current_year_at_the_top_and_the_past_years_in_descending_order(Integer int1) throws InterruptedException {
		assertTrue(pnlComparison.verifyCucstomYeardrpFunc());
	}
	
	@Then("Page should load the defualt static section in PnL Comparison")
	public void page_should_load_the_defualt_static_section() throws InterruptedException {
		assertTrue(pnlComparison.verifyStaticSection());
	}
	
	@When("ROOMS SOLD divided by ROOMS AVAILABLE in PnL Comparison")
	public void rooms_sold_divided_by_rooms_available() {
		pnlComparison.occupancyCalFunc();
	}

	@Then("Calculated value should be match with OCCUPANCY in PnL Comparison")
	public void calculated_value_should_be_match_with_occupancy() {
		assertTrue(pnlComparison.verifyOccCalculationFunc());
	}
	
	@When("Total Rooms Revenue divided by ROOMS SOLD in PnL Comparison")
	public void total_rooms_revenue_divided_by_rooms_sold() {
		//pnlMonthly.adrCalFunc();
	}

	@Then("Calculated value should be match with ADR in PnL Comparison")
	public void calculated_value_should_be_match_with_adr() {
		//assertTrue(pnlMonthly.verifyAdrCalculationFunc());
	}
	
}
