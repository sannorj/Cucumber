package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.Account_Sales_Manager_PageObjective;


public class AccountSalesManager_StepDefinition {
	
	Account_Sales_Manager_PageObjective ASManager = new Account_Sales_Manager_PageObjective(DriverFactory.getDriver());

	@Then("I am navigate to Sales Managers page")
	public void i_am_navigate_to_sales_managers_page() throws InterruptedException {
		assertTrue(ASManager.navigateToSalesManager());
	}

	@When("User clicks on add option")
	public void user_clicks_on_add_option() throws InterruptedException {
		ASManager.clickAddbutton();
	}

	@When("Enters the all mandatory fields and click on save button")
	public void enters_the_all_mandatory_fields_and_click_on_save_button() throws InterruptedException {
		ASManager.entertDetails();
	}

	@Then("The main page should display the newly created Sales Managers manager")
	public void the_main_page_should_display_the_newly_created_sales_managers_manager() throws InterruptedException {
		assertTrue(ASManager.verifyAddedRecord());
	}
	
	@When("User clicks on Edit option")
	public void user_clicks_on_edit_option() throws InterruptedException {
		ASManager.clickEditbutton();
	}

	@When("change the Name of the Sales Manager")
	public void change_the_name_of_the_sales_manager() throws InterruptedException {
		ASManager.changeFirstName();
	}

	@Then("The new Sales Managers manager name should be reflected on the home page")
	public void the_new_sales_managers_manager_name_should_be_reflected_on_the_home_page() throws InterruptedException {
		assertTrue(ASManager.verifyEditedRecord());
	}
	
	@When("User clicks on remove option")
	public void user_clicks_on_remove_option() throws InterruptedException {
		assertTrue(ASManager.clickRemovebutton());
	}

	@Then("Deleted Sales Managers Manager record should be removed On the home page")
	public void deleted_sales_managers_manager_record_should_be_removed_on_the_home_page() throws InterruptedException {
		assertTrue(ASManager.removeAccount());
	}
}
