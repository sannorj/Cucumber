package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.AR_Aging_Detail_PageObjects;

public class AR_Aging_Detail_StepDefinition {

	AR_Aging_Detail_PageObjects ARagingPo = new AR_Aging_Detail_PageObjects(DriverFactory.getDriver());
	

	@Then("Click on Link Reports {string} navigation Link")
	public void click_on_link_reports_navigation_link(String string) throws InterruptedException {
		ARagingPo.clickOnLink(string);
	}
	
	@Given("Click on Link Accounts Receivable {string} navigation Link")
	public void click_on_link_accounts_receivable_navigation_link(String string) throws InterruptedException {
		ARagingPo.clickOnLink(string);
	}
	
	@When("Click on Link AR Aging Summary {string} navigation Link")
	public void click_on_link_ar_aging_summary_navigation_link(String string) throws InterruptedException {
		ARagingPo.clickOnLink(string);
	}
	
	@When("I navigate to AR Aging Detail page")
	public void i_navigate_to_ar_aging_detail_page() {
	    assertTrue(ARagingPo.navigateToARAging());
	}
	
	@Then("Select Hotel filter option")
	public void select_hotel_filter_option() throws InterruptedException {
		ARagingPo.selectHotel();
	}
	
	@Given("Select SelectBy filter option")
	public void select_select_by_filter_option() throws InterruptedException {
		ARagingPo.selectSelectBy();
	}
	
	@Given("Select Current Date option")
	public void select_current_date_option() throws InterruptedException {
	    ARagingPo.selectCurrentDate();
	}
	
	@When("Click on Update button")
	public void click_on_update_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("Calculate each column total and each verify total values")
	public void calculate_each_column_total_and_each_verify_total_values() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("Calculate each raw total and verify each total values")
	public void calculate_each_raw_total_and_verify_each_total_values() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("Verify Add Comment button and select option")
	public void verify_add_comment_button_and_select_option() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("Verify Close button")
	public void verify_close_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("Verify View Past comments link and navigate to page")
	public void verify_view_past_comments_link_and_navigate_to_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
