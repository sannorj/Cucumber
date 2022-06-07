package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.AR_Account_PageObjective;

public class AR_Account_StepDefinition {

	AR_Account_PageObjective ARaccountPo = new AR_Account_PageObjective(DriverFactory.getDriver());
	
	@Then("I am navigate to AR Account page")
	public void I_am_navigate_to_AR_Account_page() {
		assertTrue(ARaccountPo.navigateToARAccountPage());
	}
	
	@When("I select the Account and Date")
	public void i_select_the_Account_and_date() throws InterruptedException {
		ARaccountPo.loadPageWithParameters();
	}
	
	@Then("I am loading ar Account report with Go button")
	public void i_am_loading_ar_Account_report_with_go_button() throws InterruptedException {
		assertTrue(ARaccountPo.loadArAccountReport());
	}
	
	@Given("I am storing all the account values")
	public void i_am_storing_all_the_account_values() {
		ARaccountPo.storeAlltheAccountRecords();
	}
	
	@And("I am sorting all the account values")
	public void i_am_sorting_all_the_account_values() {

		ARaccountPo.calulateArAccountMaxValue();
	}
	
	@And("Verify whether the AR account RED Outstanding values are correctly highlighted")
	public void verify_whether_the_AR_Account_RED_Outstanding_values_are_correctly_highlighted() {
		assertTrue(ARaccountPo.verifyArAccountRedOutstanding());
	}
	
	@And("Verify whether the AR account Yellow Outstanding values are correctly highlighted")
	public void verify_whether_the_AR_Account_Yellow_Outstanding_values_are_correctly_highlighted() {
		assertTrue(ARaccountPo.verifyArAccountRedOutstanding());
	}
}
