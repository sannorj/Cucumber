package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.PnL_Comparison_EditCol_PageObject;
import myP2_pageObjects.PnL_Monthly_EditCol_PageObject;


public class PnL_Comparison_EditCol_StepDefinition {
	
	PnL_Comparison_EditCol_PageObject pnlEdit = new PnL_Comparison_EditCol_PageObject(DriverFactory.getDriver());
	private PnL_Monthly_EditCol_PageObject editCol = new PnL_Monthly_EditCol_PageObject(DriverFactory.getDriver());

	@Then("The value of the year & value should match the second column in the comparison pages table.")
	public void the_value_of_the_year_value_should_match_the_second_column_in_the_comparison_pages_table() throws InterruptedException {
		assertTrue(pnlEdit.verifySecoundHeaderFunc());
	}

	@When("Select column and year from the dropdown and click on apply button in Comparison page")
	public void select_column_and_year_from_the_dropdown_and_click_on_apply_button_in_comparison_page() throws InterruptedException {
		pnlEdit.addColumnFunc();
	}

	@Then("Table should show the newly inserted column in Comparison page")
	public void table_should_show_the_newly_inserted_column_in_comparison_page() throws InterruptedException {
		assertTrue(pnlEdit.verifyNewlyAddedColFunc());
	}

	@When("Remove the values for the columns and years on the Comparison Edit screen, then click the Apply button.")
	public void remove_the_values_for_the_columns_and_years_on_the_comparison_edit_screen_then_click_the_apply_button() throws InterruptedException {
		pnlEdit.addColumnFunc();
		editCol.clickOnEditFunc();
		pnlEdit.removeColumnFunc();
	}

	@Then("Table should remove the newly inserted column from the Comparison table")
	public void table_should_remove_the_newly_inserted_column_from_the_comparison_table() throws InterruptedException {
		assertTrue(pnlEdit.verifyRemovedColFunc());
	}
}
