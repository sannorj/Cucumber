package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import myP2_pageObjects.PnLComparison_PageObject;


public class PnLComparisonStaticView_StepDefinition {
	
	private PnLComparison_PageObject pnlComparison = new PnLComparison_PageObject(DriverFactory.getDriver());
	
	@Given("go to the P&L Property Comparison")
	public void go_to_the_p_l_property_comparison() throws InterruptedException {
	    assertTrue(pnlComparison.navigatePnLComparison());
	}
	
	@Given("Select the Group , date,View and Click on GO button")
	public void select_the_group_date_view_and_click_on_go_button() throws InterruptedException {
		pnlComparison.selectParameters();
	}

}
