package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.portfolioDashboard_Edit_PageObjects;

public class portfolioDashboard_Edit_StepDefinition {

	portfolioDashboard_Edit_PageObjects dashboardEditPo = new portfolioDashboard_Edit_PageObjects(
			DriverFactory.getDriver());

	@Given("Click on Portfolio Edit button")
	public void click_on_portfolio_edit_button() {
		dashboardEditPo.clickEditBtn();
	}

	@And("Add column")
	public void add_column() {
		dashboardEditPo.addColumn();
	}

	@Then("Verify Column added")
	public void verify_column_added() {
		assertTrue(dashboardEditPo.verifyColAdded());
	}

	@And("Delete an selected column")
	public void delete_an_selected_column() throws InterruptedException {
		dashboardEditPo.deleteColumn();
	}

	@When("Click remove confirm")
	public void click_remove_confirm() throws InterruptedException {
		dashboardEditPo.clickRemoveConfirm();
	}

	@Given("Click Edit button")
	public void click_edit_button() {
		dashboardEditPo.clickEditToVerify();
	}

	@Then("Verify column is removed")
	public void verify_column_is_removed() {
		assertTrue(dashboardEditPo.verifyColRemoved());
	}

}
