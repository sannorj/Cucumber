package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.STR_Report_DataValidation_PageObjective;

public class STR_Report_DataValidation_StepDefinition {
	private STR_Report_DataValidation_PageObjective STR_Data =new STR_Report_DataValidation_PageObjective(DriverFactory.getDriver());
	

	
	@Given("Selects filters as {string} and {string} in the landing page")
	public void select_filters_as_and_in_the_landing_page (String string, String string2) throws InterruptedException {
		assertTrue(STR_Data.slectLadingPageFilters(string,string2));
	}
	
	@And("Select date as {string}")
	public void select_date_as (String string) throws InterruptedException {
		STR_Data.selectDate(string);
	}
	
	@Then("Click on {string} button")
	public void click_on_button (String string) throws InterruptedException {
		STR_Data.selectWeekButton(string);
	}
	
	@Then("Store first cell value")
	public void store_first_cell_value () throws InterruptedException {
		STR_Data.storeCell();
	}
	
	@And("Comapre with previous cell value")
	public void comapre_with_previous_cell_value () throws InterruptedException {
		assertTrue(STR_Data.compareCellValues());
	}
	
	@And("Comapre new property values with previous property value")
	public void comapre_new_property_values_with_previous_property_value () throws InterruptedException {
		assertTrue(STR_Data.compareDifPropertyValues());
	}
	
	@Given("Select Group as {string} and Property as {string}")
	public void select_group_as_and_property_as (String string, String string2) throws InterruptedException {
		assertTrue(STR_Data.selectOptions(string,string2));
	}
}
