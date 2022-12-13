package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.PnL_data_Validation_PageObject;

public class PnL_data_Validation_StepDefinition {

	private PnL_data_Validation_PageObject PnL_data =new PnL_data_Validation_PageObject(DriverFactory.getDriver());
	
//	@When("select the Group , Propery, specific date, View and Click on GO button")
//	public void select_the_group_propery_specific_date_view_and_click_on_go_button() throws InterruptedException {
//		PnL_data.selectParametersFunc();
//	}
	
	@When("select the group {string} , property {string}, specific date, View and Click on GO button")
	public void select_the_group_property_specific_date_view_and_click_on_go_button(String grp, String property) throws InterruptedException {
		PnL_data.selectParametersFunc(grp, property);
	}

	@When("Store the first column values")
	public void store_the_first_column_values() throws InterruptedException {
		PnL_data.storeMonthlyValuesFunc();
	}

	@When("Store the Total column values")
	public void store_the_total_column_values() throws InterruptedException {
		PnL_data.storeComparisionValuesFunc();
	}

	@Then("Compare the P&L monthly and P&L Comparison Report figures")
	public void compare_the_p_l_monthly_and_p_l_p_l_comparison_report_figures() throws InterruptedException {
		assertTrue( PnL_data.verifyMonthValueFunc()); 
	}
	
	@Then("Store the february column values")
	public void store_the_february_column_values() throws InterruptedException {
		PnL_data.storeYearlyValuesFunc();
	}

	@Then("Compare the P&L monthly and P&L Yearly Report figures")
	public void compare_the_p_l_monthly_and_p_l_yearly_report_figures() throws InterruptedException {
		assertTrue( PnL_data.verifyYearlyValueFunc()); 
	}


}
