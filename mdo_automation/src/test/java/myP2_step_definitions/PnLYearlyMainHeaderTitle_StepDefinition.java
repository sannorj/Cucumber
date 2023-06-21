package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import myP2_pageObjects.PnLYearlyMainHeaderTitle_PageObject;

public class PnLYearlyMainHeaderTitle_StepDefinition {

	private PnLYearlyMainHeaderTitle_PageObject pnlYearly = new PnLYearlyMainHeaderTitle_PageObject(
			DriverFactory.getDriver());

	@Then("User select the Column1 dropdown parameters {string} and {string}")
	public void I_select_the_group(String string, String year) throws InterruptedException {
		pnlYearly.selectDropdownParameters(string, year);
	}
	
	@Then("User select the Column1 dropdown parameters {string} and year {string}")
	public void I_select_the_group_AF(String string, String year) throws InterruptedException {
		pnlYearly.selectDropdownParametersForActualForecast(string, year);
	}

	@Then("User click the apply button and load the report")
	public void User_click_the_apply_button_and_load_the_report() throws InterruptedException {
		// pnlYearly.selectDropdownParameters();
	}

	@Then("I am verify the report header for {string} and {string}")
	public void I_am_verify_the_report_header_for(String column , String year) throws InterruptedException {
		assertTrue(pnlYearly.verifyActualMainHeader(column,year));
	}
	
	@And("I change the view {string}")
	public void I_change_the_view(String string) throws InterruptedException {
		pnlYearly.changeTheView(string);
	}
	
	

}
