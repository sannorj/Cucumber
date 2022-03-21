package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import myP2_pageObjects.PnLYearly_PageObject;

public class PnLYearly_StepDefinition {
	
	private PnLYearly_PageObject pnlYearly = new PnLYearly_PageObject(DriverFactory.getDriver());


	@Given("I am expand the P&L Statement option under Reports section in Side Menu")
	public void i_am_expand_the_p_l_statement_option_under_reports_section_in_side_menu() {
		pnlYearly.expandPnLStatement();
	}
	
	@Then("I am navigate to P&L Yearly page")
	public void i_am_navigate_to_p_l_yearly_page() {
	    assertTrue(pnlYearly.navigatePnLYearlyPage());
	}



}
