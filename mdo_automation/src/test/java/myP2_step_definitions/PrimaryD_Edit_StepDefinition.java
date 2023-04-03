package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.PrimaryD_Edit_PageObject;

public class PrimaryD_Edit_StepDefinition {
	
	private PrimaryD_Edit_PageObject primaryDEdit = new PrimaryD_Edit_PageObject(DriverFactory.getDriver());
	
	@Given("Select the appropriate group and property")
	public void select_the_appropriate_group_and_property() throws InterruptedException {
		primaryDEdit.selectParameters();
	}
	
	@When("User clicks Edit icon in By Property table")
	public void user_clicks_edit_icon_in_by_property_table() throws InterruptedException {
		primaryDEdit.clickOnEdit();
	}

	@Then("The table goes into the editable mode")
	public void the_table_goes_into_the_editable_mode()  {
		assertTrue(primaryDEdit.verifyEditMode());
	}

	@Then("User click on the edit icon in the particular column")
	public void user_click_on_the_edit_icon_in_the__particular_column() throws InterruptedException {
		primaryDEdit.clickOnEditColumn();
	}

	@Then("User changed the paramerters and clicks save button")
	public void user_changed_the_paramerters_and_clicks_save_button() throws InterruptedException {
		primaryDEdit.clickOnSave();
	}
	
	@Then("The changes are reflected in the column")
	public void the_changes_are_reflected_in_the_column() throws InterruptedException {
		assertTrue(primaryDEdit.verifyEditedColumn());
	}
	
	@When("User clicks edit icon in By Revenue table")
	public void user_clicks_edit_icon_in_by_by_revenue() throws InterruptedException {
		primaryDEdit.clickOnEditOnByRevenue();
	}

}
