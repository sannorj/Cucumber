package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import myP1_pageObjects.scorecardDashboard_AddComment_pageObjects;

public class scorecardDashboard_AddComment_StepDefinition {

	scorecardDashboard_AddComment_pageObjects dashboardAddComment = new scorecardDashboard_AddComment_pageObjects(
			DriverFactory.getDriver());

	@And("Verify Data successfully Submited")
	public void verify_data_successfully_submited() {
		assertTrue(dashboardAddComment.verifySubmitted());
	}

	@Then("Fill Form Data")
	public void fill_form_data() throws InterruptedException {
		dashboardAddComment.FillData();
	}

	@Then("Click on View Past Comments")
	public void click_on_view_past_comments() throws InterruptedException {
		dashboardAddComment.clickViewPastComment();
	}

}
