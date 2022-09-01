package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.PnL_SuppressZero_PageObject;


public class PnL_SuppressZero_StepDefinition {
	
	private PnL_SuppressZero_PageObject SuppressZero = new PnL_SuppressZero_PageObject(DriverFactory.getDriver());
	
	@When("Select the Group ,Propery, feature date,View and Click on GO button")
	public void select_the_group_propery_feature_date_view_and_click_on_go_button() throws InterruptedException {
		SuppressZero.selectParameters();
		assertTrue(SuppressZero.SuppressRowFunc());
	}

	@When("Turn on the Zero Value Rows toggle button")
	public void turn_on_the_zero_value_rows_toggle_button() throws InterruptedException {
		SuppressZero.clickOnSuppressZeroFunc();
	}

	@Then("The report should suppress records that have amount {int} for all applicable columns.")
	public void the_report_should_suppress_records_that_have_amount_for_all_applicable_columns(Integer int1) throws InterruptedException {
		assertTrue(SuppressZero.displayRowFunc());
	}

}
