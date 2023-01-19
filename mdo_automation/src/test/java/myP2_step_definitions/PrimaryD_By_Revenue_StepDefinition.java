package myP2_step_definitions;

import static org.junit.Assert.assertTrue;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.PrimaryD_By_Revenue_PageObject;


public class PrimaryD_By_Revenue_StepDefinition {
	
	private PrimaryD_By_Revenue_PageObject primaryDByRevenue = new PrimaryD_By_Revenue_PageObject(DriverFactory.getDriver());

	@When("User click the By Revenue section")
	public void User_click_the_by_revenue_section() throws InterruptedException {
		primaryDByRevenue.clickByRevenueButt(); 
	}
	
	@Then("User select All properties from the property dropdown")
	public void User_select_all_properties_from_the_property_dropdown() throws InterruptedException {
		primaryDByRevenue.selectAllProperties(); 
	}
	
	@Then("User select Single property from the property dropdown")
	public void User_select_single_property_from_the_property_dropdown() throws InterruptedException {
		primaryDByRevenue.selectSingleProperty(); 
	}

	@And("Verify table is empty")
	public void Verify_table_is_empty() throws InterruptedException {
		primaryDByRevenue.verifyEmptyMessage(); 
	}
	
	@And("Verify first column table data is available")
	public void Verify_first_column_table_data_is_available() throws InterruptedException {
		primaryDByRevenue.verifyFirstColumnRec(); 
	}

}
