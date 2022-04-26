package myP2_step_definitions;

import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

	@Then("a newly inserted comment should be visible for the relevant property.")
	public void a_newly_inserted_comment_should_be_visible_for_the_relevant_property() throws InterruptedException {
		assertTrue(primaryDComments.verifyNewlyAddedcommentFunc());
	}
	
	
}
