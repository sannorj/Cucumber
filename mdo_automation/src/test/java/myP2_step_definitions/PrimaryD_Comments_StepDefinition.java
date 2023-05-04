package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP2_pageObjects.PrimaryD_Comments_PageObject;

public class PrimaryD_Comments_StepDefinition {
	
	private PrimaryD_Comments_PageObject primaryDComments = new PrimaryD_Comments_PageObject(DriverFactory.getDriver());

	@Given("select the Group ,Property and Date")
	public void select_the_group_property_and_date() throws InterruptedException {
		primaryDComments.selectParameters();  
	}

	@Given("User click on the Add Comments page")
	public void user_click_on_the_add_comments_page() {
		assertTrue(primaryDComments.clickAddIconFunc());
	}

	@Given("User fill the all the mandatory fields and click on submit button")
	public void user_fill_the_all_the_mandotory_fields_and_click_on_submit_button() throws InterruptedException {
		primaryDComments.inputCommentParametersFunc();
	}

	@Then("Newly inserted comment should be visible for the relevant property.")
	public void a_newly_inserted_comment_should_be_visible_for_the_relevant_property() throws InterruptedException {
		assertTrue(primaryDComments.verifyNewlyAddedcommentFunc());
	}
	
	@When("Users click “All Replies” for a specific thread, they are redirected to a page where they see all the replies to that thread.")
	public void users_click_the_all_replies_for_a_specific_thread_they_are_redirected_to_a_page_where_they_see_all_the_replies_for_that_thread() throws InterruptedException {
		assertTrue(primaryDComments.clickOnAllCommentsFunc());
	}

	@When("User will be able to reply back to the thread")
	public void user_will_be_able_to_reply_back_to_the_thread() throws InterruptedException {
		assertTrue(primaryDComments.AddReplyFunc());
	}

	@Then("The newly added comments should be added to the appropriate username and property")
	public void newly_added_comments_should_be_added_to_the_appropriate_username_and_property() throws InterruptedException {
		assertTrue(primaryDComments.verifyRepliedUserDetailsFunc());
	}

	@And("User clicks the resolve option")
	public void user_clicks_the_resolve_option() throws InterruptedException {
		assertTrue(primaryDComments.MarkAsResolvedFunc());
	}

	@Then("Resolved comments should be moved from the active list to the Resolved Comments section.")
	public void resolved_comments_should_be_moved_from_the_active_list_to_the_resolved_comments_section() throws InterruptedException {
		assertTrue(primaryDComments.verifyResolvedCommentFunc());
	}

	@Then("User clicks the Active option")
	public void user_clicks_the_active_option() throws InterruptedException {
		assertTrue(primaryDComments.MarkAsActivateFunc());
	}

	@Then("Activated comments should be moved from the Resolved list to the active Comments section.")
	public void activated_comments_should_be_moved_from_the_resolved_list_to_the_active_comments_section() throws InterruptedException {
		assertTrue(primaryDComments.verifyActivatedCommentFunc());
	}
	
	
}
