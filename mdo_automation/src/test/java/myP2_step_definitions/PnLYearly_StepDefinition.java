package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.PnLYearly_PageObject;

public class PnLYearly_StepDefinition {

	private PnLYearly_PageObject pnlYearly = new PnLYearly_PageObject(DriverFactory.getDriver());

	@Given("I am expand the P&L Statement option under Reports section in Side Menu")
	public void i_am_expand_the_p_l_statement_option_under_reports_section_in_side_menu() {
		pnlYearly.expandPnLStatement();
	}

	@Then("I am navigate to P&L Yearly page")
	public void i_am_navigate_to_p_l_yearly_page() {
		assertTrue(pnlYearly.navigatePnLYearlyPage());
	}

	@And("I select the group {string} , property {string} , year {string} , view {string}")
	public void I_select_the_group(String grp, String property, String year, String view) throws InterruptedException {
		pnlYearly.passParameteres(grp, property, year, view);
	}

	@Then("I am Loading the PnLYearly Report with GO button")
	public void I_am_Loading_the_PnLYearly_Report_with_GO_button() throws InterruptedException {
		pnlYearly.loadPriorityReport();
	}

	@And("I am calulating the values")
	public void I_am_calulating_the_values() throws InterruptedException {
		pnlYearly.assignValues();
	}

	@When("ROOMS SOLD divided by ROOMS AVAILABLE Yearly")
	public void rooms_sold_divided_by_rooms_available() {
		pnlYearly.occupancyCalFunc();
	}

	@Then("Calculated value should be match with OCCUPANCY Yearly")
	public void calculated_value_should_be_match_with_occupancy() {
		assertTrue(pnlYearly.verifyOccCalculationFunc());
	}

	@When("Total Rooms Revenue divided by ROOMS SOLD Yearly")
	public void total_rooms_revenue_divided_by_rooms_sold() {
		pnlYearly.adrCalFunc();
	}

	@Then("Calculated value should be match with ADR Yearly")
	public void calculated_value_should_be_match_with_adr() {
		assertTrue(pnlYearly.verifyAdrCalculationFunc());
	}
	
	@When("Total Rooms Revenue divided by ROOMS AVAILABLE Yearly")
	public void total_rooms_revenue_divided_by_rooms_available() {
		pnlYearly.revParCalFunc();
	}

	@Then("Calculated value should be match with REV-PAR Yearly")
	public void calculated_value_should_be_match_with_rev_par() {
		assertTrue(pnlYearly.verifyrevParCalculationFunc());
	}
	
	@When("TOTAL OPERATING REVENUE divided by ROOMS AVAILABLE Yearly")
	public void total_operating_revenue_divided_by_rooms_available() {
		pnlYearly.totalRevParCalFunc();
	}

	@Then("Calculated value should be match with TOTAL REV-PAR Yearly")
	public void calculated_value_should_be_match_with_total_rev_par() {
		assertTrue(pnlYearly.verifyTotalrevParCalculationFunc());
	}
}
