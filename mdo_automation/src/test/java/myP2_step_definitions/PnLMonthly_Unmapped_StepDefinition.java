package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.PnLMonthly_Unmapped_PageObject;

public class PnLMonthly_Unmapped_StepDefinition {
	
	private PnLMonthly_Unmapped_PageObject pnlUnmapped = new PnLMonthly_Unmapped_PageObject(DriverFactory.getDriver());
	
	
	@When("User clicks on Profit & Loss Unmapped option button")
	public void user_clicks_on_profit_loss_unmapped_option_button() throws InterruptedException {
		
		pnlUnmapped.selectPnLunmappedOpt();
	}

	@When("User navigates to Profit & Loss Unmapped page")
	public void user_navigates_to_profit_loss_unmapped_page() throws InterruptedException {
		
		pnlUnmapped.verifyPnLunmappedPage();
	}

	@Then("User select a Property, Year and Missing Property GL value from Unmapped dropdown and click GO button")
	public void user_select_a_property_year_and_missing_property_gl_value_from_unmapped_dropdown_and_click_go_button() throws InterruptedException {
		
		pnlUnmapped.missingPropertyGlFunc();
	}

	@Then("User select a Property, Year and GL not in COA value from Unmapped dropdown and click GO button")
	public void user_select_a_property_year_and_gl_not_in_coa_value_from_unmapped_dropdown_and_click_go_button() throws InterruptedException {
		
		pnlUnmapped.glNotInCoaFunc();
	}

	@Then("User select a Property, Year and GL not mapped value from Unmapped dropdown and click GO button")
	public void user_select_a_property_year_and_gl_not_mapped_value_from_unmapped_dropdown_and_click_go_button() throws InterruptedException {
		
		pnlUnmapped.glNotMappedFunc();
	}

	@Then("confirm if data is generated for the selected parameters without any errors being prompted")
	public void confirm_if_data_is_generated_for_the_selected_parameters_without_any_errors_being_prompted() throws InterruptedException {
	    
		pnlUnmapped.verifyTableHader();
	}



}
