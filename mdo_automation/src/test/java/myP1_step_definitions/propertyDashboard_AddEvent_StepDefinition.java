package myP1_step_definitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myP1_pageObjects.propertyDashboard_AddEvent_PageObjects;

public class propertyDashboard_AddEvent_StepDefinition {

	propertyDashboard_AddEvent_PageObjects dashboardAddEventPo = new propertyDashboard_AddEvent_PageObjects(
			DriverFactory.getDriver());

	@Given("Click on Add Event button")
	public void click_on_add_event_button() throws InterruptedException {
		dashboardAddEventPo.clickAddEvent();
	}

	@And("Verify Add Event Popup form Loaded")
	public void verify_add_event_popup_form_loaded() throws InterruptedException {
		assertTrue(dashboardAddEventPo.verifyAddEventLoaded());
	}

	@Then("Fill all Event Form Data without Repeat option")
	public void fill_all_event_form_data_without_repeat_option() {
		dashboardAddEventPo.fillFormDataWithoutRepeat();
	}

	@When("Click on submit button of Event")
	public void click_on_submit_button_of_event() {
		dashboardAddEventPo.clickNotRepeatSubmit();
	}

	@And("Verify not repeat Data successfully Submited")
	public void verify_not_repeat_data_successfully_submited() {
		assertTrue(dashboardAddEventPo.verifyNotRepeatSubmitted());
	}

	@Then("Fill all Event Form Data with Repeat option")
	public void fill_all_event_form_data_with_repeat_option() throws InterruptedException {
		dashboardAddEventPo.fillAllDataWithRepeat();
	}

	@And("Verify repeated Data successfully Submited")
	public void verify_repeated_data_successfully_submited() throws InterruptedException {
		assertTrue(dashboardAddEventPo.verifyRepeatedDataSubmitted());
	}

	@Given("Verify Added Events are popup")
	public void verify_added_events_are_popup() throws InterruptedException {
		assertTrue(dashboardAddEventPo.verifyAddedEventPopup());
	}

	@Then("Check the Events by clicking calendar")
	public void check_the_event_by_clicking_calendar() throws InterruptedException {
		assertTrue(dashboardAddEventPo.checkCalendarEvent());
	}

	@And("Delete Events")
	public void delete_event() throws InterruptedException {
		dashboardAddEventPo.deleteEvents();
	}

	@When("Check Events deleted successfully")
	public void check_event_deleted_successfully() throws InterruptedException {
		assertTrue(dashboardAddEventPo.checkEventsDeleted());
	}
}
