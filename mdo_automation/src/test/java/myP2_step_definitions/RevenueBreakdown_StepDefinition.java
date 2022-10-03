package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import myP2_pageObjects.RevenueBreakdwon_PageObject;

public class RevenueBreakdown_StepDefinition {

	RevenueBreakdwon_PageObject reveneuePO = new RevenueBreakdwon_PageObject(DriverFactory.getDriver());

	@When("I am expand the Revenue Breakdwon option under Reports section in Side Menu")
	public void I_am_expand_the_Revenue_Breakdwon_option_under_Reports_section_in_Side_Menu()
			throws InterruptedException {
		reveneuePO.expandRevenue();
	}

	@And("I am navigate to Revenue Breakdown page")
	public void I_am_navigate_to_Revenue_Breakdown_page() throws InterruptedException {
		assertTrue(reveneuePO.navigateToRevenueBreakDown());
	}

	@And("I am Loading the Revenue Breakdown Report with GO button")
	public void I_am_Loading_the_Revenue_Breakdown_Report_with_GO_button() throws InterruptedException {
		assertTrue(reveneuePO.loadReportWithParameters());
		assertTrue(reveneuePO.loadRevenueReport());
	}

}
