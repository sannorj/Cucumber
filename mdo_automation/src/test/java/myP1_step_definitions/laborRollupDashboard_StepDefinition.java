package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.laborRollupDashboard_PageObjects;

public class laborRollupDashboard_StepDefinition {

	laborRollupDashboard_PageObjects dashboardLaborRollup = new laborRollupDashboard_PageObjects(
			DriverFactory.getDriver());

	@When("Navigate to Labor Rollup page")
	public void navigate_to_labor_rollup_page() {
		dashboardLaborRollup.navigatetoLaborRollup();
	}

	@Then("Select a date and hotel as {string} and period as {string} to filter table")
	public void select_a_date_and_hotel_as_and_period_as_to_filter_table(String string, String string2)
			throws InterruptedException {
		dashboardLaborRollup.loadData(string, string2);
	}

	@Given("Verify Actual buttons")
	public void verify_actual_buttons() {
		dashboardLaborRollup.verifyActual();
	}

	@When("I turn on all the columns")
	public void i_turn_on_all_the_columns() throws InterruptedException {
		dashboardLaborRollup.enableAllColumns();
	}

	@And("Verify columns Total values of Actual")
	public void verify_columns_total_values_of_actual() {
		assertTrue(dashboardLaborRollup.actualTotal());
	}

	@When("Verify Gross Payroll in Actual")
	public void verify_gross_payroll_in_actual() {
//		assertTrue(dashboardLaborRollup.actualGrossPayroll());
	}

	@Then("Verify actual data sorted")
	public void verify_actual_data_sorted() throws InterruptedException {
		assertTrue(dashboardLaborRollup.verifyActualDataSorted());
	}

	@And("Verify filtered Actual Search data")
	public void verify_filtered_actual_search_data() {
		assertTrue(dashboardLaborRollup.verifyActualSearchVal());
	}

	@Given("Verify POR buttons")
	public void verify_por_buttons() {
		dashboardLaborRollup.verifyPOR();
	}

	@And("Verify columns Total values of POR")
	public void verify_columns_total_values_of_por() {
		assertTrue(dashboardLaborRollup.porTotal());
	}

//	@When("Verify Total Payroll in POR")
//	public void verify_total_payroll_in_por() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}

	@Then("Verify POR data sorted")
	public void verify_por_data_sorted() throws InterruptedException {
		assertTrue(dashboardLaborRollup.verifyPorDataSorted());
	}

	@And("Verify filtered POR Search data")
	public void verify_filtered_por_search_data() {
		assertTrue(dashboardLaborRollup.verifyPorSearchVal());
	}

	@Given("Disable selected columns")
	public void disable_selected_columns() throws InterruptedException {
		dashboardLaborRollup.disableCols();

	}

	@And("Verify columns disabled in Actual and POR")
	public void verify_columns_disabled_in_actual_and_por() throws InterruptedException {
		assertTrue(dashboardLaborRollup.verifyColsDisabled());
	}

	@When("Enable columns")
	public void enable_columns() throws InterruptedException {
		dashboardLaborRollup.enableColumns();
	}

	@Then("Verify columns enabled in Actual and POR")
	public void verify_columns_enabled_in_actual_and_por() throws InterruptedException {
		assertTrue(dashboardLaborRollup.verifyColEnabled());
	}

}
