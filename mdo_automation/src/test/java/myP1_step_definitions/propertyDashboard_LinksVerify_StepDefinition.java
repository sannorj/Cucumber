package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import myP1_pageObjects.propertyDashboard_LinksVerify_PageObjects;

public class propertyDashboard_LinksVerify_StepDefinition {

	propertyDashboard_LinksVerify_PageObjects dashboardLinksVerifyPo = new propertyDashboard_LinksVerify_PageObjects(
			DriverFactory.getDriver());

	@Given("verify Stats by Date Range page navigation")
	public void verify_stats_by_date_range_page_navigation() throws InterruptedException {
		assertTrue(dashboardLinksVerifyPo.verifyStatsByDateRange());
	}

	@Given("verify STR Report page navigation")
	public void verify_str_report_page_navigation() throws InterruptedException {
		assertTrue(dashboardLinksVerifyPo.verifySTRreport());
	}

	@Given("verify Pick-up Report page navigation")
	public void verify_pick_up_report_page_navigation() throws InterruptedException {
		assertTrue(dashboardLinksVerifyPo.verifyPickUpReport());
	}

	@Given("verify Labor page navigation")
	public void verify_labor_page_navigation() throws InterruptedException {
		assertTrue(dashboardLinksVerifyPo.verifyLaborReport());
	}


}
