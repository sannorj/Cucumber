package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.propertyDashboard_AddComment_PageObjects;

public class propertyDashboard_AddComment_StepDefinition {
	propertyDashboard_AddComment_PageObjects dashboardAddCommentPo = new propertyDashboard_AddComment_PageObjects(
			DriverFactory.getDriver());

	@Given("Click on Add Comment button")
	public void click_on_add_comment_button() throws InterruptedException {
		dashboardAddCommentPo.clickAddComment();
	}

	@And("Verify Comment Popup form Loaded")
	public void verify_comment_popup_form_loaded() {
		assertTrue(dashboardAddCommentPo.verifyCommentPopup());
	}

	@Then("Fill all Form Data")
	public void fill_all_form_data() throws InterruptedException {
		dashboardAddCommentPo.FillData();
	}

	@When("Click on submit button")
	public void click_on_submit_button() throws InterruptedException {
		dashboardAddCommentPo.clickAddCommentSubmit();
	}

	@And("Verify Data successfully Submited and comment added")
	public void verify_data_successfully_submited_and_comment_added() throws InterruptedException {
		assertTrue(dashboardAddCommentPo.dataIsSubmited());
	}

	@Then("Click on View Past Comments link")
	public void click_on_view_past_comments_link() throws InterruptedException {
		dashboardAddCommentPo.clickViewPastComment();
	}

	@And("Naviage to View Comments page")
	public void naviage_to_view_comments_page() {
		assertTrue(dashboardAddCommentPo.navigateViewCommentPage());
	}

	@When("Check Submitted data is in View Comment table")
	public void check_submitted_data_is_in_view_comment_table() throws InterruptedException {
//		assertTrue(dashboardAddCommentPo.checkSubmittedData());
	}

}
