package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.PnL_Monthly_EditCol_PageObject;

public class PnL_Monthly_EditCol_StepDefinition {
	
	private PnL_Monthly_EditCol_PageObject editCol = new PnL_Monthly_EditCol_PageObject(DriverFactory.getDriver());
	
	@When("User clicks on edit column option")
	public void user_clicks_on_edit_column_option() throws InterruptedException {
		editCol.clickOnEditFunc();
	}

	@When("Page should open the edit column drawer")
	public void page_should_open_the_edit_column_drawer() {
	   assertTrue(editCol.verifyEditDrawerFunc());
	}

	@When("First column and the year dropdown value should match the first table column")
	public void first_column_and_the_year_dropdown_value_should_match_the_first_table_column() throws InterruptedException {
		 assertTrue(editCol.verifyFirstHeaderFunc());
	}

	@When("Second column and the year dropdown value should match the table column")
	public void second_column_and_the_year_dropdown_value_should_match_the_first_table_column() throws InterruptedException {
		 assertTrue(editCol.verifySecoundHeaderFunc());
	}

	@When("Third column and the year dropdown value should match the table column")
	public void third_column_and_the_year_dropdown_value_should_match_the_first_table_column() throws InterruptedException {
		 assertTrue(editCol.verifyThridHeaderFunc());
	}
	
	@When("Select column and year from the dropdown and click on apply button")
	public void select_column_and_year_from_the_dropdown_and_click_on_apply_button() throws InterruptedException {
		editCol.addColumnFunc();
	}

	@Then("Table should show the newly inserted column")
	public void table_should_show_the_newly_inserted_column() throws InterruptedException {
		 assertTrue(editCol.verifyNewlyAddedColFunc());
	}
	
	@When("Remove column and year values from the dropdown and click on apply button")
	public void remove_column_and_year_values_from_the_dropdown_and_click_on_apply_button() throws InterruptedException {
		editCol.addColumnFunc();
		editCol.clickOnEditFunc();
		editCol.removeColumnFunc();
	}

	@Then("Table should remove the newly inserted column from the table")
	public void table_should_remove_the_newly_inserted_column_from_the_table() throws InterruptedException {
		assertTrue(editCol.verifyRemovedColFunc());
	}
	

	@When("change the all the parameters in edit column")
	public void change_the_all_the_parameters_in_edit_column() throws InterruptedException {
		editCol.changeColumnFunc();
	}

	@Then("Table should display the recently modified column")
	public void table_should_display_the_recently_modified_column() throws InterruptedException {
		 assertTrue(editCol.verifyNewlyChangedColFunc());
	}




}
