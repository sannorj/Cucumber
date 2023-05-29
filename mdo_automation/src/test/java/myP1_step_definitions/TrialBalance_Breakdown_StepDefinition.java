package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import com.aventstack.extentreports.util.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.TrialBalance_Breakdown_PageObjects;

public class TrialBalance_Breakdown_StepDefinition {

	TrialBalance_Breakdown_PageObjects tbBreakdownPo = new TrialBalance_Breakdown_PageObjects(
			DriverFactory.getDriver());

	@When("Navigate to TrialBalance Breakdown page")
	public void navigate_to_trial_balance_breakdown_page() {
		tbBreakdownPo.navigateTBBreakdown();
	}

	@Then("Select a date and hotel as {string} and Period as {string}")
	public void select_a_date_and_hotel_as_and_period_as(String hotel, String period) throws InterruptedException {
		tbBreakdownPo.selectFilterOptions(hotel,period);
	}

	@And("Update all data")
	public void update_all_data() {
		tbBreakdownPo.updateData();
	}

	@When("Verify each Description {string} and Type {string} columns types are equal")
	public void verify_each_description_and_type_columns_types_are_equal(String description, String type) {
		assertTrue(tbBreakdownPo.comapareDescriptionType(description,type));
	}

	@Then("Verify each Display Description {string} and Type {string} columns types are equal")
	public void verify_each_display_description_and_type_columns_types_are_equal(String displayDescription, String type) {
		assertTrue(tbBreakdownPo.comapareDisplayDescriptionType(displayDescription,type));
	}

	@And("Verify Amount {string} values greater than zero when filter Has Amount")
	public void verify_amount_values_greater_than_zero_when_filter_has_amount(String amount) throws InterruptedException {
		assertTrue(tbBreakdownPo.verifyHasAmount(amount));
	}

	@Given("Verify Credit & Debit Total values are equal when filter Has Amount")
	public void verify_credit_debit_total_values_are_equal_when_filter_has_amount() throws InterruptedException {
		assertTrue(tbBreakdownPo.verifyCreditDebit());
	}

	@Then("Verify Stat {string} column values are greater than zero when filter Has Stat")
	public void verify_stat_column_values_are_greater_than_zero_when_filter_has_stat(String stat) throws InterruptedException {
		assertTrue(tbBreakdownPo.verifyHasStatFilter(stat));
	}

	@And("Verify GL Code values are greater than zero when filter Has GLCode")
	public void verify_gl_code_values_are_greater_than_zero_when_filter_has_gl_code() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("Verify Edit TrialBalance model view options")
	public void verify_edit_trial_balance_model_view_options() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Verify close model option")
	public void verify_close_model_options() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@And("Verify Add Row section")
	public void verify_add_row_section() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Verify Delete Row section")
	public void verify_delete_row_section() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}
