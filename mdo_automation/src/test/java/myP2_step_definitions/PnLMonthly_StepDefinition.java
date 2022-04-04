package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.PnLMonthly_PageObject;


public class PnLMonthly_StepDefinition {
	
	private PnLMonthly_PageObject pnlMonthly = new PnLMonthly_PageObject(DriverFactory.getDriver());
	
	@And("go to the P&L Monthly page")
	public void i_am_navigate_to_p_l_monthly_page() {
		assertTrue(pnlMonthly.navigatePnLMonthlyPage());
	}

	
	@When("select the Group ,Propery, date,View and Click on GO button")
	public void select_the_group_propery_date_view_and_click_on_go_button() {
		pnlMonthly.selectParameters();
	}
	
	@Then("Page should load the defualt static section")
	public void page_should_load_the_defualt_static_section(io.cucumber.datatable.DataTable dataTable) {
		assertTrue(pnlMonthly.verifyStaticSection());
	}

}


