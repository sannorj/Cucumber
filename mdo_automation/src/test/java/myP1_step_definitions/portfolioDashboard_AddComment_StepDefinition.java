package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.portfolioDashboard_AddComment_PageObjects;

public class portfolioDashboard_AddComment_StepDefinition {

	portfolioDashboard_AddComment_PageObjects dashboardAddCommentPo = new portfolioDashboard_AddComment_PageObjects(
			DriverFactory.getDriver());

	@Given("Click on Portfolio Add Comment button")
	public void click_on_portfolio_add_comment_button() {
		assertTrue(dashboardAddCommentPo.clickAddComment());
	}

	@And("Verify Portfolio Comment Popup form Loaded")
	public void verify_portfolio_comment_popup_form_loaded() throws InterruptedException {
		assertTrue(dashboardAddCommentPo.verifyAddCommentPopup());
	}

	@When("Select a Hotel")
	public void select_a_hotel() throws InterruptedException {
		assertTrue(dashboardAddCommentPo.selectHotel());
	}
	
	@Then("Fill all Form Data in Portfolio")
	public void fill_all_form_data_in_portfolio() throws InterruptedException {
		dashboardAddCommentPo.FillData();
	}

	@When("Click on submit button in Portfolio")
	public void click_on_submit_button_in_portfolio() throws InterruptedException {
		dashboardAddCommentPo.clickAddCommentSubmit();
	}

	@And("Verify Portfolio Data successfully Submited and comment added")
	public void verify_portfolio_data_successfully_submited_and_comment_added() throws InterruptedException {
		assertTrue(dashboardAddCommentPo.dataIsSubmited());
	}
	
	@Then("Click on Portfolio View Past Comments link")
	public void click_on_portfolio_view_past_comments_link() throws InterruptedException {
		dashboardAddCommentPo.clickViewPastComment();
	}

}
