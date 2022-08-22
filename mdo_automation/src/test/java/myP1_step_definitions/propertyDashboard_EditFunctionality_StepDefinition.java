package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.propertyDashboard_EditFunctionality_PageObjects;

public class propertyDashboard_EditFunctionality_StepDefinition {

	propertyDashboard_EditFunctionality_PageObjects dashboardEditFunctionalityPo = new propertyDashboard_EditFunctionality_PageObjects(
			DriverFactory.getDriver());

	@Given("Click on Edit button")
	public void click_on_edit_button() throws InterruptedException {
		dashboardEditFunctionalityPo.clickEdit();
	}

	@And("Click on Add Chart button")
	public void click_on_add_chart_button() throws InterruptedException {
		dashboardEditFunctionalityPo.addChart();
	}

	@When("Verify Add Chart popup displayed")
	public void verify_add_chart_popup_displayed() {
		assertTrue(dashboardEditFunctionalityPo.verifyAddChartPopupDisplayed());
	}

	@Then("remove a chart and click on submit button")
	public void remove_a_chart_and_click_on_submit_button() throws InterruptedException {
		dashboardEditFunctionalityPo.removeChart();
	}

	@And("Check Chart is removed")
	public void check_chart_is_removed() throws InterruptedException {
		assertTrue(dashboardEditFunctionalityPo.verifyChartRemoved());
	}

	@Given("Click on Edit button to add chart")
	public void click_on_edit_button_to_add_chart() throws InterruptedException {
		dashboardEditFunctionalityPo.clickEdit();
	}

	@When("Re-select removed chart and click on submit button")
	public void re_select_removed_chart_and_click_on_submit_button() throws InterruptedException {
		dashboardEditFunctionalityPo.reSelectRemovedChart();
	}

	@And("Verify Chart is loaded")
	public void verify_chart_is_loaded() throws InterruptedException {
		assertTrue(dashboardEditFunctionalityPo.verifyAddedChartIsLoaded());
	}

	@When("Remove Selected Column")
	public void remove_selected_column() throws InterruptedException {
		dashboardEditFunctionalityPo.removeColumn();
	}

	@And("Enable remove confirm msg")
	public void enable_remove_confirm_msg() throws InterruptedException {
		dashboardEditFunctionalityPo.enableRemoveConfirm();
	}

	@Then("Verify column successfully removed")
	public void verify_column_successfully_removed() throws InterruptedException {
		assertTrue(dashboardEditFunctionalityPo.verifyColRemoved());
	}

	@And("Add new Column")
	public void add_new_column() throws InterruptedException {
		dashboardEditFunctionalityPo.addNewColumn();
	}

	@Then("Select Selected Column for new column")
	public void select_selected_column_for_new_column() throws InterruptedException {
		dashboardEditFunctionalityPo.selectColumn();
	}

	@And("Verify column successfully added")
	public void verify_column_successfully_added() throws InterruptedException {
		assertTrue(dashboardEditFunctionalityPo.verifyColAdded());
	}

	@And("Remove a selected chart")
	public void remove_a_selected_chart() throws InterruptedException {
		dashboardEditFunctionalityPo.removeSelectedChart();
	}
}
