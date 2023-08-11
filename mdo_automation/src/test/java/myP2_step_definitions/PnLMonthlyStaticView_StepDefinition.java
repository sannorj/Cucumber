package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.PnLMonthly_PageObject;


public class PnLMonthlyStaticView_StepDefinition {
	
	private PnLMonthly_PageObject pnlMonthly = new PnLMonthly_PageObject(DriverFactory.getDriver());
	
	@And("go to the P&L Monthly page")
	public void i_am_navigate_to_p_l_monthly_page() throws InterruptedException {
		assertTrue(pnlMonthly.navigatePnLMonthlyPage());
	}

	
	@When("select the Group ,Propery, date,View and Click on GO button")
	public void select_the_group_propery_date_view_and_click_on_go_button() throws InterruptedException {
		pnlMonthly.selectParameters();
	}
	
	@When("select the Group ,Propery,View and Click on GO button")
	public void select_the_group_propery__view_and_click_on_go_button() throws InterruptedException {
		pnlMonthly.selectParametersWithoutDate();
	}
	
	@When("load the PnL Monthly With GO button")
	public void load_the_PnL_Monthly_With_GO_button() throws InterruptedException {
		pnlMonthly.loadPnL();
	}
	
	@Then("Page should load the defualt static section")
	public void page_should_load_the_defualt_static_section() throws InterruptedException {
		assertTrue(pnlMonthly.verifyStaticSection());
	}
	
	@When("ROOMS SOLD divided by ROOMS AVAILABLE")
	public void rooms_sold_divided_by_rooms_available() {
		pnlMonthly.occupancyCalFunc();
	}

	@Then("Calculated value should be match with OCCUPANCY")
	public void calculated_value_should_be_match_with_occupancy() {
		assertTrue(pnlMonthly.verifyOccCalculationFunc());
	}
	
	@When("Total Rooms Revenue divided by ROOMS SOLD")
	public void total_rooms_revenue_divided_by_rooms_sold() {
		pnlMonthly.adrCalFunc();
	}

	@Then("Calculated value should be match with ADR")
	public void calculated_value_should_be_match_with_adr() {
		assertTrue(pnlMonthly.verifyAdrCalculationFunc());
	}
	
	@When("Total Rooms Revenue divided by ROOMS AVAILABLE")
	public void total_rooms_revenue_divided_by_rooms_available() {
		pnlMonthly.revParCalFunc();
	}

	@Then("Calculated value should be match with REV-PAR")
	public void calculated_value_should_be_match_with_rev_par() {
		assertTrue(pnlMonthly.verifyRevParCalculationFunc());
	}
	
	@When("TOTAL OPERATING REVENUE divided by ROOMS AVAILABLE")
	public void total_operating_revenue_divided_by_rooms_available() {
		pnlMonthly.totalRevParCalFunc();
	}

	@Then("Calculated value should be match with TOTAL REV-PAR")
	public void calculated_value_should_be_match_with_total_rev_par() {
		assertTrue(pnlMonthly.verifyTotalRevParCalculationFunc());
	}

	@Then("the P&L should show the relevent sections that belong to the Owner's view")
	public void the_p_l_should_show_the_relevent_sections_that_belong_to_the_owner_s_view() {
		assertTrue(pnlMonthly.verifyOwnersViewSection());
	}

	@When("user selects the Operators View")
	public void user_selects_the_operators_view() throws InterruptedException {
		pnlMonthly.selectOperatorView();   
	}

	@Then("the P&L should show the relevent sections that belong to the Operators View")
	public void the_p_l_should_show_the_relevent_sections_that_belong_to_the_Operators_view() {
		assertTrue(pnlMonthly.verifyOperatorSection());
	}
	
	@When("user selects the Room Revenue Detail View")
	public void user_selects_the_room_revenue_detail_view() throws InterruptedException {
		pnlMonthly.selectRooRevenueDetailView();
	}

	@Then("the P&L should show the relevent sections that belong to the Room Revenue Detail view")
	public void the_p_l_should_show_the_relevent_sections_that_belong_to_the_room_revenue_detail_view() throws InterruptedException {
		assertTrue(pnlMonthly.verifyRoomRevenueDetailSection());
	}
	
	
	
	@When("User Clicks on the View dropdown")
	public void user_clicks_on_the_view_dropdown() throws InterruptedException {
		pnlMonthly.clickOnViewDrpFunc();
	}

	@Then("View dropdown should contains Owners View , Operators View, Room Revenue Detail, Add Custom View")
	public void view_dropdown_should_contains_owners_view_operators_view_room_revenue_detail_add_custom_view() throws InterruptedException {
		assertTrue(pnlMonthly.verifyViewdrpFunc());
	}

	@Then("Custom column1 dropdown should contains ACTUAL , BUDGET , FORECAST , ACTUAL\\/FORECAST")
	public void custom_column1_dropdown_should_contains_actual_budget_forecast_actual_forecast() throws InterruptedException {
		assertTrue(pnlMonthly.verifyCucstomCol1drpFunc());
	}

	@Then("Year  dropdown should contain the current year at the top and the past four years in descending order")
	public void year_dropdown_should_contain_the_current_year_at_the_top_and_the_past_years_in_descending_order() throws InterruptedException {
		assertTrue(pnlMonthly.verifyCucstomYeardrpFunc());
	}

}


