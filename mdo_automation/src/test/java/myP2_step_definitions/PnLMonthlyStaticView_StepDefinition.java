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
	public void i_am_navigate_to_p_l_monthly_page() {
		assertTrue(pnlMonthly.navigatePnLMonthlyPage());
	}

	
	@When("select the Group ,Propery, date,View and Click on GO button")
	public void select_the_group_propery_date_view_and_click_on_go_button() throws InterruptedException {
		pnlMonthly.selectParameters();
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

}


