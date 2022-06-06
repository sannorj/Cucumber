package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import myP2_pageObjects.AR_Dashboard_PageObjective;

public class AR_Dashboard_StepDefinition {

	AR_Dashboard_PageObjective ARdashboardPo = new AR_Dashboard_PageObjective(DriverFactory.getDriver());

	@And("I am expand the Account Recievable option under Reports section in Side Menu")
	public void I_am_expand_the_Account_Recievable_option_under_Reports_section_in_Side_Menu() {
		ARdashboardPo.expandAccountRecievable();
	}

	@Then("I am navigate to AR Dashboard page")
	public void I_am_navigate_to_AR_Dashboard_page() {
		assertTrue(ARdashboardPo.navigateToARDahsboardPage());
	}

	@When("I select the group and Date")
	public void i_select_the_group_and_date() throws InterruptedException {
		ARdashboardPo.loadPageWithParameters();
	}

	@Then("I am loading ar report with Go button")
	public void i_am_loading_ar_report_with_go_button() {
		assertTrue(ARdashboardPo.loadArReport());
	}

	@Given("I turn on the Show chart")
	public void i_turn_on_the_show_chart() {
		ARdashboardPo.turnOnShowChart();
	}

	@And("Verify whether the chart is visible")
	public void verify_whether_the_chart_is_visible() {
		assertTrue(ARdashboardPo.verifyShowChart());
	}

	@Given("I am storing all the values")
	public void i_am_storing_all_the_values() {
		ARdashboardPo.storeAlltheRecords();
	}

	@And("I am sorting all the values")
	public void i_am_sorting_all_the_values() {

		ARdashboardPo.calulateMaxValue();
	}

	@Then("I turn on the Show at risk")
	public void i_turn_on_the_show_at_risk() {
		ARdashboardPo.turnOnShowAtRisk();
	}

	@And("Verify whether the RED Outstanding values are correctly highlighted")
	public void verify_whether_the_RED_Outstanding_values_are_correctly_highlighted() {
		assertTrue(ARdashboardPo.verifyRedOutstanding());
	}
	
	@And("Verify whether the YELLOW Outstanding values are correctly highlighted")
	public void verify_whether_the_YELLOW_Outstanding_values_are_correctly_highlighted() {
		assertTrue(ARdashboardPo.verifyYellowOutstanding());
	}

}
