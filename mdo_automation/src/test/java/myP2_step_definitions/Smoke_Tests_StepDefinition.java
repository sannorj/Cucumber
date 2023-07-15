package myP2_step_definitions;

import static org.junit.Assert.assertTrue;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.Smoke_Tests_PageObject;


public class Smoke_Tests_StepDefinition {
	
	private Smoke_Tests_PageObject smokeTests = new Smoke_Tests_PageObject(DriverFactory.getDriver());

	@Then("Page should load the defualt static section in the Primary Dashboard page")
	public void Page_should_load_the_defualt_static_section_in_the_Primary_Dashboard_page() throws InterruptedException {
		smokeTests.verifyPrimaryDashHeader(); 
	}
	
	@Then("User click on the Add Comments page and verify")
	public void user_click_on_the_add_comments_page_and_verify() throws InterruptedException {
		assertTrue(smokeTests.verifyAddCommentSection());
	}
	
	@Then("User click the View Comments section and verify")
	public void user_click_the_View_comments_section_and_verify() throws InterruptedException {
		smokeTests.viewCommentsSection();
	}
	
	@Then("User click close button")
	public void User_click_close_button() throws InterruptedException {
		smokeTests.clickCloseButt();
	}
	
	@Then("User navigate to Copy Dashboard page by clicking Copy Dashboard Settings Icon")
	public void User_navigate_to_Copy_Dashboard_page_by_clicking_Copy_Dashboard_Settings_Icon() throws InterruptedException {
		smokeTests.copyDashboard();
	}

	@Then("Page should load the defualt static section in the Trend Dashboard page")
	public void page_should_load_the_defualt_static_section_in_the_trend_dashboard_page() throws InterruptedException {
		smokeTests.verifyTdWidgetsHeader(); 
	}
	
	@Then("user clicks Commissions Calculator button and verify the page")
	public void user_clicks_Commissions_Calculator_button_and_verify_the_page() throws InterruptedException {
		smokeTests.verifyCommissionsCal(); 
	}

	@Then("user click cancel button")
	public void user_click_cancel_button() throws InterruptedException {
		smokeTests.cancelButtClick(); 
	}
	
	@Then("user click Filter option button and verify it")
	public void user_click_Filter_option_button_and_verify_it() throws InterruptedException {
		smokeTests.verifyFilterOpt(); 
	}
	
}